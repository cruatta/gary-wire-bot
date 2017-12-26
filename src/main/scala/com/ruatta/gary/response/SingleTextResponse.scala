package com.ruatta.gary.response

import com.wire.bots.sdk.WireClient
import com.wire.bots.sdk.models.TextMessage

class SingleTextResponse(message: String) extends ResponseType {
  override def send(client: WireClient, replyTo: TextMessage): Unit = {
    client.sendText(message)
  }
}

object SingleTextResponse {

  def apply(message: String): SingleTextResponse =
    new SingleTextResponse(message: String)

}