package com.example.webviewproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HTMLView extends AppCompatActivity {

    String html = "<html><body>To jest przykladowa strona na podstawie kodu html.</body></html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlview);

        EditText codeHTML = (EditText) findViewById(R.id.editTextTextMultiLine);

        Button launchHTML = (Button) findViewById(R.id.button4);
        launchHTML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HTMLView.this, WebView.class);
                String code = String.valueOf(codeHTML.getText());
                i.putExtra("html", code);
                startActivity(i);
            }
        });

        Button launchExample = (Button) findViewById(R.id.button5);
        launchExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HTMLView.this, WebView.class);
                i.putExtra("html", html);
                startActivity(i);
            }
        });
    }
}