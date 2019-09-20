//
//  DIDPluginManager.m
//  Exceptions
//
//  Created by Juan Pablo Combariza on 5/29/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPlugOtpApi.h"
#import "DIDPlugHelper.h"
#import "DIDPlugExceptionsHelper.h"
#import "DIDPlugRegistrationApi.h"
#import "DIDPlugConstantsHelper.h"

@implementation DIDPlugOtpApi
{
    __block DIDPlugOtpApi* pluginManager;
}

- (instancetype)init {
    return [super init];
}

- (void)updateTokenTimeStepValue: (CDVInvokedUrlCommand*)command {
    __block DIDPlugOtpApi* pluginBlock = self;
    
    @try {
        __block CDVPluginResult* pluginResult;
        __block CDVInvokedUrlCommand* commandBlock = command;
        
        Account *account = [DIDPlugHelper convertJsonToAccount: [commandBlock.arguments objectAtIndex:0]];
        
        [[[DetectID sdk] OTP_API] updateTokenTimeStepValue: account];

        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:TRUE];
        [pluginBlock.commandDelegate sendPluginResult:pluginResult callbackId:commandBlock.callbackId];
    }
    @catch (NSException *e)
    {
        CDVPluginResult *pluginResultFail = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:[DIDPlugExceptionsHelper pluginExceptionHandler:e]];
        [pluginBlock.commandDelegate sendPluginResult:pluginResultFail callbackId:command.callbackId];
    }
}

- (void)getTokenValue: (CDVInvokedUrlCommand*)command {
    __block DIDPlugOtpApi* pluginBlock = self;
    
    @try {
        __block CDVPluginResult* pluginResult;
        __block CDVInvokedUrlCommand* commandBlock = command;
        
        Account *account = [DIDPlugHelper convertJsonToAccount: [commandBlock.arguments objectAtIndex:0]];
        
        NSString *token = [[[DetectID sdk] OTP_API] getTokenValue: account];
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString: token];
        [pluginBlock.commandDelegate sendPluginResult:pluginResult callbackId:commandBlock.callbackId];
    }
    @catch (NSException *e)
    {
        CDVPluginResult *pluginResultFail = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:[DIDPlugExceptionsHelper pluginExceptionHandler:e]];
        [pluginBlock.commandDelegate sendPluginResult:pluginResultFail callbackId:command.callbackId];
    }
}

@end
