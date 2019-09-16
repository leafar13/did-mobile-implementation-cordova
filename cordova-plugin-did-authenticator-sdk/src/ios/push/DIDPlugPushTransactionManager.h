//
//  DIDPlugPushTransaction.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>

@interface DIDPlugPushTransactionManager : NSObject

- (void)setPushTransactionViewProperties: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi;

- (void)confirmPushTransactionAction: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi;

- (void)declinePushTransactionAction: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi;

- (void)setPushAuthenticationResponseAdditionalInfo: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi;

@end