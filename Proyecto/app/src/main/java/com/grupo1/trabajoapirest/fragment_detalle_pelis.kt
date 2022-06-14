package com.grupo1.trabajoapirest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.grupo1.trabajoapirest.databinding.FragmentDetallePelisBinding
import com.grupo1.trabajoapirest.viewmodel.PelisViewModel

class fragment_detalle_pelis : Fragment() {

    private lateinit var binding: FragmentDetallePelisBinding
    private val PelisViewModel: PelisViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallePelisBinding.inflate(inflater, container, false)
        //(requireActivity() as MainActivity).changeToolbar(binding.toolbar, true)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PelisViewModel.selectedMovie.observe(viewLifecycleOwner) { peli ->
            (requireActivity() as MainActivity).changeToolbarTitle(peli!!.title!!)

//            if (peli.image != null && peli.image.url != null) {
//                Glide.with(this).load(peli.image.url).into(binding.imagenpeli)
//            }
        }
    }
}