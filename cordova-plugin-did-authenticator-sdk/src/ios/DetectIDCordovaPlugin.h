//
//  DetectIDCordovaPlugin.h
//  didm_auth_sdk_iOS
//
//  Created by Juan Pablo Combariza on 16/05/18.
//  Copyright (c) 2014 Easy Solutions. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>

@interface DetectIDCordovaPlugin : CDVPlugin <DeviceRegistrationServerResponseDelegate>

// Executes all queued events
#pragma - mark - Common Api

- (void) initDIDServerWithParams:(CDVInvokedUrlCommand*)command;

- (void) displayDeviceRegistrationDialog:(CDVInvokedUrlCommand*)command;

- (void) deviceRegistrationByCode:(CDVInvokedUrlCommand*)command;

- (void) deviceRegistrationByQRCode:(CDVInvokedUrlCommand*)command;

- (void) setDeviceRegistrationServerResponseListener:(CDVInvokedUrlCommand*)command;

- (void) setRegistrationViewProperties:(CDVInvokedUrlCommand*)command;

@end