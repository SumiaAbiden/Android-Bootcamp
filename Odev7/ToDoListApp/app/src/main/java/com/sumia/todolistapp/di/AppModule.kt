package com.sumia.todolistapp.di

import android.content.Context
import androidx.room.Room
import com.sumia.todolistapp.data.datasource.GorevlerDataSource
import com.sumia.todolistapp.data.repo.GorevlerRepository
import com.sumia.todolistapp.room.GorevlerDao
import com.sumia.todolistapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideGorevlerRepository(gorevlerDataSource: GorevlerDataSource) : GorevlerRepository{
        return GorevlerRepository(gorevlerDataSource)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(gorevlerDao : GorevlerDao) : GorevlerDataSource {
        return GorevlerDataSource(gorevlerDao)
    }

    @Provides
    @Singleton
    fun provideGorevlerDao(@ApplicationContext context: Context) : GorevlerDao {
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"todo.sqlite")
            .createFromAsset("todo.sqlite")
            .build()
        return veritabani.getGorevlerDao()
    }
}