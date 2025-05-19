package com.sumia.todolistapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.sumia.todolistapp.R
import com.sumia.todolistapp.databinding.FragmentEkleBinding
import com.sumia.todolistapp.ui.viewmodel.GorevEkleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class EkleFragment : Fragment() {

    private lateinit var binding: FragmentEkleBinding
    private lateinit var viewModel: GorevEkleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEkleBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val gorevBaslik = binding.inputBaslikKaydet.text.toString()
            val gorevIcerik = binding.inputIcerikKaydet.text.toString()
            viewModel.kaydet(gorevBaslik, gorevIcerik)
            Navigation.findNavController(it).navigate(R.id.anasayfaFragment2)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : GorevEkleViewModel by viewModels()
        viewModel = tempViewModel
    }


}