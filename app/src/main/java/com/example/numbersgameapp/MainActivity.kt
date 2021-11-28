package com.example.numbersgameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var myButton: Button
    lateinit var textInput: TextView
    lateinit var l1: TextView
    lateinit var l2: TextView
    lateinit var l3: TextView

    var random = Random.nextInt(11)
    var guess = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.submitButton)
        myButton.setOnClickListener{ guessText() }

        textInput = findViewById(R.id.textInput)

        l1 = findViewById<TextView>(R.id.youGuessed)
        l2 = findViewById<TextView>(R.id.youHave)
        l3 = findViewById<TextView>(R.id.numbersOnly)

        l1.visibility = View.INVISIBLE
        l2.visibility = View.INVISIBLE
        l3.visibility = View.INVISIBLE
    }

    private fun guessText() {

        l3.visibility = View.INVISIBLE
        try {
            var input = textInput.text.toString().toInt()
            l1.visibility = View.VISIBLE
            l2.visibility = View.VISIBLE
            l1.text = "You guessed $input"
            if (input!!.toInt() == random) {
                l2.text = "You won! ... try again?"
                guess = 3
                random = Random.nextInt(11)
            }
            else {
                guess--
                l2.text = "You have $guess guesses left"
                if(guess == 0){
                    l2.text = "You lose! ... try again?"
                    guess = 3
                    random = Random.nextInt(11)
                }
            }
        }
        catch (e: Exception) {
            l3.visibility = View.VISIBLE
        }


    }
}