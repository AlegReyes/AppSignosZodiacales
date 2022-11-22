package com.example.usandoinputs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.usandoinputs.databinding.ActivityMain2Binding
import com.example.usandoinputs.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding

    var tvNombre1: TextView?=null
    var tvNcuenta1: TextView?=null
    var tvCorreo1: TextView?=null
    var tvEdad1:TextView?=null

    var tvZodiaco:TextView?=null
    var ivZodiaco1:ImageView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)//inflar la vista
        //setContentView(R.layout.activity_main2)
        setContentView(binding.root)

        val bundle = intent.extras
        //cachamos los valores

        val nombre= bundle?.getString("nombre", "") //El "?" sirve para que no haya problema si hay algo nulo
        val Ncuenta = bundle?.getString("Ncuenta", "")
        val Correo = bundle?.getString("Correo", "")
        val Edad = bundle?.getString("Edad", "")

        val Mes=bundle?.getString("Edad","")
        val Dia=bundle?.getInt("Dia", 0)

        Toast.makeText(this, "Nombre: $nombre", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Numero de Cuenta: $Ncuenta", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Correo: $Correo", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Edad: $Edad", Toast.LENGTH_LONG).show()

        tvNombre1 = binding.tvNombre
        tvNcuenta1=binding.tvNcuenta
        tvCorreo1=binding.tvCorreo
        tvEdad1=binding.tvEdad

        val cnombre=getString(R.string.tuNombre)
        val cNcuenta=getString(R.string.tuNcuenta)
        val cCorreo=getString(R.string.tuCorreo)
        val cEdad=getString(R.string.tuEdad)


        tvNombre1?.setText(cnombre +nombre)
        tvNcuenta1?.setText(cNcuenta +Ncuenta)
        tvCorreo1?.setText(cCorreo +Correo)
        tvEdad1?.setText(cEdad +Edad)

    }

    fun click(view: View){
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP//borra todo el backstack
        startActivity(intent)
    }

}