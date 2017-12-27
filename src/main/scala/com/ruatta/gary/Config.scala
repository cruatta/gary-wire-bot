package com.ruatta.gary

import com.fasterxml.jackson.annotation.JsonProperty
import com.wire.bots.sdk.Configuration

class Config extends Configuration {

  val adminId: String = Configuration.propOrEnv("adminId", "GARY_ADMIN_ID")

  def getAdminId: String = adminId
}
