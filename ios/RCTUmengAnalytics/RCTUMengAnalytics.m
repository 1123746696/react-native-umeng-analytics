//
//  RCTUmengAnalytics.m
//  RCTUmengAnalytics
//
//  Created by user on 16/8/17.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RCTUmengAnalytics.h"
#import <UMCommon/UMCommon.h>
#import <UMAnalytics/MobClick.h>
#import "RNUMConfigure.h"
@implementation RCTUmengAnalytics
RCT_EXPORT_MODULE();
RCT_EXPORT_METHOD(setAppkeyAndChannelId:(NSString *)key channelId:(NSString *)channelId){
  NSString *deviceID = [UMConfigure deviceIDForIntegration];
  NSData* jsonData = [NSJSONSerialization dataWithJSONObject:@{@"oid" : deviceID}
                                                     options:NSJSONWritingPrettyPrinted
                                                       error:nil];
  
  NSLog(@"%@", [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding]);
  
  
  [RNUMConfigure initWithAppkey:key channel:channelId];
}
RCT_EXPORT_METHOD(beginLogPageView:(NSString *)pageName){
  if (pageName == nil || [pageName isKindOfClass:[NSNull class]]) {
    return;
  }
  [MobClick beginLogPageView:pageName];
}
RCT_EXPORT_METHOD(endLogPageView:(NSString *)pageName){
  if (pageName == nil || [pageName isKindOfClass:[NSNull class]]) {
    return;
  }
  [MobClick endLogPageView:pageName];
}
RCT_EXPORT_METHOD(event:(NSString *)event){
  if (event == nil || [event isKindOfClass:[NSNull class]]) {
    return;
  }
  [MobClick event:event];
}
RCT_EXPORT_METHOD(setDebugMode:(BOOL)value){
  [UMConfigure setLogEnabled:value];
}
RCT_EXPORT_METHOD(onProfileSignIn:(NSString *)userID){
  if (userID == nil || [userID isKindOfClass:[NSNull class]]) {
    return;
  }
  [MobClick profileSignInWithPUID:userID];
}
RCT_EXPORT_METHOD(onProfileSignInWithProvider:(NSString *)provider userID:(NSString *)userID){
  if (userID == nil || [userID isKindOfClass:[NSNull class]]) {
    return;
  }
  if (provider == nil || [provider isKindOfClass:[NSNull class]]) {
    return;
  }
  [MobClick profileSignInWithPUID:userID provider:provider];
}
RCT_EXPORT_METHOD(onProfileSignOff){
  [MobClick profileSignOff];
}
@end
