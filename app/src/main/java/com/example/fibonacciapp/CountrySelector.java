package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CountrySelector extends AppCompatActivity {
  Spinner countrySpinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_country_selector);
    countrySpinner = findViewById(R.id.countrySpinner);
    Country[] countries = loadCountriesFromJSON("paises.json");

    ArrayAdapter<Country> arrayAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_item, countries);
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    countrySpinner.setAdapter(arrayAdapter);
    countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
          return;
        }
        Intent intent = new Intent(getBaseContext(), CountryInfoActivity.class);
        intent.putExtra("country", (Country) countrySpinner.getSelectedItem());
        startActivity(intent);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });
  }

  Country[] loadCountriesFromJSON(String filename) {
    Country[] countries;
    try {
      InputStream is = getBaseContext().getAssets().open(filename);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      String json = new String(buffer, StandardCharsets.UTF_8);
      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray("paises");
      countries = new Country[1 + jsonArray.length()];
      countries[0] = new Country("", "", "", "");
      for (int i = 0; i < jsonArray.length(); ++i) {
        JSONObject countryObject = jsonArray.getJSONObject(i);
        String capital = countryObject.getString("capital");
        String countryName = countryObject.getString("nombre_pais");
        String countryNameInt = countryObject.getString("nombre_pais_int");
        String countryCode = countryObject.getString("sigla");
        countries[1 + i] = new Country(capital, countryName, countryNameInt, countryCode);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
    return countries;
  }
}