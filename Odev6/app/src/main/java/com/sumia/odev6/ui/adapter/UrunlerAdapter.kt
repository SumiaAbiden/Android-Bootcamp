package com.sumia.odev6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sumia.odev6.data.Urunler
import com.sumia.odev6.databinding.ItemUrunBinding
import com.sumia.odev6.ui.fragments.AnasayfaFragment
import com.sumia.odev6.ui.fragments.AnasayfaFragmentDirections

class UrunlerAdapter(var mContext: Context, var urunlerListesi:List<Urunler>)
    :RecyclerView.Adapter<UrunlerAdapter.CardTasarimTutucu>() {
        inner class CardTasarimTutucu(var tasarim: ItemUrunBinding)
            :RecyclerView.ViewHolder(tasarim.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = ItemUrunBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return urunlerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunlerListesi.get(position)
        val t = holder.tasarim
        t.textViewAd.text = urun.urun_ad
        t.imageViewUrun.setImageResource(
            mContext.resources.getIdentifier(urun.urun_resim, "drawable", mContext.packageName)
        )
        t.textViewFiyat.text = urun.urun_fiyat
        t.textViewPuan.text = "★ ${urun.urun_puan}"

        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.detayGecis(urun = urun)
            Navigation.findNavController(it).navigate(gecis)
        }


    }
}