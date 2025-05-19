package com.sumia.todolistapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.sumia.todolistapp.R


fun Navigation.gecisYap(it:View, id:NavDirections){
    findNavController(it).navigate(id)
}