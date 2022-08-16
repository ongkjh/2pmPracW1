package com.example.a2pmpracw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.a2pmpracw1.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    /*lateinit var diceImg :ImageView
    lateinit var numbText : TextView
    lateinit var nameText : TextView
    lateinit var playerNameTxt:TextView*/
    lateinit var binding: ActivityMainBinding
    private val gameInfo: GameInfo = GameInfo("Ong","0")
    private var totalScore: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        /*diceImg = findViewById(R.id.diceImage)
        numbText = findViewById(R.id.numbTxt)
        nameText = findViewById(R.id.EditPlayerName)
        playerNameTxt = findViewById(R.id.playerName)*/
       /* val rollBtn:Button = findViewById(R.id.rollButton)*/

        binding.gameInfo = gameInfo
        binding.rollButton.setOnClickListener { rollDice() }
        /*val updateBtn:Button = findViewById(R.id.updateButton)*/
        binding.updateButton.setOnClickListener { updateName(it) }
    }

    private fun updateName(view : View){
        binding.apply{
            gameInfo?.playerName = EditPlayerName.text.toString()
            invalidateAll()
        }

        /*binding.playerName.text = binding.EditPlayerName.text*/
        /*playerNameTxt.text = nameText.text*/

    }

    private fun rollDice(){
        val randNum = (1..6).random()
//        val numberTxt : TextView = findViewById(R.id.numbTxt)
        totalScore += randNum
        binding.numbTxt.text = totalScore.toString()

//        val diceImg : ImageView = findViewById(R.id.diceImage)
        val imgSrc = when (randNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

       binding.diceImage.setImageResource(imgSrc)
    }
}