package com.sumia.todolistapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sumia.todolistapp.data.entity.Gorevler

@Database(entities = [Gorevler::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getGorevlerDao() : GorevlerDao
}
