package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.repository

import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.network.RetrofitInstance


class Repository {
    suspend fun getPosts() = RetrofitInstance.api.getPosts()

}