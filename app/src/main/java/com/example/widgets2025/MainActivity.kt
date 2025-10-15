package com.example.widgets2025

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.widgets2025.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding // lateinit porque se inicializa después



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater) //es importante porque infla el layout
        setContentView(binding.root)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*findViewById<MaterialButton>(R.id.btnBuy).setOnClickListener {
            Toast.makeText(this, "Sale", Toast.LENGTH_SHORT).show()
        }
        findViewById<MaterialButton>(R.id.btnSkip).setOnLongClickListener {
            findViewById<MaterialCardView>(R.id.Card).visibility= View.GONE
            true
        }*/
//binding para acceder a las vistas

        binding.btnBuy.setOnClickListener {
            Toast.makeText(this, "Sale", Toast.LENGTH_SHORT).show()
        }

        binding.btnSkip.setOnLongClickListener {
            binding.Card.visibility= View.GONE
            true
        }

val url:String="https://www.tecnm.mx/images/tecnm_virtual/tecnm.png"
        Glide.with(this)
            .load(url)
            .into(binding.imgUrl)
    }

}