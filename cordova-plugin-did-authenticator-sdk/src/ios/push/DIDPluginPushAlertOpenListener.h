//
//  DIDPluginTransactionServerResponseListener.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>

@interface DIDPluginPushAlertOpenListener : NSObject <PushAlertOpenDelegate>

@property(nonatomic,strong) TransactionInfo* transactionInfo;

+ (id)sharedInstance;
- (void)setCommand:(CDVInvokedUrlCommand *)command withPlugin: (CDVPlugin*)plugin;

@end
