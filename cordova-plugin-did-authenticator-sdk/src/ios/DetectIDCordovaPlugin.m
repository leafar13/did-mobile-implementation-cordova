/*
 Copyright 2013-2014 appPlant UG
 
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at
 
 http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

#import "DetectIDCordovaPlugin.h"
#import <Availability.h>
#import "DIDPlugRegexHelper.h"
#import "DIDPlugExceptionsHelper.h"
#import "DIDPlugServerHelper.h"
#import "DIDPlugRegistrationApi.h"


@interface DetectIDCordovaPlugin ()

// Retrieves the application state
@property (readonly, getter=applicationState) NSString* applicationState;
// All events will be queued until deviceready has been fired
@property (readwrite, assign) BOOL deviceready;
// Event queue
@property (readonly, nonatomic, retain) NSMutableArray* eventQueue;

@end

@implementation DetectIDCordovaPlugin
{
    __block DIDPlugRegistrationApi* pluginManager;
    __block CDVInvokedUrlCommand *commandDeviceRegistrationServerResponseListener;
}

@synthesize deviceready, eventQueue;

#pragma mark -
#pragma mark Interface

/**
 * Execute all queued events. TODO: PREGUNTAR ESTO QUE HACE
 */
- (void) deviceready:(CDVInvokedUrlCommand*)command
{
    deviceready = YES;
    
    for (NSString* js in eventQueue) {
        [self.commandDelegate evalJs:js];
    }
    
    [eventQueue removeAllObjects];
}

- (void) initDIDServerWithParams:(CDVInvokedUrlCommand*)command{
    __block CDVInvokedUrlCommand *commandBlock = command;
    pluginManager = [DIDPlugRegistrationApi new];
    [pluginManager initDIDServerWithParamsManager:commandBlock withPlugin:self];
}

- (void) displayDeviceRegistrationDialog:(CDVInvokedUrlCommand*)command {
    [pluginManager displayDeviceRegistrationDialogManager:command withPlugin:self];
}

- (void) deviceRegistrationByCode:(CDVInvokedUrlCommand*)command{
    __block CDVInvokedUrlCommand *commandBlock = command;
    [self.commandDelegate runInBackground:^{
        [pluginManager deviceRegistrationByCodeManager:commandBlock withPlugin:self];
    }];
}

- (void) deviceRegistrationByQRCode:(CDVInvokedUrlCommand*)command {
    __block CDVInvokedUrlCommand *commandBlock = command;
    [pluginManager deviceRegistrationByQRCodeManager:commandBlock withPlugin:self];
}

- (void) setDeviceRegistrationServerResponseListener:(CDVInvokedUrlCommand*)command {
    [pluginManager setDeviceRegistrationServerResponseListenerManager:command withPlugin:self];
}

-(void)onRegistrationResponse:(NSString*) result {
    commandDeviceRegistrationServerResponseListener = pluginManager.commandDeviceRegistrationServerResponseListener;
    [self.commandDelegate sendPluginResult:[pluginManager onRegistrationResponseManager:result withCommand:commandDeviceRegistrationServerResponseListener] callbackId:commandDeviceRegistrationServerResponseListener.callbackId];
}

- (void) setRegistrationViewProperties:(CDVInvokedUrlCommand*)command{
    [pluginManager setRegistrationViewPropertiesManager:command withPlugin:self];
}

@end