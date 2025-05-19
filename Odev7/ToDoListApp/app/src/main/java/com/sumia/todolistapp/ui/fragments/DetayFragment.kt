package com.sumia.todolistapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.sumia.todolistapp.R
import com.sumia.todolistapp.databinding.FragmentDetayBinding
import com.sumia.todolistapp.ui.viewmodel.GorevDetayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: GorevDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle: DetayFragmentArgs by navArgs()
        val gelenGorev = bundle.gorev

        binding.inputBaslikGuncelle.setText(gelenGorev.title)
        binding.inputIcerikGuncelle.setText(gelenGorev.content)


        binding.buttonGuncelle.setOnClickListener {
            val gorev_baslik = binding.inputBaslikGuncelle.text.toString()
            val gorev_icerik = binding.inputIcerikGuncelle.text.toString()
            viewModel.guncelle(gelenGorev.id, gorev_baslik, gorev_icerik)
            Navigation.findNavController(it).navigate(R.id.anasayfaFragment2)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : GorevDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}