package com.ruatta.gary

import com.wire.bots.sdk.Configuration

class Config extends Configuration {

  val getAdminHandle: Option[String] = {
    try {
      Some(Configuration.propOrEnv("adminHandle", "GARY_ADMIN_HANDLE"))
    } catch {
      case _: Exception => None
    }

  }
}
