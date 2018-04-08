/**
 * Created by user on 16/8/17.
 */
import React, {
    Platform,

} from 'react-native';
var UmengAnalyticsModel = require('react-native').NativeModules.UmengAnalytics;
export default class UMengAnalytics{
    static previousPage = ''
    static beginLogPageView(pageName:String) {
        if(!!UMengAnalytics.previousPage){
            UmengAnalyticsModel.endLogPageView(UMengAnalytics.previousPage);
        }
        UmengAnalyticsModel.beginLogPageView(pageName);
        UMengAnalytics.previousPage = pageName
    }
    static endLogPageView(pageName:String) {
        UmengAnalyticsModel.endLogPageView(pageName);
    }
    static event(event:String) {
        UmengAnalyticsModel.event(event);
    }
    static setDebugMode(value:Boolean) {
        UmengAnalyticsModel.setDebugMode(value);
    }
    static onProfileSignIn(userID) {
        UmengAnalyticsModel.onProfileSignIn(userID);
    }
    static onProfileSignOff() {
        UmengAnalyticsModel.onProfileSignOff();
    }
};