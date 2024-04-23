package com.hamaartootinpinheads.utils;

import android.app.Application;

public class HamaarTootinPinHeadsUtils extends Application {

  static {
    System.loadLibrary("hamaar-lib");
  }

  public static native String tootinPrivateKey();
  public static native String tootinPrivateMethod();
  public static native String tootinPrivateSus();
  public static native String tootinPrivateReturn();
}
