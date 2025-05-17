package com.sumia.odev6.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.sumia.odev6.R
import com.sumia.odev6.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {

    private val args: DetayFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetayBinding.inflate(inflater, container, false)
        val urun = args.urun
        binding.imageViewDetayUrun.setImageResource(
            requireContext().resources.getIdentifier(urun.urun_resim, "drawable", requireContext().packageName)
        )
        binding.textViewDetayAd.text = urun.urun_ad
        binding.textViewDetayFiyat.text = urun.urun_fiyat
        binding.textViewDetayPuan.text = "★ ${urun.urun_puan} puan"

        binding.buttonSepeteEkle.setOnClickListener {
            Toast.makeText(requireContext(), "${urun.urun_ad} sepete eklendi", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
