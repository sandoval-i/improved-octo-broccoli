package com.example.fibonacciapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class FibonacciActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fibonacci);

    TextView fibonacciTextView = findViewById(R.id.fibonacciTextView);
    ImageButton fibonacciImageButton = findViewById(R.id.fibonacciImageButton);

    fibonacciImageButton.setOnClickListener(v -> {
      Intent intent = new Intent(getBaseContext(), FibonacciWebView.class);
      startActivity(intent);
    });

    int kFibonacci = getIntent().getIntExtra("posiciones", 0);
    fibonacciTextView.setText(format(FibonacciHelper.calculateFirstKFibonacci(kFibonacci)));
  }

  private String format(BigInteger[] fibo) {
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < fibo.length; ++i) {
      if (i > 0) text.append('\n');
      text.append(fibo[i].toString());
    }
    return text.toString();
  }
}