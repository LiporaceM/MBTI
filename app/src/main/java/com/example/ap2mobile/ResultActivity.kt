package com.example.ap2mobile

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var mbtiTypeTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var mbtiImageView: ImageView
    private lateinit var knowMoreButton: Button
    private lateinit var backToMainButton: Button

    private val descriptionsEn = mapOf(
        "INTJ" to "INTJ: You are a strategic thinker, highly analytical and logical. You excel at seeing the big picture and planning for the future.",
        "INTP" to "INTP: You are a deep thinker and a problem solver. You love to analyze complex systems and find innovative solutions.",
        "ENTJ" to "ENTJ: You are a natural leader, assertive and confident. You excel at organizing people and resources to achieve goals.",
        "ENTP" to "ENTP: You are a visionary and an innovator. You thrive on new ideas and love to challenge the status quo.",
        "INFJ" to "INFJ: You are a compassionate and insightful person. You are driven by your values and a desire to make a difference in the world.",
        "INFP" to "INFP: You are a creative and idealistic person. You are guided by your principles and have a strong sense of personal integrity.",
        "ENFJ" to "ENFJ: You are a charismatic and empathetic leader. You excel at inspiring and motivating others to achieve their potential.",
        "ENFP" to "ENFP: You are an enthusiastic and imaginative person. You love exploring new possibilities and inspiring others with your vision.",
        "ISTJ" to "ISTJ: You are a responsible and reliable person. You excel at organizing tasks and following through on commitments.",
        "ISFJ" to "ISFJ: You are a caring and dependable person. You are driven by a strong sense of duty and a desire to help others.",
        "ESTJ" to "ESTJ: You are a practical and efficient person. You excel at managing people and resources to achieve tangible results.",
        "ESFJ" to "ESFJ: You are a warm and social person. You thrive on helping others and creating a harmonious environment.",
        "ISTP" to "ISTP: You are a logical and observant person. You excel at understanding how things work and solving practical problems.",
        "ISFP" to "ISFP: You are a gentle and sensitive person. You are driven by your values and have a strong appreciation for beauty and art.",
        "ESTP" to "ESTP: You are an energetic and action-oriented person. You thrive on excitement and love to live in the moment.",
        "ESFP" to "ESFP: You are a fun-loving and spontaneous person. You excel at creating joyful experiences and living life to the fullest."
    )

    private val descriptionsPt = mapOf(
        "INTJ" to "INTJ: Você é um pensador estratégico, altamente analítico e lógico. Você é excelente em ver o panorama geral e planejar para o futuro.",
        "INTP" to "INTP: Você é um pensador profundo e um solucionador de problemas. Você adora analisar sistemas complexos e encontrar soluções inovadoras.",
        "ENTJ" to "ENTJ: Você é um líder natural, assertivo e confiante. Você é excelente em organizar pessoas e recursos para alcançar objetivos.",
        "ENTP" to "ENTP: Você é um visionário e um inovador. Você prospera com novas ideias e adora desafiar o status quo.",
        "INFJ" to "INFJ: Você é uma pessoa compassiva e perspicaz. Você é movido pelos seus valores e pelo desejo de fazer a diferença no mundo.",
        "INFP" to "INFP: Você é uma pessoa criativa e idealista. Você é guiado por seus princípios e tem um forte senso de integridade pessoal.",
        "ENFJ" to "ENFJ: Você é um líder carismático e empático. Você é excelente em inspirar e motivar outros a atingir seu potencial.",
        "ENFP" to "ENFP: Você é uma pessoa entusiástica e imaginativa. Você adora explorar novas possibilidades e inspirar os outros com sua visão.",
        "ISTJ" to "ISTJ: Você é uma pessoa responsável e confiável. Você é excelente em organizar tarefas e cumprir compromissos.",
        "ISFJ" to "ISFJ: Você é uma pessoa carinhosa e dependente. Você é movido por um forte senso de dever e um desejo de ajudar os outros.",
        "ESTJ" to "ESTJ: Você é uma pessoa prática e eficiente. Você é excelente em gerenciar pessoas e recursos para alcançar resultados tangíveis.",
        "ESFJ" to "ESFJ: Você é uma pessoa calorosa e social. Você prospera em ajudar os outros e criar um ambiente harmonioso.",
        "ISTP" to "ISTP: Você é uma pessoa lógica e observadora. Você é excelente em entender como as coisas funcionam e resolver problemas práticos.",
        "ISFP" to "ISFP: Você é uma pessoa gentil e sensível. Você é movido por seus valores e tem uma forte apreciação pela beleza e arte.",
        "ESTP" to "ESTP: Você é uma pessoa enérgica e orientada para a ação. Você prospera com a excitação e adora viver o momento.",
        "ESFP" to "ESFP: Você é uma pessoa divertida e espontânea. Você é excelente em criar experiências alegres e viver a vida ao máximo."
    )

    private val images = mapOf(
        "INTJ" to R.drawable.intj,
        "INTP" to R.drawable.intp,
        "ENTJ" to R.drawable.entj,
        "ENTP" to R.drawable.entp,
        "INFJ" to R.drawable.infj,
        "INFP" to R.drawable.infp,
        "ENFJ" to R.drawable.enfj,
        "ENFP" to R.drawable.enfp,
        "ISTJ" to R.drawable.istj,
        "ISFJ" to R.drawable.isfj,
        "ESTJ" to R.drawable.estj,
        "ESFJ" to R.drawable.esfj,
        "ISTP" to R.drawable.istp,
        "ISFP" to R.drawable.isfp,
        "ESTP" to R.drawable.estp,
        "ESFP" to R.drawable.esfp
    )

    private val colors = mapOf(
        "INTJ" to "#8F72E9", "INTP" to "#8F72E9", "ENTJ" to "#8F72E9", "ENTP" to "#8F72E9", // Roxo
        "INFJ" to "#73BC6D", "INFP" to "#73BC6D", "ENFJ" to "#73BC6D", "ENFP" to "#73BC6D", // Verde
        "ISTJ" to "#7393BC", "ISFJ" to "#7393BC", "ESTJ" to "#7393BC", "ESFJ" to "#7393BC", // Azul
        "ISTP" to "#E9C672", "ISFP" to "#E9C672", "ESTP" to "#E9C672", "ESFP" to "#E9C672"  // Amarelo
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mbtiTypeTextView = findViewById(R.id.mbtiTypeTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        mbtiImageView = findViewById(R.id.mbtiImageView)
        knowMoreButton = findViewById(R.id.knowMoreButton)
        backToMainButton = findViewById(R.id.backToMainButton)

        val mbtiType = intent.getStringExtra("mbtiType") ?: "N/A"
        val selectedLanguage = intent.getStringExtra("selectedLanguage") ?: "en"

        mbtiTypeTextView.text = mbtiType
        mbtiTypeTextView.setTextColor(Color.parseColor(colors[mbtiType]))

        val description = if (selectedLanguage == "pt") {
            descriptionsPt[mbtiType]
        } else {
            descriptionsEn[mbtiType]
        }

        descriptionTextView.text = description

        val imageResId = images[mbtiType]
        if (imageResId != null) {
            mbtiImageView.setImageResource(imageResId)
        }

        knowMoreButton.text = if (selectedLanguage == "pt") {
            "Quer saber mais sobre as personalidades?"
        } else {
            "Want to know more about the personalities?"
        }

        knowMoreButton.setOnClickListener {
            val url = if (selectedLanguage == "pt") {
                "https://www.16personalities.com/br/descricoes-dos-tipos"
            } else {
                "https://www.16personalities.com/personality-types"
            }
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        backToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
