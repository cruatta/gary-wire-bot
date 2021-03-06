package com.ruatta.gary

import com.wire.bots.sdk.tools.Logger
import com.wire.bots.sdk.{ClientRepo, MessageHandlerBase, WireClient}
import io.dropwizard.setup.Environment
import com.wire.bots.sdk.models.TextMessage
import com.wire.bots.sdk.server.model.NewBot

class MessageHandler(config: Config, env: Environment, repo: ClientRepo)
                     (implicit messageProcessor: MessageProcessor) extends MessageHandlerBase {

  override def onNewBot(newBot: NewBot): Boolean = {
    Logger.info(String.format("User requested new bot: user: %s/%s, conversation: %s/%s",
                      newBot.origin.id,
                      newBot.origin.name,
                      newBot.conversation.id,
                      newBot.conversation.name))
    config.adminId == newBot.origin.id
  }
  
  override def onText(client: WireClient, msg: TextMessage): Unit = {
    try {
      val response = messageProcessor.getResponse(msg)
      response.send(client, msg)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

}
