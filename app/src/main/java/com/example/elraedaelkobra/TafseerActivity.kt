package com.example.elraedaelkobra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elraedaelkobra.databinding.ActivityTafseerBinding

class TafseerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTafseerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTafseerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        toolbar.setNavigationOnClickListener (
//            object: View.OnClickListener{
//                override fun onClick(p0: View?) {
//                    finish()
//                }
//            }
//        )

        val tafseerText = intent.getStringExtra("ayah_tafseer")
        binding.tafseer.text = tafseerText

    }
}