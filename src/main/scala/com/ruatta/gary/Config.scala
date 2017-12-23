package com.ruatta.gary

import com.fasterxml.jackson.annotation.JsonProperty
import com.wire.bots.sdk.Configuration

class Config extends Configuration {

  val adminHandle: String = Configuration.propOrEnv("adminHandle", "GARY_ADMIN_HANDLE")

  def getAdminHandle: String = adminHandle
}
