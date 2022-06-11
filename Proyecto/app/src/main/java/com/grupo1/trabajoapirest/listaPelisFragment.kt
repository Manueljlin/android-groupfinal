package com.grupo1.trabajoapirest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grupo1.trabajoapirest.databinding.FragmentPelisListaBinding


class listaPelisFragment: Fragment() {

	private lateinit var binding: FragmentPelisListaBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentPelisListaBinding.inflate(inflater,container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
}