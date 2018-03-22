package com.ruatta.gary

import com.ruatta.gary.plugins.CatFactPlugin
import com.ruatta.gary.plugins.catfact.client.CatFactNinjaClient
import com.wire.bots.sdk.tools.Logger
import com.wire.bots.sdk.{MessageHandlerBase, Server}
import io.dropwizard.setup.Environment

object Service {

  def main(args: Array[String]): Unit = {
    new Service().run(args:_*)
  }

}

class Service extends Server[Config] {

  override protected def createHandler(config: Config, env: Environment): MessageHandlerBase = {
    val catFactPlugin: CatFactPlugin = new CatFactPlugin(new CatFactNinjaClient)
    val plugins = Seq(catFactPlugin)

    Logger.info(s"Enabled plugins: ${plugins.map(_.name).mkString(",")}")

    implicit val messageProcessor: MessageProcessor = new MessageProcessor(plugins)

    new MessageHandler(config, env, repo)
  }

}
