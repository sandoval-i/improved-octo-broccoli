package com.example.fibonacciapp;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "FibonacciApp";
  private static final int SPINNER_SIZE = 15;
  private static final int FIBONACCI_CODE = 0;
  private static final int FACTORIAL_CODE = 1;

  private EditText posicionesEditText;
  private Spinner factorialSpinner;
  private TextView contadorFibonnacciTextView;
  private TextView contadorFactorialTextView;
  private TextView fechaFibonnacciTextView;
  private TextView fechaFactorialTextView;
  private int contadorFibonacci = 0;
  private int contadorFactorial = 0;

  private String getDate() {
    Calendar calendar = Calendar.getInstance();
    Locale l = getResources().getConfiguration().getLocales().get(0);
    int year = calendar.get(Calendar.YEAR);
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT_FORMAT, l);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    return day + "/" + month + "/" + year + " " + hour + ":" + minute;
  }

  @UiThread
  public void updateFactorial() {
    contadorFactorial++;
    fechaFactorialTextView.setText(getDate());
    contadorFactorialTextView.setText(String.valueOf(contadorFactorial));
  }

  @UiThread
  public void updateFibonacci() {
    contadorFibonacci++;
    fechaFibonnacciTextView.setText(getDate());
    contadorFibonnacciTextView.setText(String.valueOf(contadorFibonacci));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button fibonnaciButton = findViewById(R.id.fibonacciButton);
    Button factorialButton = findViewById(R.id.factorialButton);
    Button paisesButton = findViewById(R.id.paisesButton);
    posicionesEditText = findViewById(R.id.posicionesEditText);
    factorialSpinner = findViewById(R.id.factorialSpinner);

    contadorFactorialTextView = findViewById(R.id.contadorFactorialTextView);
    fechaFactorialTextView = findViewById(R.id.fechaFactorialTextView);

    contadorFibonnacciTextView = findViewById(R.id.contadorFibonacciTextView);
    fechaFibonnacciTextView = findViewById(R.id.fechaFibonacciTextView);

    fibonnaciButton.setOnClickListener(v -> {
      Intent intent = new Intent(getBaseContext(), FibonacciActivity.class);
      String posicionesText = posicionesEditText.getText().toString();
      if (posicionesText.length() > 0) {
        int posiciones = Integer.parseInt(posicionesText);
        intent.putExtra("posiciones", posiciones);
        startActivityForResult(intent, FIBONACCI_CODE);
      }
    });

    String[] spinnerItems = new String[SPINNER_SIZE];
    for (int i = 0; i < SPINNER_SIZE; ++i) {
      spinnerItems[i] = String.valueOf(1 + i);
    }

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_item, spinnerItems);
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    factorialSpinner.setAdapter(arrayAdapter);
    factorialButton.setOnClickListener(v -> {
      Intent intent = new Intent(getBaseContext(), FactorialActivity.class);
      int factorialValue = Integer.parseInt(factorialSpinner.getSelectedItem().toString());
      intent.putExtra("factorial", factorialValue);
      startActivityForResult(intent, FACTORIAL_CODE);
    });

    paisesButton.setOnClickListener(v -> {
      Intent intent = new Intent(getBaseContext(), CountrySelector.class);
      startActivity(intent);
    });

    contadorFibonnacciTextView.setText("0");
    fechaFibonnacciTextView.setText("-");
    contadorFactorialTextView.setText("0");
    fechaFactorialTextView.setText("-");
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == FIBONACCI_CODE) {
      updateFibonacci();
    } else if (requestCode == FACTORIAL_CODE) {
      updateFactorial();
    }
  }
}