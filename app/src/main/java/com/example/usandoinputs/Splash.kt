package com.example.usandoinputs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usandoinputs.databinding.ActivityMainBinding
import com.example.usandoinputs.databinding.ActivitySplashBinding
import kotlin.concurrent.thread

class Splash : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding//Pasos para agregar el binding 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater) //2
        setContentView(binding.root)//3

        thread {
            Thread.sleep(3000)//no siempre es bueno bloquear el hilo principal
            val intent = Intent(this, MainActivity::class.java)//Para pasar a la otra actividad
            startActivity(intent)
            finish()//para terminar con el ciclo de vida de esta activity
        }
    }
}



