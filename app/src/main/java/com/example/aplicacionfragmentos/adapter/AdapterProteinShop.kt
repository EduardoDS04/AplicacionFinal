package com.example.aplicacionfragmentos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AdapterProteinShop(var listProteinShop: MutableList<ProteinShop>, var deleteOnClick: (Int) -> Unit, var updateOnClick: (Int) -> Unit) : RecyclerView.Adapter<ViewHProteinShop>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHProteinShop {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemProtein = R.layout.item_protein
        return ViewHProteinShop(layoutInflater.inflate(layoutItemProtein, parent, false), deleteOnClick, updateOnClick)
    }
    override fun onBindViewHolder(holder: ViewHProteinShop, position: Int) {
        holder.renderize(listProteinShop[position])
    }
    override fun getItemCount(): Int = listProteinShop.size
}
