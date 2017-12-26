package com.ruatta.gary.plugins

import com.ruatta.gary.response.ResponseType
import com.wire.bots.sdk.models.TextMessage

trait Plugin {

  val name: String

  def processMessage(text: TextMessage): ResponseType

}
