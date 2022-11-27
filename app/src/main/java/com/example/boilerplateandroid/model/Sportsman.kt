package com.example.boilerplateandroid.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sportsman(
    val id: String,
    val name: String,
    val age: String,
    val distance: String,
    val sports: List<String>
) : Parcelable{
    companion object : DiffUtil.ItemCallback<Sportsman>() {
        override fun areItemsTheSame(oldItem: Sportsman, newItem: Sportsman): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sportsman, newItem: Sportsman): Boolean {
            return oldItem == newItem
        }

    }
}
