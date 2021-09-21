package com.d3if4202.emaildata.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EmailData::class], version = 1)
abstract class EmailDataDatabase : RoomDatabase() {
    abstract val emaildataDAO: EmailDataDAO

    companion object {
        @Volatile
        private var INSTANCE: EmailDataDatabase? = null
        fun getInstance(context: Context): EmailDataDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmailDataDatabase::class.java,
                        "emaildata_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}