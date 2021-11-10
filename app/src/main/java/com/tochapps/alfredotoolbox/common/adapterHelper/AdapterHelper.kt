package com.tochapps.alfredotoolbox.common.adapterHelper

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.tochapps.alfredotoolbox.R

fun GlideCreate(
    context: Context,
    url:String,
    ima: ImageView
){
    Glide.with(context)
        .load(url)
        // .error(itemView.context.getDrawable(R.drawable.notfound))
        .placeholder(ProgressItem(context))
//        .diskCacheStrategy(DiskCacheStrategy.NONE)
//        .skipMemoryCache(true)
        .listener(glideList())
        .into(ima)
}


fun ProgressItem(context: Context): CircularProgressDrawable = CircularProgressDrawable(context).apply {
    strokeWidth = 5f
    setColorSchemeColors(
        ContextCompat.getColor(
            context,
            R.color.secondaryColor
        )
    )
    centerRadius = 30f
    start()
}
private fun glideList() = object : RequestListener<Drawable> {
    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: com.bumptech.glide.load.DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        return false
    }

    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {
        return false
    }
}