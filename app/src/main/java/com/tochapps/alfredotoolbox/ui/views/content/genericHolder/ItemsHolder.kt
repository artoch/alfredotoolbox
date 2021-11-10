package com.tochapps.alfredotoolbox.ui.views.content.genericHolder

import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochapps.alfredotoolbox.R
import com.tochapps.alfredotoolbox.common.POSTER
import com.tochapps.alfredotoolbox.common.adapterHelper.GlideCreate
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.databinding.ItemCarouselBinding
import com.tochapps.alfredotoolbox.databinding.ItemPosterBinding
import com.tochapps.alfredotoolbox.databinding.ItemThumbBinding
import com.tochapps.alfredotoolbox.ui.views.content.adapter.MoviesAdapter

fun ItemPosterBinding.bind(item: ToolBoxItemEntity, action: (ToolBoxItemEntity) -> Unit){
    this.apply {
        val context = root.context
        GlideCreate(context, item.imageUrl, ivPoster)
        tvTitle.text = item.title
        cvButton.setOnClickListener {
            action.invoke(item)
        }
    }
}

fun ItemThumbBinding.bind(item: ToolBoxItemEntity, action: (ToolBoxItemEntity) -> Unit) {
    this.apply {
        val context = root.context
        GlideCreate(context, item.imageUrl, ivPoster)
        tvTitle.text = item.title
        cvButton.setOnClickListener {
            action.invoke(item)
        }
    }
}

fun ItemCarouselBinding.bind(item: ToolBoxListEntity, action: (ToolBoxItemEntity) -> Unit){
    val context = this.root.context
    this.apply {
        rvPt.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        tvTitle.text = item.title
        if (item.type == POSTER){
            val height: Float = context.resources.getDimension(R.dimen.item_post)
            val newParams = LinearLayout.LayoutParams(
                rvPt.layoutParams.width,
                height.toInt()
            )
            rvPt.layoutParams = newParams
        }
        rvPt.adapter = MoviesAdapter(item.items, item.type, action)
    }

}


