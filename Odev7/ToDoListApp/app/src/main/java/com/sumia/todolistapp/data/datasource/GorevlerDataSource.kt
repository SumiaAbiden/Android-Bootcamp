package com.sumia.todolistapp.data.datasource

import com.sumia.todolistapp.data.entity.Gorevler
import com.sumia.todolistapp.room.GorevlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GorevlerDataSource(var GorevlerDao : GorevlerDao) {
    suspend fun kaydet(title: String, content:String){
        var yeniGorev = Gorevler(0, title, content)
        GorevlerDao.kaydet(yeniGorev)
    }

    suspend fun guncelle(id: Int, title: String, content:String){
        var guncellenenGorev = Gorevler(id, title, content)
        GorevlerDao.guncelle(guncellenenGorev)
    }

    suspend fun sil(id: Int){
        var silinenGorev = Gorevler(id, "", "")
        GorevlerDao.sil(silinenGorev)
    }

    suspend fun gorevleriYukle() : List<Gorevler> = withContext((Dispatchers.IO)){
        return@withContext GorevlerDao.gorevleriYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Gorevler> = withContext(Dispatchers.IO) {
        return@withContext GorevlerDao.ara(aramaKelimesi)
    }
}