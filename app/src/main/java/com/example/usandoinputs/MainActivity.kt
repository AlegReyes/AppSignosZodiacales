//By Alejandro Garcia Reyes
package com.example.usandoinputs

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.usandoinputs.databinding.ActivityMainBinding
import java.time.Instant
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    var etFecha:EditText?=null
    var btnFecha:ImageButton?=null
    var dpFecha:DatePicker?=null

    //val fecha1 = etFecha?.text.toString()
/*
    var fechaActual= Date(System.currentTimeMillis())
    var diferenciarFechasMili=fechaActual.getTime()-fecha1.getTime()
    var segundos=diferenciarFechasMili/1000
    var minutos=segundos/60
    var horas=minutos/60
    var dias=horas/24
    var años=dias/365
*/
    val parametros = Bundle()

    var camposllenados: Int = 0//Para verificar si todos los campos estan correctos

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//inflar la vista
        setContentView(binding.root)

        etFecha=findViewById(R.id.etFecha)//vinculamos
        btnFecha=findViewById(R.id.btnFecha)
        dpFecha=findViewById(R.id.dpFecha)



        dpFecha?.setOnDateChangedListener {//cuando la fecha llegue a cambiar
                dpFecha,anio,mes,dia ->
                etFecha?.setText(getFecha())//le vamos a asignar la fecha seleccionada en el datepicker al editetxt
                dpFecha.visibility=View.GONE//y se vuelve a hacer invisible el datepicker
        }

    }

    fun getFecha():String{//funcion que va obtener la fecha actual del calendario//ya no XD

        var dia=dpFecha?.dayOfMonth.toString().padStart(2,'0')//padstart 1.-se rellene con dos caracteres 2.-si falta uno se rellena con 0
        var mes=(dpFecha!!.month+1).toString().padStart(2,'0')//+1 porque va del 0 al 11
        var anio=dpFecha?.year.toString().padStart(4,'0')

        parametros.putString("Mes",mes)
        parametros.putInt("Dia",dia.toInt())

        return dia+"/"+mes+"/"+anio
    }

    fun muestraCalendario(view: View){//cuando damos click se va a mostrar el calendario
        dpFecha?.visibility=View.VISIBLE

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun click(view: View) {
        if (binding.etNcuenta.text.isNotEmpty()) {//usamos manejos de exepciones para no crashear
            val Ncuenta = binding.etNcuenta.text.toString()//.toInt()
            camposllenados += 1
           // val intent: Intent = Intent(this,MainActivity2::class.java)
           // val parametros = Bundle()

           /* parametros.putString("nombre", binding.etNombre.text.toString())//1.-llave 2.-Valor
            parametros.putString("Ncuenta", binding.etNcuenta.text.toString())
            parametros.putString("Correo", binding.etCorreo.text.toString())
            parametros.putString("Fecha", binding.etFecha.text.toString())

            intent.putExtras(parametros)
            startActivity(intent)
            */

        }else{
            Toast.makeText(this@MainActivity, resources.getString(R.string.ingresa_valor),Toast.LENGTH_SHORT).show()
            binding.etNcuenta.error = getString(R.string.faltaNumCuenta)
        }

        if (binding.etNombre.text.isNotEmpty()) {//usamos manejos de exepciones para no crashear
            val numero = binding.etNombre.text.toString()
            camposllenados += 1

        }else{

            Toast.makeText(this@MainActivity, resources.getString(R.string.ingresa_valor),Toast.LENGTH_SHORT).show()
            binding.etNombre.error = getString(R.string.faltaNombre)

        }

        if (binding.etCorreo.text.isNotEmpty()) {//usamos manejos de exepciones para no crashear
            val numero = binding.etCorreo.text.toString()
            camposllenados += 1

        }else{

            Toast.makeText(this@MainActivity, resources.getString(R.string.ingresa_valor),Toast.LENGTH_SHORT).show()
            binding.etCorreo.error = getString(R.string.faltaNCorreo)

        }

        if (binding.etFecha.text.isNotEmpty()) {//usamos manejos de exepciones para no crashear
            val edad = binding.tvEdadreal.text.toString()
            camposllenados += 1
            val fechaActual = Instant.now().toString()//2021-01-13T19:38:09.199Z
            val fechaActual2 = fechaActual.split(Regex("T"))//[2021-01-13 ,19:38:09.199Z]
            val fechaActual3=fechaActual2[0].split(Regex("-"))//[2021,01,13]

            val fechaNacimiento = etFecha?.text.toString().split(Regex("/"))//[31,03,1998]

            val Edad=fechaActual3[0].toInt() - fechaNacimiento[2].toInt()

            binding.tvEdadreal.setText(Edad.toString())

        }else{
            Toast.makeText(this@MainActivity, resources.getString(R.string.ingresa_valor),Toast.LENGTH_SHORT).show()
            binding.etFecha.error = getString(R.string.faltaFecha)
        }

        if(camposllenados==4){

            val intent: Intent = Intent(this,MainActivity2::class.java)
            val parametros = Bundle()
            parametros.putString("nombre", binding.etNombre.text.toString())//1.-llave 2.-Valor
            parametros.putString("Ncuenta", binding.etNcuenta.text.toString())
            parametros.putString("Correo", binding.etCorreo.text.toString())
            //parametros.putString("Fecha", binding.etFecha.text.toString())
            parametros.putString("Edad", binding.tvEdadreal.text.toString())

            intent.putExtras(parametros)
            startActivity(intent)

        }

    }

}//////////////////////






