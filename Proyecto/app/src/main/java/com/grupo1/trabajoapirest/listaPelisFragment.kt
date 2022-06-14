package com.grupo1.trabajoapirest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.grupo1.trabajoapirest.databinding.FragmentPelisListaBinding
import com.grupo1.trabajoapirest.dataclass.Movies.GetApiConfiguration.ApiConfiguration
import com.grupo1.trabajoapirest.dataclass.Movies.GetMovieGenres.MovieGenres
import com.grupo1.trabajoapirest.dataclass.Movies.Movie
import com.grupo1.trabajoapirest.viewmodel.PelisViewModel
import dev.chrisbanes.insetter.Insetter
import dev.chrisbanes.insetter.Side.BOTTOM
import dev.chrisbanes.insetter.Side.LEFT
import dev.chrisbanes.insetter.Side.RIGHT
import dev.chrisbanes.insetter.Side.TOP
import dev.chrisbanes.insetter.windowInsetTypesOf


class listaPelisFragment: Fragment() {

	private lateinit var binding: FragmentPelisListaBinding
	private lateinit var adapter: PelisAdapter
	private val pelisVm: PelisViewModel by activityViewModels()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		setHasOptionsMenu(true)
		binding = FragmentPelisListaBinding.inflate(inflater,container, false)
		(requireActivity() as MainActivity).changeToolbar(binding.toolbar, false)
		(requireActivity() as MainActivity).changeToolbarTitle("Películas")

		with (Insetter) {
			// Make the toolbar title not go below the notch or navigation bar
			// when using the device in horizontal mode
//			builder()
//				.padding(
//					windowInsetTypesOf(
//						navigationBars = true, statusBars = true, displayCutout = true
//					), LEFT + RIGHT
//				)
//				.margin(
//					windowInsetTypesOf(statusBars = true),
//					TOP
//				)
//				.applyToView(binding.appbarlayout)
//
//			// Make the scroll view not get obscured by the diffuse area
//			builder()
//				.margin(
//					windowInsetTypesOf(navigationBars = true, displayCutout = true),
//					LEFT + RIGHT
//				)
//				.padding(
//					windowInsetTypesOf(navigationBars = true),
//					BOTTOM
//				)
//				.applyToView(binding.nestedScrollView)
		}


		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		configRecycler(pelisVm)

		pelisVm.getPopularMovies(1)
		// cambiar el valor de page ^ en el adapter para ir cambiando de
		// página al hacer scroll en el recyclerview
		pelisVm.popularMovies.observe(viewLifecycleOwner) {
			adapter.actualizaLista(it.results as ArrayList<Movie>)
		}
	}

	private fun configRecycler(pelisVm: PelisViewModel) {
		val recyclerView = binding.rvPelis

		adapter = PelisAdapter(object : PelisAdapter.PeliClickListener{
			override fun OnClick(peli: Movie) {
				pelisVm.selectedMovie.value = peli
				findNavController().navigate(R.id.action_listaPelisFragment_to_detallePeliFragment)
			}
		}, pelisVm )

		val layoutManager = GridLayoutManager(
			requireContext(),
			2,
			GridLayoutManager.VERTICAL,
			false
		)
		recyclerView.layoutManager = layoutManager
		recyclerView.adapter = adapter
	}
}