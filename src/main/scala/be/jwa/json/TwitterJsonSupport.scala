package be.jwa.json

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import be.jwa.actors.{GeolocationCount, PlaceCount}
import be.jwa.controllers._
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait TwitterJsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val timeStatisticsJsonFormat: RootJsonFormat[TimeStatistic] = jsonFormat3(TimeStatistic)
  implicit val twitterStatisticsJsonFormat: RootJsonFormat[TwitterStatistics] = jsonFormat3(TwitterStatistics)
  implicit val twitterUserJsonFormat: RootJsonFormat[TwitterUser] = jsonFormat7(TwitterUser)
  implicit val twitterPlaceJsonFormat: RootJsonFormat[TwitterPlace] = jsonFormat6(TwitterPlace)
  implicit val geolocationPlaceJsonFormat: RootJsonFormat[TwitterGeolocation] = jsonFormat2(TwitterGeolocation)
  implicit val tweetJsonFormat: RootJsonFormat[Tweet] = jsonFormat7(Tweet)
  implicit val placeCountJsonFormat: RootJsonFormat[PlaceCount] = jsonFormat1(PlaceCount)
  implicit val geolocationCountJsonFormat: RootJsonFormat[GeolocationCount] = jsonFormat1(GeolocationCount)
}