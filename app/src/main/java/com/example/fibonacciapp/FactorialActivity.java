package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_factorial);
    TextView factorialTextView = findViewById(R.id.factorialTextView);

    int number = getIntent().getIntExtra("factorial", 1);
    factorialTextView.setText(format(number));
  }

  String format(int number) {
    StringBuilder text = new StringBuilder();
    long factorial = 1;

    text.append("Operacion: ");
    for (int i = 1; i <= number; ++i) {
      if (i > 1) text.append('*');
      text.append(i);
      factorial *= i;
    }
    text.append("\nResultado: ");
    text.append(factorial);
    return text.toString();
  }
}