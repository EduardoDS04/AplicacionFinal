package com.example.aplicacionfragmentos
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast


class Controller(val context: Context) {
    lateinit var listProteinShops: MutableList<ProteinShop>
    lateinit var adapterProteinShop: AdapterProteinShop

    init {
        initData()
    }

    fun initData() {
        listProteinShops = DaoProteinShop.myDao.getDataHotels().toMutableList()
    }

    fun loggOut() {
        Toast.makeText(context, "Se muestra los datos en pantalla", Toast.LENGTH_LONG).show()
        listProteinShops.forEach {
            println(it)
        }
    }

    fun setAdapter() {
        val myActivity = context as MainActivity
        adapterProteinShop = AdapterProteinShop(
            listProteinShops,
            { pos -> delHotel(pos) },
            { pos -> updateHotel(pos) }
        )
        myActivity.binding.myRecyclerView.adapter = adapterProteinShop
    }

    private fun delHotel(position: Int) {
        if (position >= 0 && position < listProteinShops.size) {
            val deletedProtein = listProteinShops[position]
            val builder = AlertDialog.Builder(context)
            builder.setMessage("¿Quieres borrar la proteína ${deletedProtein.name}?")
                .setPositiveButton("Si") { _, _ ->
                    listProteinShops.removeAt(position)
                    adapterProteinShop.notifyItemRemoved(position)
                    Toast.makeText(context, "ProteinShop eliminado: ${deletedProtein.name}", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }

    private fun updateHotel(position: Int) {
        if (position >= 0 && position < listProteinShops.size) {
            showEditDialog(listProteinShops[position], position)
        }
    }
    internal fun showEditDialog(proteinShop: ProteinShop?, position: Int?) {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_add_edit, null)
        builder.setView(dialogView)

        val editTextName = dialogView.findViewById<EditText>(R.id.editTextName)
        val editTextTipo = dialogView.findViewById<EditText>(R.id.editTextTipo)
        val editTextSabor = dialogView.findViewById<EditText>(R.id.editTextSabor)
        val editTextPeso = dialogView.findViewById<EditText>(R.id.editTextPeso)
        val editTextPrecio=dialogView.findViewById<EditText>(R.id.editTextPrecio)
        val editTextImage = dialogView.findViewById<EditText>(R.id.editTextImage)


        if (proteinShop != null) {
            editTextName.setText(proteinShop.name)
            editTextTipo.setText(proteinShop.tipo)
            editTextSabor.setText(proteinShop.sabor)
            editTextPeso.setText(proteinShop.peso)
            editTextPrecio.setText(proteinShop.precio)
            editTextImage.setText(proteinShop.image)
        }
        builder.setPositiveButton("aceptar") { _, _ ->
            val name = editTextName.text.toString()
            val tipo = editTextTipo.text.toString()
            val sabor = editTextSabor.text.toString()
            val peso = editTextPeso.text.toString()
            val precio= editTextPrecio.text.toString()
            val image = editTextImage.text.toString()

            if (position == null) {
                val newProteinShop = ProteinShop(name,tipo, sabor, peso,precio, image)
                listProteinShops.add(newProteinShop)
                adapterProteinShop.notifyItemInserted(listProteinShops.size - 1)
            } else {
                if (position >= 0 && position < listProteinShops.size) {
                    listProteinShops[position] = ProteinShop(name,tipo, sabor, peso,precio, image)
                    adapterProteinShop.notifyItemChanged(position)
                }
            }
        }
        builder.setNegativeButton("cancelar") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}
