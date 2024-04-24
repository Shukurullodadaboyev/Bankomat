package com.example.imtihon18
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.imtihon18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.editText.addTextChangedListener {
            binding.editText.setBackgroundResource(R.drawable.style1)
        }
        binding.button.setOnClickListener {
            try {
                if (binding.editText.text.toString().toInt() < 1000) {
                    binding.editText.setBackgroundResource(R.drawable.style2)
                } else {
                    val media = MediaPlayer.create(this, R.raw.sound)
                    media.start()
                    val pul = binding.editText.text.toString().toInt()
                    val yuz = pul / 100000
                    val ellik = (pul - yuz * 100000) / 50000
                    val on = (pul - (yuz * 100000 + ellik * 50000)) / 10000
                    val besh = (pul - (yuz * 100000 + ellik * 50000 + on * 10000)) / 5000
                    val bir = (pul - (yuz * 100000 + ellik * 50000 + on * 10000 + besh * 5000)) / 1000

                    binding.text1.text = yuz.toString()
                    binding.text2.text = ellik.toString()
                    binding.text3.text = on.toString()
                    binding.text4.text = besh.toString()
                    binding.text5.text = bir.toString()
                }
            } catch (e: Exception) {
                binding.editText.setBackgroundResource(R.drawable.style2)
            }
        }
    }
}