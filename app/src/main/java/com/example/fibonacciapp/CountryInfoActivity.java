package com.example.fibonacciapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.URL;

public class CountryInfoActivity extends AppCompatActivity {

  @WorkerThread
  private Drawable getDrawableFromUrl(String url) {
    try {
      InputStream is = (InputStream) new URL(url).getContent();
      return Drawable.createFromStream(is, "");
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_country_info);
    Country country = (Country) getIntent().getSerializableExtra("country");
    TextView capitalTextView = findViewById(R.id.capitalTextView);
    TextView nombrePaisTextView = findViewById(R.id.nombrePaisTextView);
    TextView nombrePaisIntTextView = findViewById(R.id.nombrePaisIntTextView);
    TextView siglaTextView = findViewById(R.id.siglaTextView);
    ImageView countryFlagImageView = findViewById(R.id.countryFlagImageView);
    capitalTextView.setText(country.getCapital());
    nombrePaisTextView.setText(country.getCountryName());
    nombrePaisIntTextView.setText(country.getCountryNameInt());
    siglaTextView.setText(country.getCountryCode());
    Thread t = new Thread(() -> {
      Drawable d = getDrawableFromUrl("https://www.countryflags.io/"
              + country.getCountryCode() + "/flat/64.png");
      runOnUiThread(() -> countryFlagImageView.setImageDrawable(d));
    });
    t.start();
  }
}