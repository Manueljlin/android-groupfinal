package com.grupo1.trabajoapirest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grupo1.trabajoapirest.databinding.CeldaBinding
import com.grupo1.trabajoapirest.dataclass.Movies.Movie

class PelisAdapter(val listener: PeliClickListener) : RecyclerView.Adapter<PelisAdapter.CeldaHolder>() {

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
        val peli: Movie = listaPelis.get(position)
        holder.binding.tvTitulo.text = peli.title
//        holder.binding.tvGenre.text = peli.genreIds.toString()
        holder.binding.tvDesc.text = peli.releaseDate
        if(peli.adult == true){
            holder.binding.tvPlus18.visibility = View.VISIBLE
        } else {
            holder.binding.tvPlus18.visibility = View.INVISIBLE
        }
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