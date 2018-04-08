# react-native-umeng-analytics
##安装
```
npm install react-native-umeng-analytics
rnpm link react-native-umeng-analytics
```

##集成到iOS<br>
1.请在你的工程目录结构中，添加友盟统计框架，在选项TARGETS--> Build Phases-->Link Binary With Libraries-->Add Other，
选择文件node_modules/react-native-umeng-analytics/ios/analytics_ios_5.4.1/UMAnalytics.framework<br>
选择文件node_modules/react-native-umeng-analytics/ios/common_ios_1.4.2/normal/UMCommon.framework<br>

2.在工程目录结构中,添加友盟框架引用,在TARGETS-->Build Settings-->Framework Search Paths, 添加:<br>
$(SRCROOT)/../node_modules/react-native-umeng-analytics/ios/analytics_ios_5.4.1<br>
$(SRCROOT)/../node_modules/react-native-umeng-analytics/ios/common_ios_1.4.2/normal<br>

3.添加依赖库：CoreTelephony.framework，libz.tbd，libsqlite.tbd，SystemConfiguration.framework

在`AppDelegate.m`中添加
```
#import "RNUMConfigure.h"
- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  [RNUMConfigure initWithAppkey:key channel:channelId];
  return YES;
}
```


详情参考：[友盟IOSSDK集成指南](https://developer.umeng.com/docs/66632/detail/66898)<br>

##集成到android


####添加配置
在`AndroidManifest.xml`中添加权限
```
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    <uses-permission android:name="android.permission.INTERNET"/>
```

在`MainApplication`中添加
```
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, key, channelId, UMConfigure.DEVICE_TYPE_PHONE, null);
        MobclickAgent.openActivityDurationTrack(false);
    }
```

在`MainActivity.java`中添加
```
    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);

    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
```

详情参考：[友盟AndroidSDK集成指南](https://developer.umeng.com/docs/66632/detail/66889)<br>

##API

| API | Note |    
|---|---|
| `beginLogPageView` | 进入页面的时候调用的方法 |
| `endLogPageView` | 退出页面的时候调用的方法 |
| `event` | 事件采集 |
| `setDebugMode` | 设置调试模式 |
| `onProfileSignIn` | 用户登录 |
| `onProfileSignOff` | 用户注销 |



##Usage

```
import UmengAnalytics from 'react-native-umeng-analytics'

//页面采集
UmengAnalytics.beginLogPageView(currentPage);
UmengAnalytics.endLogPageView(currentPage);

//事件采集
UmengAnalytics.event(event)

//调试模式
UmengAnalytics.setDebugMode(true)

//用户登录采集
UmengAnalytics.onProfileSignIn(userId)

//用户注销
UmengAnalytics.onProfileSignOff()

```

