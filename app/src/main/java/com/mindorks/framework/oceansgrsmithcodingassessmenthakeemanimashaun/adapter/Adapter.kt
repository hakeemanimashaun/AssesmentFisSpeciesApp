package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.DetailsFragmentDirections
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.R
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models.SpeciesItem

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private var nameTextView: TextView = itemView.findViewById(R.id.name_tv)
        private var imageView: ImageView = itemView.findViewById(R.id.illustration_tv)
        private var habitatImpactsTextView: TextView =
            itemView.findViewById(R.id.habitat_impacts_tv)

        //attaches the retrieved data to the view and displays them
        fun setData(speciesItem: SpeciesItem) = with(itemView) {
            nameTextView.text = speciesItem.SpeciesName
            habitatImpactsTextView.text = speciesItem.HabitatImpacts
            Glide.with(context).load(speciesItem.SpeciesIllustrationPhoto.src).into(imageView)
            // sets up on click listener to navigate to the details page for each view
            itemView.setOnClickListener {
                val direction =
                    DetailsFragmentDirections.actionDetailsFragmentToGalleryFragment(speciesItem)
                itemView.findNavController().navigate(direction)
            }
        }

    }

    // checking for live state of each post item and updating to current state
    private val diffCallback = object : DiffUtil.ItemCallback<SpeciesItem>() {
        override fun areItemsTheSame(oldItem: SpeciesItem, newItem: SpeciesItem): Boolean {
            return oldItem.SpeciesName == newItem.SpeciesName
        }

        override fun areContentsTheSame(oldItem: SpeciesItem, newItem: SpeciesItem): Boolean {
            return oldItem == newItem
        }

    }
    // differ refreshes the recycler view asynchronously
    val differ = AsyncListDiffer(this, diffCallback)
    // inflates the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.details_item, parent, false)
        return ViewHolder(view)
    }
    // binds the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}
