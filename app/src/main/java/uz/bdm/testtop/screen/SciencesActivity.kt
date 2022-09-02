package uz.bdm.testtop.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_sciences.*
import uz.bdm.testtop.R
import uz.bdm.testtop.model.QuizModel
import uz.bdm.testtop.model.ScienceModel
import uz.bdm.testtop.view.SciencesAdapter
import uz.bdm.testtop.view.SciencesAdapterCallback


class SciencesActivity : AppCompatActivity() {

    val sciences = listOf(

        ScienceModel("Matematika", listOf(
            QuizModel("2 ning kvadrati nechi?", null, "2", "4", "8", "16", "B"),
            QuizModel(" ? ni toping ", R.drawable.m75, "25", "70", "30", "75", "D"),
            QuizModel("17 + 38 = ?", null, "58", "54", "55", "45", "C"),
            QuizModel("97+37 = ?", null, "134", "144", "143", "146", "A"),
            QuizModel(" x ni toping", R.drawable.m30, "30", "60", "3", "5", "A"),
            QuizModel(" katakcha ichidagi sonno toping ?", R.drawable.m1, "2", "1", "4", "3", "B")
        )),

        ScienceModel("Ona tili",  listOf(
            QuizModel("Nechta unli harf bor?", null, "5", "6", "8", "7", "B"),
            QuizModel("...ona , bir harf qoyish orqali soz hosil qiling?", R.drawable.logos, "h", "y", "b", "x", "D"),
        )),

        ScienceModel("Fizika",  listOf(
            QuizModel("Uzunlik olchov birligi ?", null, "kg", "m", "l", "g", "B")
        )),

        ScienceModel("Ingliz tili",  listOf(
            QuizModel("Helo so'zini manosi ?", null, "Xayr", "Salom", "Ha", "Sen", "B"),
        )),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sciences)

        imgBack.setOnClickListener {
            finish()
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SciencesAdapter(sciences, object: SciencesAdapterCallback {
            override fun onClick(item: ScienceModel) {
                val intent = Intent(this@SciencesActivity, QuizActivity::class.java)
                intent.putExtra("extra", item)
                startActivity(intent)
            }
        })
    }
}