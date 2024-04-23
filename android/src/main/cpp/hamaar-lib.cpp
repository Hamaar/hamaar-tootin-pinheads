//
// Created by Hafis Mandala Arummi on 19/02/24.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_hamaartootinpinheads_utils_HamaarTootinPinHeadsUtils_tootinPrivateKey(JNIEnv *env, jobject object) {
    std::string hamaar_os_key = "android.os.SystemProperties";
    return env->NewStringUTF(hamaar_os_key.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_hamaartootinpinheads_utils_HamaarTootinPinHeadsUtils_tootinPrivateMethod(JNIEnv *env, jobject object) {
    std::string hamaar_method_key = "get";
    return env->NewStringUTF(hamaar_method_key.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_hamaartootinpinheads_utils_HamaarTootinPinHeadsUtils_tootinPrivateSus(JNIEnv *env, jobject object) {
    std::string hamaar_sus_key = "ro.build.selinux";
    return env->NewStringUTF(hamaar_sus_key.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_hamaartootinpinheads_utils_HamaarTootinPinHeadsUtils_tootinPrivateReturn(JNIEnv *env, jobject object) {
    std::string hamaar_return_key = "1";
    return env->NewStringUTF(hamaar_return_key.c_str());
}
