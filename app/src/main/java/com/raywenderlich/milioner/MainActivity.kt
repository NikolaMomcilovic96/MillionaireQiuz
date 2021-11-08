package com.raywenderlich.milioner

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

        val fiftyFifty = true
        val audience = true
        val friend = true
        val round = 0
        val price = 0

        nextLevel(round, price, fiftyFifty, audience, friend)
    }

    private fun nextLevel(
        round: Int,
        price: Int,
        fiftyFifty: Boolean,
        audience: Boolean,
        friend: Boolean,
    ) {
        var thisRound = round
        var thisPrice = price
        var thisFiftyFifty = fiftyFifty
        var thisAudience = audience
        var thisFriend = friend
        val question = "Question ${thisRound + 1}"
        val currentReward = "Current reward: $thisPrice $"

        binding.questionNumberTextView.text = question
        binding.questionTextView.text = questions[thisRound].question
        binding.priceTextView.text = currentReward

        if (fiftyFifty) {
            binding.halfHalfButton.isEnabled = true
        }
        if (audience) {
            binding.audienceButton.isEnabled = true
        }
        if (friend) {
            binding.friendButton.isEnabled = true
        }

        val answers = arrayListOf(
            questions[thisRound].rightAnswer,
            questions[thisRound].wrong1,
            questions[thisRound].wrong2,
            questions[thisRound].wrong3
        )

        val answer1 = answers.random()
        binding.textViewA.text = answer1
        binding.textViewA.setBackgroundResource(R.color.orange)
        answers.remove(answer1)
        val answer2 = answers.random()
        binding.textViewB.text = answer2
        binding.textViewB.setBackgroundResource(R.color.orange)
        answers.remove(answer2)
        val answer3 = answers.random()
        binding.textViewC.text = answer3
        binding.textViewC.setBackgroundResource(R.color.orange)
        answers.remove(answer3)
        val answer4 = answers.random()
        binding.textViewD.text = answer4
        binding.textViewD.setBackgroundResource(R.color.orange)
        answers.remove(answer4)


        fun fiftyFiftyHelp() {
            val wrongAnswers = arrayListOf(
                questions[thisRound].wrong1,
                questions[thisRound].wrong2,
                questions[thisRound].wrong3
            )
            val wrong1 = wrongAnswers.random()
            wrongAnswers.remove(wrong1)
            val wrong2 = wrongAnswers.random()

            if (answer1 == wrong1 || answer1 == wrong2) {
                binding.textViewA.setBackgroundResource(R.color.grey)
            }
            if (answer2 == wrong1 || answer2 == wrong2) {
                binding.textViewB.setBackgroundResource(R.color.grey)
            }
            if (answer3 == wrong1 || answer3 == wrong2) {
                binding.textViewC.setBackgroundResource(R.color.grey)
            }
            if (answer4 == wrong1 || answer4 == wrong2) {
                binding.textViewD.setBackgroundResource(R.color.grey)
            }

            binding.halfHalfButton.isEnabled = false
            thisFiftyFifty = false
        }

        fun askAudienceHelp() {
            binding.audienceButton.isEnabled = false
            thisAudience = false
        }

        fun callFriendHelp() {
            binding.friendButton.isEnabled = false
            thisFriend = false
        }

        fun checkAnswer(answer: String) {
            if (answer == questions[thisRound].rightAnswer) {
                Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                thisPrice += questions[thisRound].price
                thisRound += 1
                if (thisRound < 15) {
                    nextLevel(thisRound, thisPrice, thisFiftyFifty, thisAudience, thisFriend)
                } else {
                    Toast.makeText(this, "YOU WON! CONGRATULATIONS!", Toast.LENGTH_SHORT).show()
                    nextLevel(0, 0, fiftyFifty = true, audience = true, friend = true)
                }
            } else {
                Toast.makeText(this, "Wrong answer! Better luck next time!", Toast.LENGTH_SHORT)
                    .show()
                nextLevel(0, 0, fiftyFifty = true, audience = true, friend = true)
            }
        }

        binding.halfHalfButton.setOnClickListener {
            fiftyFiftyHelp()
        }

        binding.friendButton.setOnClickListener {
            callFriendHelp()
        }

        binding.audienceButton.setOnClickListener {
            askAudienceHelp()
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