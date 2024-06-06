package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionnaireActivity : AppCompatActivity() {

    private lateinit var answersGroups: List<RadioGroup>
    private lateinit var submitButton: Button

    private val questionsEn = listOf(
        "Do you prefer to work in groups or alone?",
        "Do you prefer socializing with people or spending time alone?",
        "Do you feel energized by social interactions or by spending time alone?",
        "Do you enjoy being the center of attention or observing from the sidelines?",
        "Do you speak more often than you listen or listen more often than you speak?",
        "Do you focus more on facts or possibilities?",
        "Do you value realism or imagination more?",
        "Do you prefer practical or theoretical information?",
        "Do you trust experience more than instincts?",
        "Do you focus more on what is present or what could be?",
        "Do you make decisions with your head or your heart?",
        "Do you value logic over emotions?",
        "Do you prefer justice over mercy?",
        "Do you focus more on fairness or harmony?",
        "Do you find it more important to be just or kind?",
        "Do you prefer a planned or spontaneous lifestyle?",
        "Do you like to have things decided or remain open to new information?",
        "Do you prefer being organized or flexible?",
        "Do you prefer schedules or go with the flow?",
        "Do you like to have clear plans or adapt as you go?"
    )

    private val questionsPt = listOf(
        "Você prefere trabalhar em grupo ou sozinho?",
        "Você prefere socializar com as pessoas ou passar tempo sozinho?",
        "Você se sente energizado por interações sociais ou passando tempo sozinho?",
        "Você gosta de ser o centro das atenções ou observar dos bastidores?",
        "Você fala mais do que ouve ou ouve mais do que fala?",
        "Você foca mais em fatos ou possibilidades?",
        "Você valoriza mais o realismo ou a imaginação?",
        "Você prefere informações práticas ou teóricas?",
        "Você confia mais na experiência ou na intuição?",
        "Você foca mais no presente ou no que pode ser?",
        "Você toma decisões com a cabeça ou com o coração?",
        "Você valoriza mais a lógica ou as emoções?",
        "Você prefere justiça ou misericórdia?",
        "Você foca mais na justiça ou na harmonia?",
        "Você acha mais importante ser justo ou ser gentil?",
        "Você prefere um estilo de vida planejado ou espontâneo?",
        "Você gosta de ter as coisas decididas ou prefere estar aberto a novas informações?",
        "Você prefere ser organizado ou flexível?",
        "Você prefere ter um cronograma ou seguir o fluxo?",
        "Você gosta de ter planos claros ou adaptar-se conforme vai avançando?"
    )

    private val answersEn = listOf(
        listOf("Groups (E)", "Alone (I)"),
        listOf("Socializing (E)", "Alone (I)"),
        listOf("Social interactions (E)", "Alone (I)"),
        listOf("Center of attention (E)", "Observing (I)"),
        listOf("Speak more often (E)", "Listen more often (I)"),
        listOf("Facts (S)", "Possibilities (N)"),
        listOf("Realism (S)", "Imagination (N)"),
        listOf("Practical (S)", "Theoretical (N)"),
        listOf("Experience (S)", "Instincts (N)"),
        listOf("What is present (S)", "What could be (N)"),
        listOf("Head (T)", "Heart (F)"),
        listOf("Logic (T)", "Emotions (F)"),
        listOf("Justice (T)", "Mercy (F)"),
        listOf("Fairness (T)", "Harmony (F)"),
        listOf("Just (T)", "Kind (F)"),
        listOf("Planned (J)", "Spontaneous (P)"),
        listOf("Decided (J)", "Open to new information (P)"),
        listOf("Organized (J)", "Flexible (P)"),
        listOf("Schedules (J)", "Go with the flow (P)"),
        listOf("Clear plans (J)", "Adapt as you go (P)")
    )

    private val answersPt = listOf(
        listOf("Em grupo (E)", "Sozinho (I)"),
        listOf("Socializar (E)", "Sozinho (I)"),
        listOf("Interações sociais (E)", "Sozinho (I)"),
        listOf("Centro das atenções (E)", "Observando (I)"),
        listOf("Fala mais (E)", "Ouve mais (I)"),
        listOf("Fatos (S)", "Possibilidades (N)"),
        listOf("Realismo (S)", "Imaginação (N)"),
        listOf("Práticas (S)", "Teóricas (N)"),
        listOf("Experiência (S)", "Intuição (N)"),
        listOf("No presente (S)", "No que pode ser (N)"),
        listOf("Cabeça (T)", "Coração (F)"),
        listOf("Lógica (T)", "Emoções (F)"),
        listOf("Justiça (T)", "Misericórdia (F)"),
        listOf("Justiça (T)", "Harmonia (F)"),
        listOf("Justo (T)", "Gentil (F)"),
        listOf("Planejado (J)", "Espontâneo (P)"),
        listOf("Decididas (J)", "Aberto a novas informações (P)"),
        listOf("Organizado (J)", "Flexível (P)"),
        listOf("Cronograma (J)", "Seguir o fluxo (P)"),
        listOf("Planos claros (J)", "Adaptar-se conforme vai avançando (P)")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        answersGroups = listOf(
            findViewById(R.id.answersGroup1),
            findViewById(R.id.answersGroup2),
            findViewById(R.id.answersGroup3),
            findViewById(R.id.answersGroup4),
            findViewById(R.id.answersGroup5),
            findViewById(R.id.answersGroup6),
            findViewById(R.id.answersGroup7),
            findViewById(R.id.answersGroup8),
            findViewById(R.id.answersGroup9),
            findViewById(R.id.answersGroup10),
            findViewById(R.id.answersGroup11),
            findViewById(R.id.answersGroup12),
            findViewById(R.id.answersGroup13),
            findViewById(R.id.answersGroup14),
            findViewById(R.id.answersGroup15),
            findViewById(R.id.answersGroup16),
            findViewById(R.id.answersGroup17),
            findViewById(R.id.answersGroup18),
            findViewById(R.id.answersGroup19),
            findViewById(R.id.answersGroup20)
        )

        submitButton = findViewById(R.id.submitButton)

        val selectedLanguage = intent.getStringExtra("selectedLanguage")

        val questions = if (selectedLanguage == "pt") questionsPt else questionsEn
        val answers = if (selectedLanguage == "pt") answersPt else answersEn

        // Set the questions and answers in the appropriate language
        for (index in 0 until 20) {
            val questionTextViewId = resources.getIdentifier("question${index + 1}", "id", packageName)
            val questionTextView = findViewById<TextView>(questionTextViewId)
            questionTextView.text = questions[index]

            val answer1Id = resources.getIdentifier("answer${index + 1}_1", "id", packageName)
            val answer2Id = resources.getIdentifier("answer${index + 1}_2", "id", packageName)
            findViewById<RadioButton>(answer1Id).text = answers[index][0]
            findViewById<RadioButton>(answer2Id).text = answers[index][1]
        }

        submitButton.text = if (selectedLanguage == "pt") "Enviar" else "Submit"

        submitButton.setOnClickListener {
            var scoreE = 0
            var scoreI = 0
            var scoreS = 0
            var scoreN = 0
            var scoreT = 0
            var scoreF = 0
            var scoreJ = 0
            var scoreP = 0

            for ((index, group) in answersGroups.withIndex()) {
                val selectedId = group.checkedRadioButtonId
                if (selectedId == -1) {
                    Toast.makeText(this, if (selectedLanguage == "pt") "Por favor, responda todas as perguntas" else "Please answer all questions", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                when (index) {
                    in 0..4 -> {
                        if (selectedId == group.getChildAt(0).id) scoreE++ else scoreI++
                    }
                    in 5..9 -> {
                        if (selectedId == group.getChildAt(0).id) scoreS++ else scoreN++
                    }
                    in 10..14 -> {
                        if (selectedId == group.getChildAt(0).id) scoreT++ else scoreF++
                    }
                    in 15..19 -> {
                        if (selectedId == group.getChildAt(0).id) scoreJ++ else scoreP++
                    }
                }
            }

            val mbtiType = (if (scoreE > scoreI) "E" else "I") +
                    (if (scoreS > scoreN) "S" else "N") +
                    (if (scoreT > scoreF) "T" else "F") +
                    (if (scoreJ > scoreP) "J" else "P")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("mbtiType", mbtiType)
            intent.putExtra("selectedLanguage", selectedLanguage)
            startActivity(intent)
        }
    }
}
