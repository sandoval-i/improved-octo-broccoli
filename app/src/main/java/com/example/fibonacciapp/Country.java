package com.example.fibonacciapp;

import java.io.Serializable;

public class Country implements Serializable {
  private final String capital;
  private final String countryName;
  private final String countryNameInt;
  private final String countryCode;

  public Country(String capital, String countryName, String countryNameInt, String countryCode) {
    this.capital = capital;
    this.countryName = countryName;
    this.countryNameInt = countryNameInt;
    this.countryCode = countryCode;
  }

  public String getCapital() {
    return capital;
  }

  public String getCountryName() {
    return countryName;
  }

  public String getCountryNameInt() {
    return countryNameInt;
  }

  public String getCountryCode() {
    return countryCode;
  }

  @Override
  public String toString() {
    return countryNameInt;
  }
}
