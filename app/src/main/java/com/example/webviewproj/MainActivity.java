package com.example.webviewproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] urls = {
            "https://www.facebook.com",
            "https://developer.android.com",
            "https://www.wfis.uni.lodz.pl",
            "https://code.visualstudio.com"
    };
    List<String> urlList = Arrays.asList(urls);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txt = (EditText) findViewById(R.id.editTextText);
        Button ownUrl = (Button) findViewById(R.id.button);

        ownUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = String.valueOf(txt.getText());
                Intent i = new Intent(MainActivity.this, WebView.class);
                i.putExtra("url", url);
                startActivity(i);
            }
        });

        Button randomUrl = (Button) findViewById(R.id.button2);
        randomUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = (int)(Math.random() * urlList.size());
                String url = urlList.get(index);
                Intent i = new Intent(MainActivity.this, WebView.class);
                i.putExtra("url", url);
                startActivity(i);
            }
        });

        Button htmlSite = (Button) findViewById(R.id.button3);
        htmlSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HTMLView.class);
                startActivity(i);
            }
        });
    }
}