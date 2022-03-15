package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.network

import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SpecieApi by lazy {
        retrofit.create(SpecieApi::class.java)
    }
}