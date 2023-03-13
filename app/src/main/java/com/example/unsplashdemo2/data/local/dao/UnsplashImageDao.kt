package com.example.unsplashdemo2.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.unsplashdemo2.model.UnsplashImage
import com.example.unsplashdemo2.util.Constant.UNSLPASH_IMAGE_TABLE

@Dao
interface UnsplashImageDao {
    @Query("SELECT * FROM $UNSLPASH_IMAGE_TABLE")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("DELETE FROM $UNSLPASH_IMAGE_TABLE")
    suspend fun deleteAllImages()
}