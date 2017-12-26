package com.ruatta.gary.plugins.catfact.response

import com.ruatta.gary.response.SingleTextResponse

case class CatFactResponse(message: String) extends SingleTextResponse(message)

