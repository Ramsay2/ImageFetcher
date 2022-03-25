package com.ramsay.imagefetcher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramsay.imagefetcher.R
import com.ramsay.imagefetcher.databinding.ImageItemLayoutBinding
import com.ramsay.imagefetcher.model.ResponseModelItem

class ImageAdapter :
    PagingDataAdapter<ResponseModelItem, ImageAdapter.ImageViewHolder>(SetupDiffUtil()) {


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageData = getItem(position)

        if (imageData != null)
            holder.bindData(imageData)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val imageItemLayoutBinding: ImageItemLayoutBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.image_item_layout, parent, false
        )

        return ImageViewHolder(imageItemLayoutBinding)
    }

    inner class ImageViewHolder(private val imageItemLayoutBinding: ImageItemLayoutBinding) :
        RecyclerView.ViewHolder(imageItemLayoutBinding.root) {

        fun bindData(responseModelItem: ResponseModelItem) {
            imageItemLayoutBinding.imageData = responseModelItem
            Glide.with(imageItemLayoutBinding.image).load(responseModelItem.downloadUrl)
                .into(imageItemLayoutBinding.image)

        }

    }

}