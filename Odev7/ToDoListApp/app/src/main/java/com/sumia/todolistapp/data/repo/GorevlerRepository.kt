package com.sumia.todolistapp.data.repo

import com.sumia.todolistapp.data.datasource.GorevlerDataSource
import com.sumia.todolistapp.data.entity.Gorevler

class GorevlerRepository(var GorevlerDataSourde: GorevlerDataSource) {
    suspend fun kaydet(title: String, content:String) = GorevlerDataSourde.kaydet(title, content)
    suspend fun guncelle(id: Int, title: String, content:String) = GorevlerDataSourde.guncelle(id, title, content)
    suspend fun sil(id:Int) = GorevlerDataSourde.sil(id)

    suspend fun kisilerYukle(): List<Gorevler> = GorevlerDataSourde.gorevleriYukle()

    suspend fun ara(aramaKelimesi:String): List<Gorevler> = GorevlerDataSourde.ara(aramaKelimesi)
}