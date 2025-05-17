package com.sumia.odev6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sumia.odev6.R
import com.sumia.odev6.data.Urunler
import com.sumia.odev6.databinding.FragmentAnasayfaBinding
import com.sumia.odev6.ui.adapter.UrunlerAdapter


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        val urunlerListesi = ArrayList<Urunler>()
        val u1 = Urunler(1, "canta", "Kahverengi Canta", "575.99 ₺", 4.7)
        val u2 = Urunler(1, "bilgisayarcantasi", "Siyah Bilgisayar Çantası", "559.99 ₺", 4.5)
        val u3 = Urunler(1, "tisort", "Erkek Tişört", "426.25 ₺", 4.2)
        val u4 = Urunler(1, "ayakkabi", "Erkek Günlük Ayakkabı", "485 ₺", 4.1)
        val u5 = Urunler(1, "kase", "Dondurmalık Kase", "459 ₺", 4.8)
        urunlerListesi.add(u1)
        urunlerListesi.add(u2)
        urunlerListesi.add(u3)
        urunlerListesi.add(u4)
        urunlerListesi.add(u5)



        val onerilerListesi = ArrayList<Urunler>()
        val o1 = Urunler(1, "serum", "Regenrating Serum", "1099 ₺", 4.6)
        val o2 = Urunler(1, "guneskremi", "CEEL Güneş Kremi", "245.22 ₺", 4.2)
        val o3 = Urunler(1, "sac", "Saç Dökülmesine Karşı Şampuan", "276.85 ₺", 4.3)
        val o4 = Urunler(1, "kutu", "Dolap İçi Düzenleyici", "119.90 ₺", 4.6)
        val o5 = Urunler(1, "ayna", "Boy Aynası", "1546 ₺", 4.8)
        onerilerListesi.add(o1)
        onerilerListesi.add(o2)
        onerilerListesi.add(o3)
        onerilerListesi.add(o4)
        onerilerListesi.add(o5)


        val urunlerAdapter = UrunlerAdapter(requireContext(),  urunlerListesi)
        binding.UrunlerRV.adapter = urunlerAdapter


        binding.UrunlerRV.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)



        val onerilerAdapter = UrunlerAdapter(requireContext(),  onerilerListesi)
        binding.OnerilerRV.adapter = onerilerAdapter


        binding.OnerilerRV.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)




        return binding.root
    }

}