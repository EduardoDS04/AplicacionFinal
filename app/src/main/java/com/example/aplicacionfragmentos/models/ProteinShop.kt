package com.example.aplicacionfragmentos

class ProteinShop (
    var name: String,
    var tipo: String,
    var sabor: String,
    var peso: String,
    var precio: String,
    var image: String
) {
    override fun toString(): String {
        return "ProteinShop(name='$name', tipo='$tipo', sabor='$sabor', peso='$peso', precio'$precio', image='$image')"
    }
}