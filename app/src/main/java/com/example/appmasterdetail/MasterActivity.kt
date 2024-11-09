package com.example.appmasterdetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.WindowCompat

class MasterActivity : AppCompatActivity() {

    private lateinit var recyclerViewAnimes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_master)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerViewAnimes = findViewById(R.id.animesRV)
        recyclerViewAnimes.adapter = AnimesAdapter(createAnimes(), this) { anime ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("animeName", anime.animeName)
            intent.putExtra("animeAuthor", anime.animeAuthor)
            intent.putExtra("animeImage", anime.animeImage) // Passando o ID da imagem
            intent.putExtra("animeDescription", anime.animeDescription) // Passando a descrição
            startActivity(intent)
        }

        recyclerViewAnimes.layoutManager = LinearLayoutManager(this)
        recyclerViewAnimes.setHasFixedSize(true)
        recyclerViewAnimes.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL)
        )
    }

    private fun createAnimes(): List<Anime> {
        return listOf(
            Anime(R.drawable.shinsekaiyori, "Shin Sekai Yori", "Yusuke Kishi", "Ambientado em um futuro distópico, onde a humanidade vive em uma sociedade pacífica controlada por pessoas com habilidades psíquicas. A história segue um grupo de amigos que, ao crescerem, descobrem segredos obscuros sobre o mundo em que vivem e as verdadeiras intenções de seus governantes."),
            Anime(R.drawable.another, "Another", "Yukito Ayatsuji", "Um mistério de terror psicológico envolvendo uma escola e uma série de mortes inexplicáveis. A trama segue um estudante transferido que descobre uma estranha maldição relacionada a uma turma específica, enquanto tenta desvendar os segredos por trás das mortes misteriosas."),
            Anime(R.drawable.deathnote, "Death Note", "Tsugumi Ohba", "Um thriller psicológico que segue Light Yagami, um estudante do ensino médio que encontra um caderno sobrenatural, capaz de matar qualquer pessoa cujo nome seja escrito nele. Usando o \"Death Note\", Light tenta criar um novo mundo onde ele seja adorado como um deus, mas enfrenta a oposição de L, um brilhante detetive."),
            Anime(R.drawable.shiki, "Shiki", "Fuyumi Ono", "Situado em uma pequena vila, este anime de horror gira em torno de uma série de mortes misteriosas. Os moradores começam a questionar a presença de uma família estrangeira e descobrem que algo sobrenatural está ocorrendo, envolvendo criaturas vampíricas chamadas \"Shiki\"."),
            Anime(R.drawable.codegeass, "Code Geass", "Ichirō Ōkouchi", "Em um mundo onde o Império Britânico domina a maior parte do planeta, Lelouch vi Britannia, um ex-príncipe, obtém um poder misterioso conhecido como Geass, que lhe permite controlar a mente das pessoas. Com o objetivo de derrubar o império e criar um mundo melhor para sua irmã, Lelouch se torna o líder da resistência, em uma luta épica pela liberdade."),
            Anime(R.drawable.arslansenki, "Arslan Senki", "Yoshiki Tanaka", "A história segue Arslan, um jovem príncipe que perde seu reino para invasores e é forçado a fugir. Juntamente com seus aliados, ele embarca em uma jornada para reconquistar seu trono e se tornar um líder respeitado, enquanto enfrenta batalhas políticas e militares no mundo antigo inspirado na Pérsia.")
        )
    }
}
