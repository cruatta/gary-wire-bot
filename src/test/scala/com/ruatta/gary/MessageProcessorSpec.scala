package com.ruatta.gary

import com.ruatta.gary.plugins.CatFactPlugin
import com.ruatta.gary.plugins.catfact.response.CatFactResponse

import com.ruatta.gary.response.NoResponse
import com.ruatta.gary.plugins.catfact.client.CatFactNinjaClient
import org.scalatest.WordSpec
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import com.wire.bots.sdk.models._

class MessageProcessorSpec extends WordSpec with MockitoSugar {

  val catFactsNinjaClient: CatFactNinjaClient = mock[CatFactNinjaClient]

  val mp = new MessageProcessor(Seq(new CatFactPlugin(catFactsNinjaClient)))

  "A MessageProcessor with CatFactPlugin enabled" when {
    "there is a successful match" should {
      when(catFactsNinjaClient.getCatFact).thenReturn(Some("Cat Fact: I'm a cat!"))
      val txt = new TextMessage("h", "h", "h", "h")
      txt.setText("Cats are great!")

      "return a CatFactResponse" in {
        assert(mp.getResponse(txt).isInstanceOf[CatFactResponse])
      }
    }
    "there is not a match" should {
      val txt = new TextMessage("h", "h", "h", "h")
      txt.setText("Dogs are great!")

      "return a NoResponse" in {
        assert(mp.getResponse(txt).equals(NoResponse))
      }
    }
  }
}
