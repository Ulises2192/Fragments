package com.ulisesdiaz.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.ClassCastException

class MyFragment : Fragment() {

    var boton: Button? = null
    var nombre: EditText? = null
    var listener: NombreListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        boton = view.findViewById(R.id.boton)
        nombre = view.findViewById(R.id.editNombre)

        boton?.setOnClickListener {
            listener?.obtenerNombre(nombre?.text.toString())
        }
        return view
    }

    interface NombreListener{
        fun obtenerNombre(nombre: String){}
    }

    /**
     * Se ejecuta cuando el componente se Attacha mas no esta inicializad
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as NombreListener
        }catch (e: ClassCastException){
            throw ClassCastException(context.toString() + " Debes implementar la interface")
        }
    }

}