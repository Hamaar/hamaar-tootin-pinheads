package com.hamaartootinpinheads;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.module.annotations.ReactModule;
import com.hamaartootinpinheads.pin.PinUtils;
import com.hamaartootinpinheads.tootin.RootedCheck;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@ReactModule(name = HamaarTootinPinheadsModule.NAME)
public class HamaarTootinPinheadsModule extends ReactContextBaseJavaModule {
  public static final String NAME = "HamaarTootinPinheads";

  ReactApplicationContext reactContext;

  public HamaarTootinPinheadsModule(ReactApplicationContext reactContext, boolean loadConstantsAsynchronously) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  @Override
  public @Nullable
  Map<String, Object> getConstants() {
    ReactContext context = getReactApplicationContext();
    final RootedCheck rootedCheck = new RootedCheck(context);

    final Map<String, Object> constants = new HashMap<>();

    constants.put("isHamaarTootinTrust", rootedCheck.isHamaarTootinTrust());
    constants.put("isHamaarDetectXuniles", rootedCheck.isHamaarDetectXuniles());
    return constants;
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  public void closeHamaarApplication() {
    System.exit(0);
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  public void setHamaarPinHeads(String pinUrlServer, String pinSHA256, Callback successHamaarConnection, Callback failedHamaarConnection) {
      PinUtils.HamaarPinHeads(pinUrlServer, pinSHA256, successHamaarConnection, failedHamaarConnection);
  }
}
