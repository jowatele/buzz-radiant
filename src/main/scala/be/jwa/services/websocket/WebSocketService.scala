package be.jwa.services.websocket

import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.server.{Directives, Route}
import akka.util.Timeout
import be.jwa.directive.CorsSupport
import be.jwa.json.TwitterJsonSupport

import scala.concurrent.ExecutionContext

trait WebSocketService extends Directives with TwitterJsonSupport with CorsSupport with WebSocketFactory {
  lazy val websocketRoute: Route = cors {
    path("observers" / JavaUUID / "ws") { observerId =>
      handleWebSocketMessages(getOrCreateWebsocketHandler(observerId).flow)
    }
  }
  implicit val timeout: Timeout
  implicit val system: ActorSystem
  implicit val ec: ExecutionContext
  val buzzObserverActor: ActorRef
}
