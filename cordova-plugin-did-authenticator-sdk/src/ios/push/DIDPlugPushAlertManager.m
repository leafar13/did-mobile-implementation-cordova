//
//  DIDPlugPushTransaction.m
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPlugPushApi.h"
#import "DIDPlugConstantsHelper.h"
#import "DIDPlugPushAlertManager.h"
#import "DIDPlugHelper.h"

@implementation DIDPlugPushAlertManager
{
}

- (instancetype)init {
    return [super init];
}

-(void)setPushAlertViewProperties: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi{
    __block CDVPluginResult* pluginResult;
    __block CDVInvokedUrlCommand* commandProperties = command;

    PushAlertViewProperties *pushAlertVP = [self convertJsonToPushAlertViewProperties: [commandProperties.arguments objectAtIndex:0]];
        
    [[[DetectID sdk] PUSH_API] setPushAlertViewProperties: pushAlertVP];
    
    pluginResult = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsBool: TRUE];
    [pluginPushApi.commandDelegate sendPluginResult: pluginResult callbackId:commandProperties.callbackId];
}

- (void)approvePushAlertAction: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi{
    
    [[[DetectID sdk] PUSH_API] approvePushAlertAction:[DIDPlugHelper convertJsonToPushTransactionInfo:[command.arguments objectAtIndex:0]]];
}

-(PushAlertViewProperties*)convertJsonToPushAlertViewProperties:(NSDictionary*)json{
    PushAlertViewProperties* pushAlertVP = [[PushAlertViewProperties alloc]init];
    pushAlertVP.APPROVE = [json valueForKeyPath: APPROVE_PROPERTIES] ? : nil;
        
    return pushAlertVP;
}

@end
