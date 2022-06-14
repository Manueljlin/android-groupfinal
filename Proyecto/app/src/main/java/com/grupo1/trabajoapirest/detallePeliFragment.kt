package com.grupo1.trabajoapirest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.grupo1.trabajoapirest.databinding.FragmentPeliDetalleBinding
import com.grupo1.trabajoapirest.viewmodel.PelisViewModel

class detallePeliFragment : Fragment() {

	private lateinit var binding: FragmentPeliDetalleBinding
	private val PelisViewModel: PelisViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentPeliDetalleBinding.inflate(inflater, container, false)
		(requireActivity() as MainActivity).changeToolbar(binding.toolbar, true)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		PelisViewModel.selectedMovie.observe(viewLifecycleOwner) { peli ->
			(requireActivity() as MainActivity).changeToolbarTitle(peli?.title ?: "Película")

//			Glide
//				.with(Fragment())
//				.load(imageUrl)
//				.placeholder(R.drawable.ic_launcher_background)
//				.into(binding.ivToolbar)
		}
	}
}