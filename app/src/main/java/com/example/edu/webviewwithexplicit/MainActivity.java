package com.example.edu.webviewwithexplicit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSearch;
    EditText siteUrl;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSearch = findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(this);
        siteUrl = findViewById(R.id.editTextInput);
        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);//JavaScript 해석 하라고
    }

    @Override
    public void onClick(View view) {
        //콜백함수
        webView.setWebViewClient(new WebViewClient(){
            //콜백함수
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        String address = siteUrl.getText().toString();//입력한 url 가져옴
        if(address.startsWith("http://")==false){
            address="http://"+address;
        }
        webView.loadUrl(address);//url 화면 로드
        webView.requestFocus();

        //키보드 숨기기
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}

