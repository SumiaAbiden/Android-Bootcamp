package com.sumia.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sumia.odev4.databinding.FragmentSayfaABinding

class SayfaAFragment : Fragment() {
    private lateinit var binding: FragmentSayfaABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSayfaABinding.inflate(inflater, container, false)

        binding.button.setOnClickListener({
            Navigation.findNavController(it).navigate(R.id.BGecis)
        })

        return binding.root
    }

}