package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.utils.ConnectivityLiveData


class GalleryFragment : Fragment() {

    private val args: GalleryFragmentArgs by navArgs()
    private lateinit var connectivityLiveData: ConnectivityLiveData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        val value = args.post
        val galleryTv = view.findViewById<TextView>(R.id.gallery_tv)
        galleryTv.text = value.SpeciesName
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectivityLiveData = (activity as MainActivity).connectivityLiveData

        connectivityLiveData.observe(viewLifecycleOwner, { networkState ->
            if (networkState == true) {
                // There is network,  display on viewPager
                //val adapter = ViewPagerAdapter(value)
                //ViewPager.adapter = 
            }
        })
    }

}