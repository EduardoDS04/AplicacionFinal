package com.example.aplicacionfragmentos


class DaoProteinShop private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoProteinShop by lazy{
            DaoProteinShop()
        }
    }
    override fun getDataHotels(): List<ProteinShop> = Repository.listProteinShops
}
