package com.example.fibonacciapp;

import java.math.BigInteger;

public class FibonnaciHelper {

  public static BigInteger[] calculateFirstKFibonacci(int k) {
    BigInteger[] f = new BigInteger[k];
    for (int i = 0; i < k; ++i) {
      if (i >= 2) {
        f[i] = f[i - 1].add(f[i - 2]);
      } else {
        f[i] = BigInteger.valueOf(i);
      }
    }
    return f;
  }
}
