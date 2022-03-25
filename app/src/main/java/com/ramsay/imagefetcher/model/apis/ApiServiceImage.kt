package com.ramsay.imagefetcher.model.apis

import com.ramsay.imagefetcher.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceImage {

    @GET("/v2/list")

    suspend fun getDetails(@Query("page") page: Int): ResponseModel
}