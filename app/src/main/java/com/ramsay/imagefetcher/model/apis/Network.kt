package com.ramsay.imagefetcher.model.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    private fun getNetworkInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    fun apiService() : ApiServiceImage = getNetworkInstance().create(ApiServiceImage::class.java)
}