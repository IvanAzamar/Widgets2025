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
import com.bumptech.glide.load.engine.DiskCacheStrategy
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

        /*
        findViewById<MaterialButton>(R.id.btnBuy).setOnClickListener {
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

        binding.btnSkip.setOnClickListener {
            binding.Card.visibility = View.GONE
        }

val url:String="https://static.promodescuentos.com/events/raw/LvpsS/1_1/fs/895x577/qt/80/1_1.jpg"
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.baseline_image_search_24)
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.imgUrl)
    }

}