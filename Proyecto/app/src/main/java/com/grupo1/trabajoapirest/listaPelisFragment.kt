package com.grupo1.trabajoapirest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.grupo1.trabajoapirest.databinding.FragmentPelisListaBinding
import com.grupo1.trabajoapirest.dataclass.Movies.Movie
import com.grupo1.trabajoapirest.viewmodel.PelisViewModel


class listaPelisFragment: Fragment() {

	private lateinit var binding: FragmentPelisListaBinding
	private lateinit var adapter: PelisAdapter
	private val pelisVm: PelisViewModel by activityViewModels()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		setHasOptionsMenu(true)
		binding = FragmentPelisListaBinding.inflate(inflater,container, false)
		(requireActivity() as MainActivity).changeToolbar(binding.toolbar, false)
		(requireActivity() as MainActivity).changeToolbarTitle("Películas")
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		configRecycler()

		pelisVm.getPopularMovies(0)
		pelisVm.popularMovies.observe(viewLifecycleOwner){
			adapter.actualizaLista(it.results as ArrayList<Movie>)
		}
	}

	private fun configRecycler() {
		val recyclerView = binding.rvPelis
		adapter = PelisAdapter(object : PelisAdapter.PeliClickListener{
			override fun OnClick(peli: Movie) {
				pelisVm.selectedMovie.value = peli
				//findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
			}
		})
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