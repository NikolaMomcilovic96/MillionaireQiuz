package com.raywenderlich.milioner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.raywenderlich.milioner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val round = 0

        nextLevel(round)
    }

    private fun nextLevel(round: Int) {
        var thisRound = round

        binding.questionNumberTextView.text = "Question ${thisRound + 1}"
        binding.questionTextView.text = questions[thisRound].question

        val answers = arrayListOf(questions[thisRound].rightAnswer,
            questions[thisRound].wrong1,
            questions[thisRound].wrong2,
            questions[thisRound].wrong3)

        val answer1 = answers.random()
        binding.textViewA.text = answer1
        answers.remove(answer1)
        val answer2 = answers.random()
        binding.textViewB.text = answer2
        answers.remove(answer2)
        val answer3 = answers.random()
        binding.textViewC.text = answer3
        answers.remove(answer3)
        val answer4 = answers.random()
        binding.textViewD.text = answer4
        answers.remove(answer4)

        fun checkAnswer(answer: String) {
            if (answer == questions[thisRound].rightAnswer) {
                Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show()
                thisRound += 1
                if (thisRound < 15) {
                    Log.d("Round", thisRound.toString())
                    Log.d("Proba", "Stiglo je do ovoga")
                    nextLevel(thisRound)
                }
            } else {
                Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show()
                nextLevel(0)
            }
        }

        binding.textViewA.setOnClickListener {
            checkAnswer(answer1)
        }
        binding.textViewB.setOnClickListener {
            checkAnswer(answer2)
        }
        binding.textViewC.setOnClickListener {
            checkAnswer(answer3)
        }
        binding.textViewD.setOnClickListener {
            checkAnswer(answer4)
        }
    }
}