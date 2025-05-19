package com.sumia.todolistapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sumia.todolistapp.data.entity.Gorevler
import com.sumia.todolistapp.databinding.GorevCardBinding
import com.sumia.todolistapp.ui.fragments.AnasayfaFragmentDirections
import com.sumia.todolistapp.ui.viewmodel.AnasayfaViewModel
import com.sumia.todolistapp.utils.gecisYap

class GorevlerAdapter (var mContext: Context,
                       var gorevlerListesi : List<Gorevler>,
                       var viewModel: AnasayfaViewModel
)
    : RecyclerView.Adapter<GorevlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: GorevCardBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = GorevCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return gorevlerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val gorev = gorevlerListesi.get(position)
        val t = holder.tasarim
        t.textViewBaslik.text = gorev.title
        t.textViewIcerik.text = gorev.content

        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.detayGecis(gorev = gorev)
            Navigation.gecisYap(it, gecis)
        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it, "${gorev.title} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(gorev.id)
                }.show()
        }
    }
}