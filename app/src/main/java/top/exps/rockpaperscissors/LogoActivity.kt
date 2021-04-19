package top.exps.rockpaperscissors

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import top.exps.rockpaperscissors.databinding.ActivityLogoBinding

class LogoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startButton.setOnClickListener {
            Intent(this@LogoActivity, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        // Coutdown
//        Timer().schedule(object : TimerTask() {
//            override fun run() {
//                Intent(this@LogoActivity, MainActivity::class.java).apply {
//                    startActivity(this)
//                }
//            }
//        }, 3000L)
    }
}