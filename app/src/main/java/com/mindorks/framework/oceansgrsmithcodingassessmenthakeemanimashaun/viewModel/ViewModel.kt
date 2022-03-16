package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models.Species
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models.SpeciesItem
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.repository.Repository
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class PostViewModel(
    private val postRepository: Repository
) : ViewModel() {
    // saves all posts retrieved from the API
    val allPosts: MutableLiveData<Resource<Array<SpeciesItem>>> = MutableLiveData()

    // makes API call with view model scope and saves in livedata
    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            allPosts.postValue(Resource.Loading())
            val result = postRepository.getPosts()
            allPosts.postValue(handlePostResponse(result))
        }
    }

    // function to handle post response for API call operation
    private fun handlePostResponse(result: Response<Array<SpeciesItem>>): Resource<Array<SpeciesItem>>? {
        if (result.isSuccessful) {
            result.body()?.let { postResult ->
                return Resource.Success(postResult)
            }
        }
        return Resource.Error(result.message())
    }
}
