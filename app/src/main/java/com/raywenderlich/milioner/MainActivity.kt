package com.raywenderlich.milioner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val price = 0

        nextLevel(round, price)
    }

    @SuppressLint("SetTextI18n")
    private fun nextLevel(round: Int, price: Int) {
        var thisRound = round
        var thisPrice = price

        binding.questionNumberTextView.text = "Question ${thisRound + 1}"
        binding.questionTextView.text = questions[thisRound].question
        binding.priceTextView.text = "Current reward: $thisPrice $"

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
                Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                thisPrice += questions[thisRound].price
                thisRound += 1
                if (thisRound < 15) {
                    nextLevel(thisRound, thisPrice)
                } else {
                    Toast.makeText(this, "YOU WON! CONGRATULATIONS!", Toast.LENGTH_SHORT).show()
                    nextLevel(0, 0)
                }
            } else {
                Toast.makeText(this, "Wrong answer! Better luck next time!", Toast.LENGTH_SHORT)
                    .show()
                nextLevel(0, 0)
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