package com.reactlibrary;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;

import java.util.HashMap;
import java.util.Map;

public class RNDemoLibModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final int[] mMeasureBuffer = new int[4];

    private static final String E_ERROR = "E_ERROR";

    public RNDemoLibModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNDemoLib";
    }

    @Override
    public @Nullable
    Map<String, Object> getConstants() {
        HashMap<String, Object> constants = new HashMap<String, Object>();
        constants.put("isEmulator", this.isEmulator());
        constants.put("SHORT", Toast.LENGTH_SHORT);
        constants.put("LONG", Toast.LENGTH_LONG);
        return constants;
    }

    private Boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void add(
            int number1,
            int number2,
            Callback errorCallback,
            Callback successCallback) {
        try {
            int answer = number1 + number2;
            successCallback.invoke(answer);
        } catch (NumberFormatException e) {
            errorCallback.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void subStract(
            int number1,
            int number2,
            Promise promise) {
        try {
            int answer = number1 - number2;
            promise.resolve(answer);
        } catch (NumberFormatException e) {
            promise.reject(E_ERROR, e);
        }
    }


}