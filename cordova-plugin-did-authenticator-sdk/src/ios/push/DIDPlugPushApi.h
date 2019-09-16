//
//  DIDPlugPushTransaction.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>

@interface DIDPlugPushApi : CDVPlugin

- (void) setPushTransactionViewProperties:(CDVInvokedUrlCommand*)command;
- (void) setPushAlertViewProperties:(CDVInvokedUrlCommand*)command;
- (void) setPushTransactionServerResponseListener:(CDVInvokedUrlCommand*)command;
- (void) setPushTransactionOpenListener: (CDVInvokedUrlCommand*)command;
- (void) setPushTransactionActionListener: (CDVInvokedUrlCommand*)command;
- (void) setPushAlertOpenListener: (CDVInvokedUrlCommand*)command;
@end