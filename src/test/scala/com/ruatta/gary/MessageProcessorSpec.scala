package com.ruatta.gary

import com.ruatta.gary.response.CatFactResponse
import com.ruatta.gary.client.CatFactNinjaClient
import com.wire.bots.sdk.WireClient
import org.scalatest.WordSpec
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

class MessageProcessorSpec extends WordSpec with MockitoSugar {

  val cfcli: CatFactNinjaClient = mock[CatFactNinjaClient]
  implicit val wirecli: WireClient = mock[WireClient]
  val mp = new MessageProcessor(cfcli)

  "A MessageProcessor" when {
    "isCatsType is called on a successful match" should {
      when(cfcli.getCatFact).thenReturn(Some("Cat Fact: I'm a cat!"))
      "return a CatFactResponse" in {
        assert(mp.isCatsType("Cats are great").isInstanceOf[CatFactResponse])
      }
    }
  }

}
