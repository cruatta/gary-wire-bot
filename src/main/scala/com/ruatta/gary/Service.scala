package com.ruatta.gary

import com.ruatta.gary.client.CatFactNinjaClient
import com.wire.bots.sdk.{MessageHandlerBase, Server}
import io.dropwizard.setup.Environment

object Service {

  def main(args: Array[String]): Unit = {
    new Service().run(args:_*)
  }

}

class Service extends Server[Config] {

  override protected def createHandler(config: Config, env: Environment): MessageHandlerBase = {
    val cfnc: CatFactNinjaClient = new CatFactNinjaClient()
    implicit val mp: MessageProcessor = new MessageProcessor(cfnc)

    new MessageHandler(config, env, repo)
  }

}
