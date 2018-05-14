package com.example.umenganaticlys;


import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.util.Map;

/**
 * Created by user on 16/6/15.
 */
public class UmengAnalyticsModule extends ReactContextBaseJavaModule {

    public UmengAnalyticsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() {
        return "UmengAnalytics";
    }

    /***
     * 设置umeng的Key和渠道号
     * @param key     umeng的key
     * @param channelId  渠道号
     */
    @ReactMethod
    public void setAppkeyAndChannelId(String key,String channelId) {
//        MobclickAgent.openActivityDurationTrack(false);
//        UMConfigure.init(getCurrentActivity(), UMConfigure.DEVICE_TYPE_PHONE, key);
        UMConfigure.init(getCurrentActivity(), key, channelId, UMConfigure.DEVICE_TYPE_PHONE, null);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.openActivityDurationTrack(false);
    }
    @ReactMethod
    public void beginLogPageView(String pageName) {
        Log.i("beginLogPageView",pageName);
        MobclickAgent.onPageStart(pageName);
    }
    @ReactMethod
    public void endLogPageView(String pageName) {
        Log.i("endLogPageView",pageName);
        MobclickAgent.onPageEnd(pageName);
    }
    @ReactMethod
    public void event(String event) {
        MobclickAgent.onEvent(getCurrentActivity(),event);
    }
    @ReactMethod
    public void eventWithAttributes(String event,ReadableMap attributes) {
        ReadableNativeMap map2 = (ReadableNativeMap)attributes;
        Map useMap = map2.toHashMap();
        MobclickAgent.onEvent(getCurrentActivity(),event,useMap);
    }
    @ReactMethod
    public void setEncryptEnabled(Boolean value) {
        UMConfigure.setEncryptEnabled(value);
    }
    @ReactMethod
    public void setDebugMode(Boolean value) {
        UMConfigure.setLogEnabled(value);
    }
    @ReactMethod
    public void onProfileSignIn(String userID) {
        MobclickAgent.onProfileSignIn(userID);
    }
    @ReactMethod
    public void onProfileSignInWithProvider(String Provider,String userID) {
        MobclickAgent.onProfileSignIn(Provider,userID);
    }
    @ReactMethod
    public void onProfileSignOff() {
        MobclickAgent.onProfileSignOff();
    }

}