package com.example.dangki.Database

import androidx.room.Dao
import androidx.room.Insert
import com.example.dangki.model.dangki

@Dao
interface DkDAO {
    @Insert
    fun insert(dk: dangki)
}