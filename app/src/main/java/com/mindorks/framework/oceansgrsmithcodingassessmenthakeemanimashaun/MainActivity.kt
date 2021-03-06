package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.databinding.ActivityMainBinding
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.repository.Repository
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel.PostViewModel
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.viewModel.ViewModelFactory
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.ConnectivityLiveData

class MainActivity : AppCompatActivity() {
    lateinit var postViewModel: PostViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var connectivityLiveData: ConnectivityLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        // set up context to access app network state
        connectivityLiveData = ConnectivityLiveData(this)
        super.onCreate(savedInstanceState)
        //sets application theme
        setTheme(R.style.Theme_OceansgrsmithCodingAssessmentHakeemAnimashaun)
        // inflates the view that's inflated by the layout inflater, in this case the details fragment
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // instance of repository
        val postsRepository = Repository()
        // set up view model
        val postsViewModelProviderFactory = ViewModelFactory(postsRepository)
        postViewModel =
            ViewModelProvider(this, postsViewModelProviderFactory)[PostViewModel::class.java]
        // observe network state
        connectivityLiveData.observe(this, { networkState ->
            if (networkState == true) binding.noNetwork.visibility = View.GONE
            else binding.noNetwork.visibility = View.VISIBLE
        })

        // Attaching the controller to the Bottom Navigation View
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

}