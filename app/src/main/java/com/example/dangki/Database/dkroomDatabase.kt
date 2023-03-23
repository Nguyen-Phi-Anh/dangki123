package com.example.dangki.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dangki.model.dangki


@Database(entities = [dangki::class], version = 1)
abstract class dkroomDatabase: RoomDatabase() {
    abstract fun dkDAO(): DkDAO

}