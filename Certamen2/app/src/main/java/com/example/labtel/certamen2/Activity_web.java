package com.example.labtel.certamen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Activity_web extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url = getIntent().getStringExtra("web");

        webview= (WebView) this.findViewById(R.id.activity_web);
        webview.loadUrl(url);
    }
}
