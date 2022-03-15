package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.adapter.Adapter
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.databinding.FragmentDetailsBinding
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.Resource
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.viewextensions.provideCustomAlertDialog
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel.PostViewModel
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.ConnectivityLiveData


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var dialog:Dialog
    private lateinit var connectivityLiveData: ConnectivityLiveData
    private lateinit var postsViewModel: PostViewModel
    lateinit var postsAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectivityLiveData = (activity as MainActivity).connectivityLiveData
        postsViewModel = (activity as MainActivity).postViewModel
        dialog = provideCustomAlertDialog()
        setupRecyclerView()

        connectivityLiveData.observe(viewLifecycleOwner,{networkState->
            if (networkState == true){
                postsViewModel.getPosts()
            }
        })

        // observe to know if all posts are retrieved
        postsViewModel.allPosts.observe(viewLifecycleOwner, { response ->
            when(response) {
                is Resource.Success -> {
                    dialog.dismiss()
                    response.data?.let { postsResponse ->
                        val pass = postsResponse.toMutableList()
                        postsAdapter.differ.submitList(pass)
                    }
                }
                is Resource.Error -> {
                    dialog.dismiss()
                    response.message?.let { errorMessage ->
                        Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    dialog.show()
                }
            }
        })
    }
    // recyclerview and layout manager setup
    private fun setupRecyclerView() {
        postsAdapter = Adapter()
        val postsRecyclerView = binding.recyclerView
        postsRecyclerView.adapter = postsAdapter
        postsRecyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}