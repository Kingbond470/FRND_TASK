package dev.kingbond.frnd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.kingbond.frnd.R
import dev.kingbond.frnd.databinding.ActivityMainBinding

class ShowTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}