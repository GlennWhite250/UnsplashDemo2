package com.example.unsplashdemo2.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.unsplashdemo2.data.remote.UnsplashApi
import com.example.unsplashdemo2.model.UnsplashImage
import com.example.unsplashdemo2.util.Constant.ITEMS_PER_PAGE

class SearchPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashImage>() {
    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentpage = params.key ?: 1
        return try {
            val response = unsplashApi.searchImages(query = query, per_page = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.images.isEmpty()
            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentpage == 1) null else currentpage - 1,
                    nextKey = if (endOfPaginationReached) null else currentpage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )

            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}