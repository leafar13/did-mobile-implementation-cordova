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
#import "DIDPlugServerHelper.h"
#import "DetectIDCordovaPlugin.h"

@interface DIDPlugRegistrationApi : CDVPlugin <DeviceRegistrationServerResponseDelegate>

@property (nonatomic,strong) __block CDVInvokedUrlCommand *commandDeviceRegistrationServerResponseListener;

- (void) initDIDServerWithParams:(CDVInvokedUrlCommand*)command;

- (void) displayDeviceRegistrationDialog:(CDVInvokedUrlCommand*)command;

- (void) deviceRegistrationByCode:(CDVInvokedUrlCommand*)command;

- (void) deviceRegistrationByQRCode:(CDVInvokedUrlCommand*)command;

- (void) setDeviceRegistrationServerResponseListener:(CDVInvokedUrlCommand*)command;

- (void) setRegistrationViewProperties:(CDVInvokedUrlCommand*)command;

- (void)initDIDServerWithParamsManager:(CDVInvokedUrlCommand*)command withPlugin:(DIDPlugRegistrationApi *)plugin;

- (void) displayDeviceRegistrationDialogManager:(CDVInvokedUrlCommand*)command withPlugin:(DIDPlugRegistrationApi *)plugin;

- (void) deviceRegistrationByCodeManager:(CDVInvokedUrlCommand*)command withPlugin:(DIDPlugRegistrationApi *)plugin;

- (void)deviceRegistrationByQRCodeManager:(CDVInvokedUrlCommand*)command withPlugin:(DIDPlugRegistrationApi *)plugin;

- (void) setDeviceRegistrationServerResponseListenerManager:(CDVInvokedUrlCommand*)command withPlugin:(DIDPlugRegistrationApi *)plugin;

- (CDVPluginResult*)onRegistrationResponseManager:(NSString *)result withCommand:(CDVInvokedUrlCommand *)commandDeviceRegistrationServerResponseListener;

- (void) setRegistrationViewPropertiesManager:(CDVInvokedUrlCommand*)command withPlugin:(DIDPlugRegistrationApi *)plugin;

@end