package com.sumia.todolistapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "Gorevler")
data class Gorevler(@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "id") @NotNull var id:Int,
                    @ColumnInfo(name = "title") @NotNull var title: String,
                    @ColumnInfo(name = "content") @NotNull var content: String) : Serializable {
}