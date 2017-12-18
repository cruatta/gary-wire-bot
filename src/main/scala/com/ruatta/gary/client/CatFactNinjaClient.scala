package com.ruatta.gary.client

import com.wire.bots.sdk.Logger
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._

import scalaj.http._


class CatFactNinjaClient() {

  sealed case class CatFactNinjaFact(fact: String, length: Int)

  def getCatFact: Option[String] = {
    callFactApiEndpoint match {
      case Some(response: String) => {
        decodeJson(response).map(_.fact)
      }
      case None => None
    }
  }

  protected def callFactApiEndpoint: Option[String] = {
    try {
      val response: HttpResponse[String] = Http("https://catfact.ninja/fact").asString
      Some(response.body)
    } catch {
      case e: HttpStatusException =>
        Logger.error(e.toString)
        None
    }
  }

  protected def decodeJson(response: String): Option[CatFactNinjaFact] = {
    val factOrError = decode[CatFactNinjaFact](response)
    factOrError match {
      case Right(x: CatFactNinjaFact) =>
        Some(x)
      case Left(y: Error) =>
        Logger.error(y.toString)
        None
    }
  }
}
