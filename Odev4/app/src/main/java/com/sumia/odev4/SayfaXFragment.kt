package com.sumia.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sumia.odev4.databinding.FragmentSayfaXBinding


class SayfaXFragment : Fragment() {
    private lateinit var binding: FragmentSayfaXBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSayfaXBinding.inflate(inflater, container, false)

        binding.buttonXY.setOnClickListener({
            Navigation.findNavController(it).navigate(R.id.Y2Gecis)
        })

        return binding.root
    }


}