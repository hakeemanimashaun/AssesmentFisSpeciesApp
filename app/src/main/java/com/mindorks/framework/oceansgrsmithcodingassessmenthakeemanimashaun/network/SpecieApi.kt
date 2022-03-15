package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.network

import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models.Species
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models.SpeciesItem
import retrofit2.Response
import retrofit2.http.GET

interface SpecieApi {
    @GET("species")
    suspend fun getPosts(): Response<Array<SpeciesItem>>
}