//
//  DIDPlugPushTransaction.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>

@interface DIDPlugPushAlertManager : NSObject

- (void)setPushAlertViewProperties: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi;

- (void)approvePushAlertAction: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi;
@end