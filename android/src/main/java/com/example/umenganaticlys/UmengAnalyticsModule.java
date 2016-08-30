package com.example.umenganaticlys;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.umeng.analytics.MobclickAgent;

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
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.startWithConfigure(
                new MobclickAgent.UMAnalyticsConfig(getCurrentActivity(), key, channelId, MobclickAgent.EScenarioType.E_UM_NORMAL));

    }
    @ReactMethod
    public void beginLogPageView(String pageName) {
        MobclickAgent.onPageStart(pageName);
    }
    @ReactMethod
    public void endLogPageView(String pageName) {
        MobclickAgent.onPageEnd(pageName);
    }
    @ReactMethod
    public void event(String event) {
        MobclickAgent.onEvent(getCurrentActivity(),event);
    }
    @ReactMethod
    public void setEncryptEnabled(Boolean value) {
        MobclickAgent.enableEncrypt(value);
    }
    @ReactMethod
    public void setDebugMode(Boolean value) {
        MobclickAgent.setDebugMode(value);
    }

}