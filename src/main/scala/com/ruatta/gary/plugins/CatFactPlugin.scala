package com.ruatta.gary.plugins

import com.ruatta.gary.plugins.catfact.client.CatFactNinjaClient
import com.ruatta.gary.plugins.catfact.response.CatFactResponse
import com.ruatta.gary.response.{NoResponse, ResponseType}
import com.wire.bots.sdk.models.TextMessage

import scala.util.matching.Regex

class CatFactPlugin(client: CatFactNinjaClient) extends Plugin {

  val Match: Regex = ".*\\b([Cc][Aa][Tt][Ss]?)\\b.*".r

  override val name = "CatFactsPlugin"

  override def processMessage(msg: TextMessage): ResponseType = {
    matchAndReply(msg.getText)
  }

  protected def getCatFactResponse: ResponseType = {
    val response: Option[String] = client.getCatFact
    response match {
      case Some(fact) => CatFactResponse("Cat Fact: " + fact)
      case _ => NoResponse
    }
  }

  protected def matchAndReply(text: String): ResponseType = {
    text match {
      case Match(_) => getCatFactResponse
      case _ => NoResponse
    }
  }

}
