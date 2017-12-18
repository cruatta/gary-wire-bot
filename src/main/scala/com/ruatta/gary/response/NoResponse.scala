package com.ruatta.gary.response

import com.wire.bots.sdk.WireClient
import com.wire.bots.sdk.models.TextMessage

object NoResponse extends ResponseType
{
  override def send(client: WireClient, replyTo: TextMessage): Unit = Unit
}
