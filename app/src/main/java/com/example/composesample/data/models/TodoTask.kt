package com.example.composesample.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composesample.util.Constants

@Entity(tableName = Constants.DATABASE_TABLE)
data class TodoTask(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority

)
