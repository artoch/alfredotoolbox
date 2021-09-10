package com.tochapps.practicetestapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_table")
data class TestEntity (
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    val userId: Int,
    val title: String,
    val body: String,
)