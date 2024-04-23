package com.hamaartootinpinheads;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HamaarTootinPinheadsPackage implements ReactPackage {

  private final boolean mLoadConstantsAsynchronously;

  public HamaarTootinPinheadsPackage() {
    this(false);
  }

  public HamaarTootinPinheadsPackage(boolean loadConstantsAsynchronously) {
    mLoadConstantsAsynchronously = loadConstantsAsynchronously;
  }
  
  @NonNull
  @Override
  public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
    List<NativeModule> modules = new ArrayList<>();
    modules.add(new HamaarTootinPinheadsModule(reactContext, mLoadConstantsAsynchronously));
    return modules;
  }

  @NonNull
  @Override
  public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
    return Collections.emptyList();
  }
}
