package com.sumia.todolistapp.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumia.todolistapp.data.entity.Gorevler
import com.sumia.todolistapp.data.repo.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor(var GorevlerRepository : GorevlerRepository) : ViewModel() {

    var gorevlerListesi = MutableLiveData<List<Gorevler>>()

    init {
        gorevleriYukle()
    }

    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            GorevlerRepository.sil(kisi_id)
            gorevleriYukle()
        }
    }

    fun gorevleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value = GorevlerRepository.kisilerYukle()
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value = GorevlerRepository.ara(aramaKelimesi)
        }
    }

}