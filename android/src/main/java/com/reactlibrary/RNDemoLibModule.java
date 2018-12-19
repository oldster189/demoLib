package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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
  public @Nullable
  Map<String, Object> getConstants() {
    HashMap<String, Object> constants = new HashMap<String, Object>();
            constants.put("SHORT", Toast.LENGTH_SHORT);
            constants.put("LONG", Toast.LENGTH_LONG);
    return constants;
  }

}