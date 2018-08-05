package com.cashslide.userusability

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        var intent = intent
        if (intent.extras.getString("url").isNotEmpty()) {
            var url = intent.extras.getString("url")
            webview.apply {
                settings.javaScriptEnabled = true
                loadUrl(url)
            }

        }
    }
}