package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class FibonacciWebView extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fibonacci_web_view);
    WebView fibonacciWebView = findViewById(R.id.fibonacciWebView);
    fibonacciWebView.loadUrl("https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci");
  }
}