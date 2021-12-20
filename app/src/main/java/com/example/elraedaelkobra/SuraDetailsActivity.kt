package com.example.elraedaelkobra

import VersesAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.elraedaelkobra.databinding.ActivitySuraDetailsBinding
import com.example.elraedaelkobra.repository.Repository
import com.example.islamicapp.ui.Constants

class SuraDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuraDetailsBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        initRecyclerView()

        val suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)

        binding.titleTextView.text = suraName
        readSureFile(suraPos)


    }

    private fun initRecyclerView() {

        recyclerView = findViewById(R.id.surah_details_recycler_view)
        adapter = VersesAdapter()
        adapter.onItemCLickListener = object : VersesAdapter.OnItemClickListener {

            override fun onItemClick(position: Int, item: String) {

                Toast.makeText(
                    this@SuraDetailsActivity,
                    "Ayah number : ${position + 1}\n Ayah name : $item ",
                    Toast.LENGTH_LONG
                ).show()
                val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)
                showAyahTafseer(suraPos, position)
            }
        }
        recyclerView.adapter = adapter
    }

    private fun showAyahTafseer(suraPos: Int, versePosition: Int) {

        val suraNumber = suraPos + 1
        val ayahNumber = versePosition + 1
        viewModel.getPost2(suraNumber, ayahNumber)
        viewModel.myResponse2.observe(this, Observer { response ->

            if (response.isSuccessful) {

                val intent = Intent(this, TafseerActivity::class.java)
                val tafseer = response.body()?.text.toString()

                intent.putExtra("ayah_tafseer", tafseer)
                startActivity(intent)

            } else {

                Toast.makeText(this, response.code().toString(), Toast.LENGTH_LONG).show()
            }
        })


    }

    fun readSureFile(suraPos: Int) {
        val fileName = "${suraPos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)
    }
}