package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et1;
    WebView wv1;

    String url;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.my_btn);
        et1 = findViewById(R.id.my_tv);
        wv1 = findViewById(R.id.my_wv);

    }

    @SuppressLint("SetJavaScriptEnabled")
    public void getWv1() {
        wv1.getSettings().setJavaScriptEnabled(true);
    }


    public void button(View view) {
        url = et1.getText().toString();
        wv1.loadUrl(url);
        wv1.setWebViewClient(new MyWebViewClient());
    }

    private static class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}