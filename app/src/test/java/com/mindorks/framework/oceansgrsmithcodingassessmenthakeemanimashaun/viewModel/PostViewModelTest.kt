package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel
import com.google.common.truth.Truth.assertThat
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.getOrAwaitValueTest
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.repository.Repository
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel.PostViewModel


import org.junit.Before
import org.junit.Test

class PostViewModelTest {
    private lateinit var viewModel: PostViewModel

    @Before
    fun setup(){
    viewModel = PostViewModel(Repository())
    }

    @Test
    fun `get post returns post and all posts livedata is same as get post call result`(){
        viewModel.getPosts()
        val result  = viewModel.allPosts.getOrAwaitValueTest()
        assertThat(result).isEqualTo(viewModel.getPosts())
    }

}