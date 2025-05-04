package com.sumia.odev4

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sumia.odev4.databinding.FragmentSayfaYBinding

class SayfaYFragment : Fragment() {

    private lateinit var binding: FragmentSayfaYBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSayfaYBinding.inflate(inflater, container, false)
        return binding.root
    }

}
