package com.example.mvvmroomapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroomapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var db: QuotesDatabase
    private lateinit var repo: QuotesRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        db = QuotesDatabase.getInstance(this)
        repo = QuotesRepository(db.quotesDao())
        val viewModel =
            ViewModelProvider(this, QuotesViewmodelFactory(repo))[QuotesViewModel::class.java]

        viewModel.getQuotes().observe(this) {
            binding.text2.text = it.toString()
        }

        binding.btnPain.setOnClickListener {
            val q = Quotes(1, "text", "test")
            viewModel.insertQuotes(q)
        }
    }
}