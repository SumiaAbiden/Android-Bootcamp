package com.sumia.todolistapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumia.todolistapp.R
import com.sumia.todolistapp.databinding.FragmentAnasayfaBinding
import com.sumia.todolistapp.ui.adapter.GorevlerAdapter
import com.sumia.todolistapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewModel.gorevlerListesi.observe(viewLifecycleOwner){
            val gorevlerAdapter = GorevlerAdapter(requireContext(), it, viewModel)
            binding.gorevlerRV.adapter = gorevlerAdapter
        }

        binding.gorevlerRV.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.ekleFragment3)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }



    override fun onResume() {
        super.onResume()
        viewModel.gorevleriYukle()
    }

}