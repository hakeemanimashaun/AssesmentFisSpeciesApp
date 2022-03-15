package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.repository.Repository

class ViewModelFactory(
    private val postRepository: Repository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}
