package be.jwa.filters

import akka.NotUsed
import akka.stream.scaladsl.Flow
import be.jwa.sources.Tweet

object FilterHashtags {
  def flow(hashTag: String): Flow[Tweet, Tweet, NotUsed] =
    Flow[Tweet].filter(t => t.hashTags.contains(hashTag.toLowerCase))

}
