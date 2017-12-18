package com.ruatta.gary.response

import com.wire.bots.sdk.WireClient
import com.wire.bots.sdk.models.TextMessage

trait ResponseType {

  def send(client: WireClient, replyTo: TextMessage): Unit

}
