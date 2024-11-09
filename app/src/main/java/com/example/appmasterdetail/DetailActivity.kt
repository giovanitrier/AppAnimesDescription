package com.example.appmasterdetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_detail)

        // Configuração de padding de sistema de barras
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recebendo os dados passados pela MasterActivity
        val animeName = intent.getStringExtra("animeName")
        val animeAuthor = intent.getStringExtra("animeAuthor")
        val animeImageResId = intent.getIntExtra("animeImage", 0)
        val animeDescription = intent.getStringExtra("animeDescription") // Capturando a descrição

        // Configurando os TextViews e ImageView com os dados recebidos
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewAuthor = findViewById<TextView>(R.id.textViewAuthor)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription) // Referência ao TextView de descrição
        val imageViewAnime = findViewById<ImageView>(R.id.imageViewAnime)

        textViewName.text = animeName
        textViewAuthor.text = animeAuthor
        textViewDescription.text = animeDescription // Configurando a descrição
        if (animeImageResId != 0) {
            imageViewAnime.setImageResource(animeImageResId)
        }
    }
}
