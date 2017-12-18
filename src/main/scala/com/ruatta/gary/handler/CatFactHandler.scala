package com.ruatta.gary.handler

import com.ruatta.gary.response.{CatFactResponse, NoResponse, ResponseType}
import com.ruatta.gary.client.CatFactNinjaClient

trait CatFactHandler {

  val catFactsNinjaClient: CatFactNinjaClient

  object CatFactHandler {

    def getCatFactResponse: ResponseType = {
      val response = catFactsNinjaClient.getCatFact
      response match {
        case Some(fact) => CatFactResponse("Cat Fact: " + fact)
        case _ => NoResponse
      }
    }
  }

}
