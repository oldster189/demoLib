package com.reactlibrary;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.HashMap;
import java.util.Map;

public class RNDemoLibModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNDemoLibModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNDemoLib";
    }
 
   @Override
    public @Nullable Map<String, Object> getConstants() {
    HashMap<String, Object> constants = new HashMap<String, Object>();
            constants.put("SHORT", Toast.LENGTH_SHORT);
            constants.put("LONG", Toast.LENGTH_LONG);
    return constants;
  }

}