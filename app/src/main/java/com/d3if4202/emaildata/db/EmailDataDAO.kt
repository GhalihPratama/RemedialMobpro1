package com.d3if4202.emaildata.db

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EmailDataDAO {

    @Insert
    suspend fun insertEmailData(emaildata: EmailData) : Long

    @Update
    suspend fun updateEmailData(emaildata: EmailData) : Int

    @Delete
    suspend fun deleteEmailData(emaildata: EmailData) : Int

    @Query("DELETE FROM emaildata_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM emaildata_data_table")
    fun getAllEmailDatas():Flow<List<EmailData>>
}