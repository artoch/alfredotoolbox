package com.tochapps.alfredotoolbox.ui.views.content.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tochapps.alfredotoolbox.common.POSTER
import com.tochapps.alfredotoolbox.common.THUMB
import com.tochapps.alfredotoolbox.common.adapterHelper.ViewBindingVH
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.databinding.ItemPosterBinding
import com.tochapps.alfredotoolbox.databinding.ItemThumbBinding
import com.tochapps.alfredotoolbox.ui.views.content.genericHolder.bind

class MoviesAdapter(
    private val items: List<ToolBoxItemEntity>,
    private val type:String,
    private val action: (ToolBoxItemEntity) -> Unit
) : RecyclerView.Adapter<ViewBindingVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingVH  =
        when (type){
            POSTER -> ViewBindingVH.create(parent, ItemPosterBinding::inflate)
            THUMB  -> ViewBindingVH.create(parent, ItemThumbBinding::inflate)
            else   -> ViewBindingVH.create(parent, ItemPosterBinding::inflate)
        }

    override fun onBindViewHolder(holder: ViewBindingVH, position: Int) {
        when (holder.binding){
            is ItemPosterBinding -> { holder.binding.bind(items[position], action) }
            is ItemThumbBinding  -> { holder.binding.bind(items[position], action) }
        }
    }

    override fun getItemCount(): Int = items.size
}
