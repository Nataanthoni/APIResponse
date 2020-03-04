package com.killasites.apiresponse.data


data class Result(
    val count: Int,
    val next: String,
    val previous: Any,
    val aApiCallsResponses: List<ApiCallsResponse>
)