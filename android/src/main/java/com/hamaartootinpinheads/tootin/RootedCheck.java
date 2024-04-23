package com.hamaartootinpinheads.tootin;

import android.annotation.SuppressLint;
import android.content.Context;

import com.hamaartootinpinheads.utils.HamaarTootinPinHeadsUtils;
import com.scottyab.rootbeer.RootBeer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RootedCheck {
    private static boolean checkWithHamaarPinHeadsMethod() {
        CheckApiVersion check;

        if (android.os.Build.VERSION.SDK_INT >= 23) {
            check = new GreaterThan23();
        } else {
            check = new LessThan23();
        }
        return check.checkRooted();
    }

    private final boolean hamaarTootinTrust;
    private final RootBeerResults rootBeerResults;

    public RootedCheck(Context context) {
        hamaarTootinTrust = checkWithHamaarPinHeadsMethod();
        rootBeerResults = new RootBeerResults(context);
    }

    public boolean isHamaarTootinTrust() {
        return hamaarTootinTrust || rootBeerResults.isHamaarTootin();
    }

    public Map<String, Object> getResultByDetectionMethod() {
        final Map<String, Object> map = new HashMap<>();

        map.put("hamaarTootinTrust", hamaarTootinTrust);
        map.put("rootBeer", rootBeerResults.toNativeMap());

        return map;
    }

    private static class RootBeerResults {
        private final boolean detectRootManagementApps;
        private final boolean detectPotentiallyDangerousApps;
        private final boolean checkForSuBinary;
        private final boolean checkForDangerousProps;
        private final boolean checkForRWPaths;
        private final boolean detectTestKeys;
        private final boolean checkSuExists;
        private final boolean checkForRootNative;
        private final boolean checkForMagiskBinary;

        RootBeerResults(Context context) {
            final RootBeer rootBeer = new RootBeer(context);
            rootBeer.setLogging(false);

            detectRootManagementApps = rootBeer.detectRootManagementApps();
            detectPotentiallyDangerousApps = rootBeer.detectPotentiallyDangerousApps();
            checkForSuBinary = rootBeer.checkForSuBinary();
            checkForDangerousProps = rootBeer.checkForDangerousProps();
            checkForRWPaths = rootBeer.checkForRWPaths();
            detectTestKeys = rootBeer.detectTestKeys();
            checkSuExists = rootBeer.checkSuExists();
            checkForRootNative = rootBeer.checkForRootNative();
            checkForMagiskBinary = rootBeer.checkForMagiskBinary();
        }

        public boolean isHamaarTootin() {
            return detectRootManagementApps || detectPotentiallyDangerousApps || checkForSuBinary
                    || checkForDangerousProps || checkForRWPaths
                    || detectTestKeys || checkSuExists || checkForRootNative || checkForMagiskBinary;
        }

        public Map<String, Object> toNativeMap() {
            final Map<String, Object> map = new HashMap<>();

            map.put("detectRootManagementApps", detectRootManagementApps);
            map.put("detectPotentiallyDangerousApps", detectPotentiallyDangerousApps);
            map.put("checkForSuBinary", checkForSuBinary);
            map.put("checkForDangerousProps", checkForDangerousProps);
            map.put("checkForRWPaths", checkForRWPaths);
            map.put("detectTestKeys", detectTestKeys);
            map.put("checkSuExists", checkSuExists);
            map.put("checkForRootNative", checkForRootNative);
            map.put("checkForMagiskBinary", checkForMagiskBinary);

            return map;
        }
    }

  public boolean isHamaarDetectXuniles() {
    try {
      @SuppressLint("PrivateApi") Class<?> c = Class.forName(HamaarTootinPinHeadsUtils.tootinPrivateKey());
      Method hamaarMethod = c.getMethod(HamaarTootinPinHeadsUtils.tootinPrivateMethod(), String.class);
      String hamaarSuspect = (String) hamaarMethod.invoke(c, HamaarTootinPinHeadsUtils.tootinPrivateSus());

      return HamaarTootinPinHeadsUtils.tootinPrivateReturn().equals(hamaarSuspect);
    } catch (Exception ignored) {
    }
    return false;
  }
}
