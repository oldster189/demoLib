package com.reactlibrary;

import android.support.annotation.Nullable;
import android.widget.Toast;

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
        constants.put("SHORT", Toast.LENGTH_SHORT);
        constants.put("LONG", Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void measureLayout(
            int tag,
            int ancestorTag,
            Callback errorCallback,
            Callback successCallback) {
        try {
            measureLayout(tag, ancestorTag, mMeasureBuffer);
            float relativeX = PixelUtil.toDIPFromPixel(mMeasureBuffer[0]);
            float relativeY = PixelUtil.toDIPFromPixel(mMeasureBuffer[1]);
            float width = PixelUtil.toDIPFromPixel(mMeasureBuffer[2]);
            float height = PixelUtil.toDIPFromPixel(mMeasureBuffer[3]);
            successCallback.invoke(relativeX, relativeY, width, height);
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }


}