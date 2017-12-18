package com.ruatta.gary

import com.wire.bots.sdk.Configuration

class Config extends Configuration {

  val getAdminHandle: Option[String] = sys.env.get("GARY_ADMIN_HANDLE")
}
