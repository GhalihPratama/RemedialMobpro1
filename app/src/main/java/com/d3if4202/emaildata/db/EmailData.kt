package com.d3if4202.emaildata.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emaildata_data_table")
data class EmailData(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "emaildata_id")
    var id: Int,

    @ColumnInfo(name = "emaildata_name")
    var name: String,

    @ColumnInfo(name = "emaildata_email")
    var email: String

)