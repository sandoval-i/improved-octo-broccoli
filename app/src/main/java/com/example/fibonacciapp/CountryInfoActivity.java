package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CountryInfoActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_country_info);
    Country country = (Country) getIntent().getSerializableExtra("country");
    TextView capitalTextView = findViewById(R.id.capitalTextView);
    TextView nombrePaisTextView = findViewById(R.id.nombrePaisTextView);
    TextView nombrePaisIntTextView = findViewById(R.id.nombrePaisIntTextView);
    TextView siglaTextView = findViewById(R.id.siglaTextView);
    capitalTextView.setText(country.getCapital());
    nombrePaisTextView.setText(country.getCountryName());
    nombrePaisIntTextView.setText(country.getCountryNameInt());
    siglaTextView.setText(country.getCountryCode());
  }
}