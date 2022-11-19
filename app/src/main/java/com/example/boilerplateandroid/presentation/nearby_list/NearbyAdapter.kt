package com.example.boilerplateandroid.presentation.nearby_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.boilerplateandroid.data.response.SportsmanNearbyResponse
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.databinding.ItemNearbyUserBinding
import com.example.boilerplateandroid.model.Sportsman

class NearbyAdapter(private val onItemClick: (Sportsman) -> Unit) : ListAdapter<Sportsman, NearbyViewHolder>(Sportsman) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyViewHolder {
        return NearbyViewHolder.from(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: NearbyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NearbyViewHolder(private val binding: ItemNearbyUserBinding, private val onItemClick: (Sportsman) -> Unit) : RecyclerView.ViewHolder(binding.root){

    private val txtName = binding.txtName
    private var model: Sportsman? = null

    init {
        itemView.setOnClickListener {
            model?.let { onItemClick(it) }
        }
    }

    fun bind(model : Sportsman){
        this.model = model

        txtName.text = model.name
    }

    companion object {
        fun from(parent: ViewGroup, onItemClick: (Sportsman) -> Unit): NearbyViewHolder {
            return NearbyViewHolder(
                ItemNearbyUserBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),
                onItemClick
            )
        }
    }
}