package be.jwa.json

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import be.jwa.actors.TweetCount
import be.jwa.sources.Tweet
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait TweetJsonSupport extends SprayJsonSupport with DefaultJsonProtocol with UUIDJsonFormatter {

  implicit val tweetJsonFormat: RootJsonFormat[Tweet] = jsonFormat5(Tweet)
  implicit val tweetsCountJsonFormat: RootJsonFormat[TweetCount] = jsonFormat1(TweetCount)
}
