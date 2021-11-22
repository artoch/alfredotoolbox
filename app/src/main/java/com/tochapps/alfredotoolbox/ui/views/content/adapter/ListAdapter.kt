package com.tochapps.alfredotoolbox.ui.views.content.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tochapps.alfredotoolbox.common.adapterHelper.ViewBindingVH
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.databinding.ItemCarouselBinding
import com.tochapps.alfredotoolbox.ui.views.content.genericHolder.bind

class ListAdapter (
    private val items: List<ToolBoxListEntity>,
    private val action: (ToolBoxItemEntity) -> Unit
) : RecyclerView.Adapter<ViewBindingVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingVH =
         ViewBindingVH.create(parent, ItemCarouselBinding::inflate)


    override fun onBindViewHolder(holder: ViewBindingVH, position: Int) {
        (holder.binding as ItemCarouselBinding).bind(items[position], action)
    }

    override fun getItemCount(): Int = items.size
}
