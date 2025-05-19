package com.sumia.todolistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sumia.todolistapp.data.repo.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GorevEkleViewModel @Inject constructor (var GorevlerRepository : GorevlerRepository) : ViewModel(){
    fun kaydet(title: String, content:String) {
        CoroutineScope(Dispatchers.Main).launch {
            GorevlerRepository.kaydet(title, content)
        }
    }
}