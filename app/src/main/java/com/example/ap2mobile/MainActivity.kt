package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var englishButton: Button
    private lateinit var portugueseButton: Button
    private lateinit var textView: TextView

    private var selectedLanguage: String = "en"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startButton)
        englishButton = findViewById(R.id.englishButton)
        portugueseButton = findViewById(R.id.portugueseButton)
        textView = findViewById(R.id.textView)

        englishButton.setOnClickListener {
            selectedLanguage = "en"
            startButton.text = "Start MBTI Quiz"
            textView.text = "Welcome to the MBTI Test"
        }

        portugueseButton.setOnClickListener {
            selectedLanguage = "pt"
            startButton.text = "Iniciar Quiz MBTI"
            textView.text = "Bem vindo ao Teste de MBTI"
        }

        startButton.setOnClickListener {
            val intent = Intent(this, QuestionnaireActivity::class.java)
            intent.putExtra("selectedLanguage", selectedLanguage)
            startActivity(intent)
        }
    }
}
