package com.example.usandoinputs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.usandoinputs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//inflar la vista
        setContentView(binding.root)
/*
        with(binding){
            tvPrueba1.text = "Usando binding"

            tvHelloWorld.setOnClickListener{
                tvPrueba2.text = "Click con binding"
            }

        }
*/
/* esto es lo mismo que usando el width
        binding .tvPrueba1.text = "Usando binding"

        binding.tvHelloWorld.setOnClickListener{
            binding.tvPrueba2.text = "Click con binding"
        }
*/
    }

    fun click(view: View) {
        val numero  = binding.etNcuenta.text.toString().toInt()

        if(esPrimo(numero)){
            binding.tvHelloWorld.text = "El $numero si es primo"
        }else{
            binding.tvHelloWorld.text = "El $numero no es primo"
        }

    }

    fun esPrimo(numero: Int) : Boolean{
        if(numero<=1) return false
        for(i in 2 until numero){
            if(numero % i== 0) return false
        }
        return true
    }

}//////////////////////


