package top.exps.rockpaperscissors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import top.exps.rockpaperscissors.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val SCISSORS = 1
    private val ROCK = 2
    private val PAPER = 3

    private val WIN = 1
    private val LOSE = 2
    private val DRAW = 3

    var score = 0
    var scoreWin = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.scissorsButton.setOnClickListener {
            play(SCISSORS)
        }

        binding.rockButton.setOnClickListener {
            play(ROCK)
        }

        binding.paperButton.setOnClickListener {
            play(PAPER)
        }

    }

    private fun play(choose: Int) {


        // random result
        val result: Int = Random.nextInt(1, 4)
        var resultFinal: Int = LOSE

        // Hoa nhau
        if (choose == result) {
            resultFinal = DRAW
            // Neu chon keo, ket qua la bao
        } else if (choose == SCISSORS && result == PAPER) {
            resultFinal = WIN
            // Neu chon bua
        } else if (choose == ROCK && result == SCISSORS) {
            resultFinal = WIN
        } else if (choose == PAPER && result == ROCK) {
            resultFinal = WIN
        }

        showResult(result, resultFinal)
    }

    @SuppressLint(
            "SetTextI18n"
    )
    private fun showResult(result: Int, resultFinal: Int) {
        // set score
        score++

        if (resultFinal == WIN) {
            scoreWin++
        }

        binding.score.text = resources.getString(R.string.score) + ": " + scoreWin.toString() + "/" + score.toString()

        // set image result
        when(result) {
            SCISSORS -> binding.logoImageView.setImageResource(R.drawable.scissors)
            ROCK  -> binding.logoImageView.setImageResource(R.drawable.rock)
            else  -> binding.logoImageView.setImageResource(R.drawable.paper)
        }

        // Snack bar
        val resultAlert = when (resultFinal) {
            WIN -> R.string.win_alert
            LOSE -> R.string.lose_alert
            else -> R.string.draw_alert
        }

        Snackbar.make(binding.snackbarView, resultAlert, Snackbar.LENGTH_SHORT)
            .setAnchorView(binding.logoImageView)
            .show()
    }
}
