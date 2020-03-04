package com.killasites.apiresponse.network


import com.killasites.apiresponse.data.Result
import com.killasites.apiresponse.model.Listing
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET( "realestate")
    fun getSwapiResponse(

    ): Call<List<Listing>>
}