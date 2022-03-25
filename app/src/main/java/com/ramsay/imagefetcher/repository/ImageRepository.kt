package com.ramsay.imagefetcher.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ramsay.imagefetcher.pagingSetup.PagingDataSource

class ImageRepository {

   fun pageList() = Pager(config = PagingConfig(
        pageSize = 20
    , enablePlaceholders = false
    ), pagingSourceFactory = {
        PagingDataSource()
    }
    ).liveData
}