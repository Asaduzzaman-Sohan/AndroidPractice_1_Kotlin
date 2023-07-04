package com.example.practice1withkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.practice1withkotlin.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bWebView.webViewClient = WebViewClient()
        binding.bWebView.settings.javaScriptEnabled = true
        binding.bWebView.loadUrl("https://developer.android.com/topic/libraries/view-binding#kts")
    }
}