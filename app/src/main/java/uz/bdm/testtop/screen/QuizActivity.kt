package uz.bdm.testtop.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quez.*
import kotlinx.android.synthetic.main.activity_quez.imgBack
import uz.bdm.testtop.R
import uz.bdm.testtop.model.ScienceModel

class QuizActivity : AppCompatActivity() {
    lateinit var science: ScienceModel
    var index = 0
    var correctCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quez)
        imgBack.setOnClickListener {
            finish()
        }

        science = intent.getSerializableExtra("extra") as ScienceModel

        btnA.setOnClickListener {
            if (science.quizList[index].correctAnswer == "A"){
                correctCount++
            }

            index++
            setQuiz()
        }

        btnB.setOnClickListener {
            if (science.quizList[index].correctAnswer == "B"){
                correctCount++
            }

            index++
            setQuiz()
        }

        btnC.setOnClickListener {
            if (science.quizList[index].correctAnswer == "C"){
                correctCount++
            }

            index++
            setQuiz()
        }

        btnD.setOnClickListener {
            if (science.quizList[index].correctAnswer == "D"){
                correctCount++
            }

            index++
            setQuiz()
        }

        setQuiz()
    }

    fun setQuiz(){
        if (index < science.quizList.count()){
            val quiz = science.quizList[index]
            tvQuiz.text = quiz.title
            if (quiz.image != null){
                imgQuiz.visibility = View.VISIBLE
                imgQuiz.setImageResource(quiz.image)
            }else{
                imgQuiz.visibility = View.GONE
            }

            btnA.text = quiz.answerA
            btnB.text = quiz.answerB
            btnC.text = quiz.answerC
            btnD.text = quiz.answerD
        }else{
            Toast.makeText(this,
                "Siz ${science.quizList.count()} " +
                        "ta savoldan ${correctCount} ta siga to'g'ri javob berdingiz!",
                Toast.LENGTH_LONG).show()
        }
    }
}