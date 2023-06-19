package com.example.webviewproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        android.webkit.WebView myView = (android.webkit.WebView) findViewById(R.id.webView);
        myView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String url = extras.getString("url");
            String html = extras.getString("html");
            if (url != null) {
                myView.loadUrl(url);
            }
            else if (html != null){
                String encoded = Base64.encodeToString(html.getBytes(), Base64.NO_PADDING);
                myView.loadData(encoded, "text/html", "base64");
            }
        }
    }
}