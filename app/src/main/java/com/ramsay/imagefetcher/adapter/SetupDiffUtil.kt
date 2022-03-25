package com.ramsay.imagefetcher.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ramsay.imagefetcher.model.ResponseModelItem

class SetupDiffUtil : DiffUtil.ItemCallback<ResponseModelItem>() {
    override fun areItemsTheSame(oldItem: ResponseModelItem, newItem: ResponseModelItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResponseModelItem, newItem: ResponseModelItem): Boolean {
        return oldItem == newItem
    }
}
