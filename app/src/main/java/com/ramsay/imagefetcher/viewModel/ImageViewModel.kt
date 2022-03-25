package com.ramsay.imagefetcher.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ramsay.imagefetcher.repository.ImageRepository

class ImageViewModel : ViewModel() {
val repository = ImageRepository()
    fun imageLiveData() = repository.pageList()

}