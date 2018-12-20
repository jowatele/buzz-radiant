package be.jwa.controllers.graph

import akka.NotUsed
import akka.actor.ActorRef
import akka.pattern.ask
import akka.stream.scaladsl.{Flow, GraphDSL, RunnableGraph, Sink, Source}
import akka.stream.{ClosedShape, KillSwitches, UniqueKillSwitch}
import akka.util.Timeout
import be.jwa.actors.TwitterActor.AddTweet
import be.jwa.controllers.Tweet
import be.jwa.flows.ParserStatus
import twitter4j.Status

trait TwitterGraphMaker {
  implicit val timeout: Timeout
  private val switch = KillSwitches.single[Tweet]

  def makeTwitterGraph(twitterSource: Source[Status, NotUsed], tweetActor: ActorRef): RunnableGraph[UniqueKillSwitch] = {

    RunnableGraph.fromGraph(GraphDSL.create(switch) { implicit builder =>
      killSwitch =>
        import akka.stream.scaladsl.GraphDSL.Implicits._

        val log = Flow[Tweet].log("tweetStream")

        twitterSource ~> ParserStatus.parse ~> log ~> killSwitch ~> Sink.foreach[Tweet](t => tweetActor ? AddTweet(t))

        ClosedShape
    })
  }
}