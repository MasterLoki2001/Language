package com.example.instagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var models:List<PostAds> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View
        if (viewType == 1){
            view = LayoutInflater.from(parent.context).inflate(R.layout.adsiens, parent,false)
            return AdsViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent,false)
            return PostViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1){
            (holder as AdsViewHolder).populateModel((models[position] as Ads),position)
        } else{
            (holder as PostViewHolder).populateModel((models[position] as Post),position)
        }
    }

    override fun getItemCount(): Int = models.size

    override fun getItemViewType(position: Int): Int {
        return models[position].type
    }
}