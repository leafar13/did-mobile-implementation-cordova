//
//  DIDPlugPushTransaction.m
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPlugPushApi.h"
#import "DIDPlugConstantsHelper.h"
#import "DIDPlugPushTransactionManager.h"
#import "DIDPlugHelper.h"

@implementation DIDPlugPushTransactionManager{
}

- (instancetype)init {
    return [super init];
}

-(void)setPushTransactionViewProperties: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi{
    
    __block CDVInvokedUrlCommand* commandProperties = command;
    
    NSError *jsonError;
    NSData *objectData = [[commandProperties.arguments objectAtIndex:0] dataUsingEncoding:NSUTF8StringEncoding];
    NSDictionary *json = [NSJSONSerialization JSONObjectWithData:objectData options:NSJSONReadingMutableContainers error:&jsonError];
    
    [[[DetectID sdk] PUSH_API] setPushTransactionViewProperties:[DIDPlugHelper convertJsonToPushTransactionViewProperties:json]];
}

- (void)confirmPushTransactionAction: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi{
    
    [[[DetectID sdk] PUSH_API] confirmPushTransactionAction : [DIDPlugHelper convertJsonToPushTransactionInfo:[command.arguments objectAtIndex:0]]];
}

- (void)declinePushTransactionAction: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi{
    
    [[[DetectID sdk] PUSH_API] declinePushTransactionAction: [DIDPlugHelper convertJsonToPushTransactionInfo:[command.arguments objectAtIndex:0]]];
}

- (void)setPushAuthenticationResponseAdditionalInfo: (CDVInvokedUrlCommand*)command withPlugin:(DIDPlugPushApi*) pluginPushApi{
    
    [[[DetectID sdk] PUSH_API] setPushAuthenticationResponseAdditionalInfo:[command.arguments objectAtIndex:0]];
}

@end
