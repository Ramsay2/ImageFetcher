package com.ramsay.imagefetcher.pagingSetup


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ramsay.imagefetcher.model.ResponseModelItem
import com.ramsay.imagefetcher.model.apis.Network

class PagingDataSource :PagingSource<Int,ResponseModelItem>() {

    private val apiService = Network.apiService()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModelItem> {

        val pageNumber = params.key ?: 1
        val response = apiService.getDetails(pageNumber)


        val responseDTOItemList : List<ResponseModelItem> = response

        return try {
            LoadResult.Page(data = responseDTOItemList,
                prevKey = null,
                nextKey = if(responseDTOItemList.isEmpty()) null
                else  pageNumber + 1)
        } catch (exception : Exception){
            LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, ResponseModelItem>): Int? {
        return state.anchorPosition
    }

}