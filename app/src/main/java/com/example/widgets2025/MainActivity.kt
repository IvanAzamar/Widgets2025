package com.example.widgets2025

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.widgets2025.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding // lateinit porque se inicializa después
// Daniel Guevara


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //es importante porque infla el layout
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
        carga("https://huimanguillo.tecnm.mx/wp-content/uploads/2021/05/WhatsApp-Image-2021-04-20-at-1.00.16-PM-e1737412695280.jpeg")

        binding.btnBuy.setOnClickListener {
            Toast.makeText(this, "Sale", Toast.LENGTH_SHORT).show()
            carga(binding.EtUrl.text.toString())
        }

        binding.EtUrl.addTextChangedListener {
            carga(binding.EtUrl.text.toString())
        }

        binding.btnSkip.setOnClickListener {
            binding.Card.visibility = View.GONE
        }

        binding.emailTv.setOnFocusChangeListener { view, focus ->
            if (focus) {
                binding.emailTv.setBackgroundColor(Color.GRAY)
                binding.emailTv.setTextColor(Color.BLUE)
            } else {
                binding.emailTv.setBackgroundColor(Color.WHITE)
            }
        }

        binding.ChipURL.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked)
                binding.EtUrl.setText(chip.text.toString())
        }

        binding.ChipURL.setOnCloseIconClickListener {
        binding.ChipURL.visibility =View.GONE
        }

        binding.Slider1.addOnChangeListener { slider, value, fromUser ->
            binding.tvTitlealt.text = "Gracias por calificarnos con : " +value.toInt().toString()
        }

        binding.Grupo1.addOnButtonCheckedListener { group, checkedId, isChecked ->

            when(checkedId){
                R.id.btnGroupA -> binding.tvTitlealt.setTextColor(Color.RED)
                R.id.btnGroupB -> binding.tvTitlealt.setTextColor(Color.GREEN)
                R.id.btnGroupC -> binding.tvTitlealt.setTextColor(Color.BLUE)
            }
        }

    }


    private fun carga(url: String?){
             Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .placeholder(R.drawable.baseline_image_search_24)
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.imgUrl)
    }

}