//
//  DIDPluginManager.m
//  Exceptions
//
//  Created by Juan Pablo Combariza on 5/29/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPlugAccountsApi.h"
#import "DIDPlugServerHelper.h"
#import "DIDPlugHelper.h"
#import "DIDPlugExceptionsHelper.h"
#import "DIDPlugRegistrationApi.h"
#import "DIDPlugConstantsHelper.h"

@implementation DIDPlugAccountsApi
{
    __block DIDPlugAccountsApi* pluginManager;
}

- (instancetype)init {
    return [super init];
}

- (void)getAccounts: (CDVInvokedUrlCommand*)command {
    __block DIDPlugAccountsApi* pluginBlock = self;
    
    @try {
        __block CDVPluginResult* pluginResult;
        __block CDVInvokedUrlCommand* commandBlock = command;
        
        NSArray *accounts = [[DetectID sdk] getAccounts];

        NSMutableArray *jsonArray = [NSMutableArray new];
        
        for (Account *account in accounts) {
             [jsonArray addObject: [DIDPlugHelper convertAccountToJson:account]];
        }

        pluginResult = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsArray: jsonArray.copy];
        [pluginBlock.commandDelegate sendPluginResult:pluginResult callbackId:commandBlock.callbackId];
    }
    @catch (NSException *e)
    {
        CDVPluginResult *pluginResultFail = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:[DIDPlugExceptionsHelper pluginExceptionHandler:e]];
        [pluginBlock.commandDelegate sendPluginResult:pluginResultFail callbackId:command.callbackId];
    }
}

@end
