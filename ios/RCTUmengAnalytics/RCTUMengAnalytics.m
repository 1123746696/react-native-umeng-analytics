//
//  RCTUmengAnalytics.m
//  RCTUmengAnalytics
//
//  Created by user on 16/8/17.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RCTUmengAnalytics.h"
#import "UMMobClick/MobClick.h"
@implementation RCTUmengAnalytics
RCT_EXPORT_MODULE();
RCT_EXPORT_METHOD(setAppkeyAndChannelId:(NSString *)key channelId:(NSString *)channelId){
  UMConfigInstance.appKey = key;
  UMConfigInstance.channelId = channelId;
  [MobClick startWithConfigure:UMConfigInstance];
}
RCT_EXPORT_METHOD(beginLogPageView:(NSString *)pageName){
  [MobClick beginLogPageView:pageName];
}
RCT_EXPORT_METHOD(endLogPageView:(NSString *)pageName){
  [MobClick endLogPageView:pageName];
}
RCT_EXPORT_METHOD(setEncryptEnabled:(BOOL)value){
  [MobClick setEncryptEnabled:value];
}
RCT_EXPORT_METHOD(setBackgroundTaskEnabled:(BOOL)value){
  [MobClick setBackgroundTaskEnabled:value];
}
RCT_EXPORT_METHOD(event:(NSString *)event){
  [MobClick event:event];
}
@end
