package com.ruatta.gary

import com.ruatta.gary.plugins.Plugin
import com.ruatta.gary.response.ResponseType
import com.wire.bots.sdk.models.TextMessage

class MessageProcessor(plugins: Seq[Plugin]) {

  def getResponse(msg: TextMessage): ResponseType = {
    plugins.map(_.processMessage(msg)).head
  }

}
