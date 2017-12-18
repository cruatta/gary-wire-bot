package com.ruatta.gary

import com.ruatta.gary.handler.CatFactHandler
import com.ruatta.gary.response.{NoResponse, ResponseType}
import com.ruatta.gary.client.CatFactNinjaClient
import com.wire.bots.sdk.models.TextMessage

import scala.util.matching.Regex

class MessageProcessor(catFactNinjaClient: CatFactNinjaClient) extends CatFactHandler {

  override val catFactsNinjaClient: CatFactNinjaClient = catFactNinjaClient

  object Matches {
    val CatFactMatch: Regex = ".*\\b([Cc][Aa][Tt][Ss]?)\\b.*".r
  }

  def getResponse(msg: TextMessage): ResponseType = {
    isCatsType(msg.getText)
  }

  def isCatsType(text: String): ResponseType = {
    text match {
      case Matches.CatFactMatch(_) => CatFactHandler.getCatFactResponse
      case _ => NoResponse
    }
  }
}
