# react-native-umeng-analytics
##安装
```
npm install react-native-umeng-analytics
rnpm link react-native-umeng-analytics
```

##集成到iOS


##集成到android


####3、添加配置
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
| `setBackgroundTaskEnabled` | 设置是否可以在后台运行 |



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

//后台运行
UmengAnalytics.setBackgroundTaskEnabled(true)

```

