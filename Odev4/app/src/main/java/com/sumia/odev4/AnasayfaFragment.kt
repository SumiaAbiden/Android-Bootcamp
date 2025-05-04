package com.sumia.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sumia.odev4.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonAnasayfaA.setOnClickListener({
            Navigation.findNavController(it).navigate(R.id.AGecis)
        })

        binding.buttonAnasayfaX.setOnClickListener({
            Navigation.findNavController(it).navigate(R.id.XGecis)
        })

        return binding.root
    }

}