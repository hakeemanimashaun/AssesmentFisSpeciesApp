package com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.R
import com.mindorks.framework.oceansgrsmithcodingassessmenthakeemanimashaun.models.SpeciesItem

//class ViewPagerAdapter(
//    val speciesItem: SpeciesItem
//) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){
//    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//
//        fun setData(speciesItem: SpeciesItem) = with(itemView){
//
//        val displayTv = itemView.findViewById<ImageView>(R.id.gallery_view)
//        //Glide.with(context).load(speciesItem.SpeciesIllustrationPhoto.src).into(displayTv)
//        }
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
//        return ViewPagerViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
//       holder.setData(speciesItem)
//
//    }
//
//    override fun getItemCount(): Int {
//        return speciesItem.size
//    }
//
//}