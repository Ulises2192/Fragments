package com.ulisesdiaz.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), MyFragment.NombreListener {

    var txtNombre: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtNombre = findViewById<TextView>(R.id.txtNombre)
    }

    override fun obtenerNombre(nombre: String) {
        super.obtenerNombre(nombre)
        txtNombre?.text = nombre
    }
}