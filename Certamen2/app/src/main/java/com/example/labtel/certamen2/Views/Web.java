package com.example.labtel.certamen2.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.labtel.certamen2.R;

public class Web extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        String url = getIntent().getStringExtra("web");

        webview= (WebView) this.findViewById(R.id.web);
        webview.loadUrl(url);
    }
}
