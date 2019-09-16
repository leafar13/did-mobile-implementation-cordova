//
//  DIDPluginManager.h
//  Exceptions
//
//  Created by Juan Pablo Combariza on 5/29/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>
#import "DetectIDCordovaPlugin.h"

@interface DIDPlugOtpApi: CDVPlugin

- (void)updateTokenTimeStepValue:(CDVInvokedUrlCommand*)command;

- (void)getTokenValue:(CDVInvokedUrlCommand*)command;

@end
