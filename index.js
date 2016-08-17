/**
 * Created by user on 16/8/17.
 */
import React, {
    Platform,

} from 'react-native';
var UmengAnalyticsModel = require('react-native').NativeModules.UmengAnalytics;
export default class UMengAnalytics{
    static setAppkeyAndChannelId(key:String,channelId:String) {
        UmengAnalyticsModel.setAppkeyAndChannelId(key,channelId);
    }
    static beginLogPageView(pageName:String) {
        UmengAnalyticsModel.beginLogPageView(pageName);
    }
    static endLogPageView(pageName:String) {
        UmengAnalyticsModel.endLogPageView(pageName);
    }
    static setEncryptEnabled(value:Boolean) {
        UmengAnalyticsModel.setEncryptEnabled(value);
    }

    static setBackgroundTaskEnabled(value:Boolean) {
        if(Platform.OS==='ios'){
            UmengAnalyticsModel.setBackgroundTaskEnabled(value);
        }
    }
    static event(event:String) {
        UmengAnalyticsModel.event(event);
    }
};