package com.ruatta.gary.response

import com.wire.bots.sdk.WireClient
import com.wire.bots.sdk.models.TextMessage

class CatFactResponse(message: String) extends ResponseType {
  override def send(client: WireClient, replyTo: TextMessage): Unit = {
    client.sendText(message)
  }
}

object CatFactResponse {

  def apply(message: String): CatFactResponse =
    new CatFactResponse(message: String)

}