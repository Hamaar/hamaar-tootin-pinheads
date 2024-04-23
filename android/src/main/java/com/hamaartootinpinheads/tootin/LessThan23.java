package com.hamaartootinpinheads.tootin;

import java.io.File;

public class LessThan23 implements CheckApiVersion {
    @Override
    public boolean checkRooted() {
        return canExecuteCommand() || isSuperuserPresent();
    }

    private static boolean canExecuteCommand() {
        boolean executeResult;
        try {
            Process process = Runtime.getRuntime().exec("/system/xbin/which su");
            executeResult = process.waitFor() == 0;
        } catch (Exception e) {
            executeResult = false;
        }

        return executeResult;
    }

    private static boolean isSuperuserPresent() {
        String[] paths = {
                "/system/app/Superuser.apk",
                "/sbin/su",
                "/system/bin/su",
                "/system/xbin/su",
                "/data/local/xbin/su",
                "/data/local/bin/su",
                "/system/sd/xbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su"
        };

        for (String path : paths) {
            if (new File(path).exists()) {
                return true;
            }
        }

        return false;
    }
}
