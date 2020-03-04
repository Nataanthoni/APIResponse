package com.killasites.apiresponse.model

import com.google.gson.annotations.SerializedName

data class Listing (
  val id: String,
  @SerializedName("img_src")
  val imgSrcUrl: String,
  val type: String,
  val price: Double
)
