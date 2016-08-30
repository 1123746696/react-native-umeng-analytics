# react-native-umeng-analytics
##安装
```
npm install react-native-umeng-analytics
rnpm link react-native-umeng-analytics
```

##集成到iOS
1.请在你的工程目录结构中，添加友盟统计框架，在选项TARGETS--> Build Phases-->Link Binary With Libraries-->Add Other，选择文件node_modules/react-native-umeng-analytics/ios/umsdk_IOS_analyics_idfa_v4.0.4/UMMobClick.framework<br>
2.在工程目录结构中,添加友盟框架引用,在TARGETS-->Build Settings-->Framework Search Paths, 添加:$(SRCROOT)/../node_modules/react-native-umeng-analytics/ios/umsdk_IOS_analyics_idfa_v4.0.4
##集成到android


####添加配置
在项目工程的`AndroidManifest.xml`中的<Application>标签下添加:

```
<meta-data
android:name="UMENG_APPKEY"
android:value="" />
<meta-data
android:name="UMENG_CHANNEL"
android:value="" />
```


##API

| API | Note |    
|---|---|
| `setAppkeyAndChannelId` | 设置UmengKey和channelId |
| `beginLogPageView` | 进入页面的时候调用的方法 |
| `endLogPageView` | 退出页面的时候调用的方法 |
| `event` | 事件采集 |
| `setEncryptEnabled` | 设置是否加密 |
| `setBackgroundTaskEnabled` | 后台模式（IOS） |
| `setDebugMode` | 设置调试模式 |



##Usage

```
import UmengAnalytics from 'react-native-umeng-analytics'

//设置UmengKey和channelId
UmengAnalytics.setAppkeyAndChannelId(umengKey,umengChannel);

//页面采集
UmengAnalytics.beginLogPageView(currentPage);
UmengAnalytics.endLogPageView(currentPage);

//事件采集
UmengAnalytics.event(event)

//设置加密
UmengAnalytics.setEncryptEnabled(true)

//后台模式
UmengAnalytics.setBackgroundTaskEnabled(true)

//调试模式
UmengAnalytics.setDebugMode(true)

```

