package com.example.aplicacionfragmentos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplicacionfragmentos.databinding.ItemProteinBinding

class ViewHProteinShop(view: View, var deleteOnClick: (Int) -> Unit, var updateOnClick: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
    var binding: ItemProteinBinding
    init {
        binding = ItemProteinBinding.bind(view)
        binding.editar.setOnClickListener {
            updateOnClick(adapterPosition)
        }
        binding.eliminar.setOnClickListener {
            deleteOnClick(adapterPosition)
        }
    }
    fun renderize(proteinShop: ProteinShop) {
        binding.txtviewName.text = proteinShop.name
        binding.txtviewTipo.text = proteinShop.tipo
        binding.txtviewSabor.text = proteinShop.sabor
        binding.txtviewPeso.text = proteinShop.peso
        binding.txtviewPrecio.text = proteinShop.precio
        Glide.with(itemView.context)
            .load(proteinShop.image)
            .centerCrop()
            .into(binding.imagenItem)
    }
}
