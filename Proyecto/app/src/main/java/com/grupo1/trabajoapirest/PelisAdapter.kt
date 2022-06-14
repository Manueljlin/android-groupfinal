package com.grupo1.trabajoapirest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grupo1.trabajoapirest.databinding.CeldaBinding
import com.grupo1.trabajoapirest.dataclass.Movies.GetApiConfiguration.ApiConfiguration
import com.grupo1.trabajoapirest.dataclass.Movies.GetMovieGenres.MovieGenres
import com.grupo1.trabajoapirest.dataclass.Movies.Movie
import com.grupo1.trabajoapirest.viewmodel.PelisViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class PelisAdapter(val listener: PeliClickListener, val pelisVm: PelisViewModel)
    : RecyclerView.Adapter<PelisAdapter.CeldaHolder>() {

    private var listaPelis = ArrayList<Movie>()

    interface PeliClickListener{
        fun OnClick(peli: Movie)
    }

    inner class CeldaHolder(val binding: CeldaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CeldaBinding.inflate(inflater, parent, false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: CeldaHolder, position: Int) {
        val peli: Movie = listaPelis[position]
        val genre_ids: List<Int>? = peli.genreIds

        val api_configuration = pelisVm.apiConfiguration.value

        holder.binding.tvTitulo.text = peli.title
        holder.binding.tvGenre.text = peli.genreIds.toString()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
        holder.binding.tvDesc.text = LocalDate.parse(peli.releaseDate, formatter).year.toString()

        with (holder.binding.tvPlus18) {
            if (peli.adult == true) this.visibility = View.VISIBLE
            else this.visibility = View.INVISIBLE
        }

        val base_url  = api_configuration?.images?.secureBaseUrl ?: "https://image.tmdb.org/t/p/"
        val size      = api_configuration?.images?.posterSizes?.get(-2) ?: "w780"

        val imageUrl: String = "${base_url}${size}${peli.posterPath}"


        Log.d("ARST 2", "${imageUrl}\n")

        Glide
            .with(holder.itemView)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.imageView)

        holder.itemView.setOnClickListener {
            listener.OnClick(peli)
        }
    }

    override fun getItemCount(): Int {
        return listaPelis.size
    }

    fun actualizaLista(lista: ArrayList<Movie>) {
        listaPelis.clear()
        listaPelis.addAll(lista)
        notifyDataSetChanged()
    }
}