//
//  DIDPluginTransactionServerResponseListener.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPluginTransactionServerResponseListener.h"

@implementation DIDPluginTransactionServerResponseListener
{
    __block CDVInvokedUrlCommand *commandPluginTransactionServerResponseListener;
    CDVPlugin *pushPlugin;
}

- (instancetype)initWithCommand : (CDVInvokedUrlCommand *) command withPlugin:(CDVPlugin*) plugin
{
    self = [super init];
    if (self) {
        self.myPushListenerCallbackId = command.callbackId;
        commandPluginTransactionServerResponseListener = command;
        pushPlugin = plugin;
        
        [[[DetectID sdk] PUSH_API] setPushTransactionServerResponseDelegate: self];
    }
    return self;
}

- (void)onPushTransactionServerResponse:(NSString *)result {
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString: result];
    [pushPlugin.commandDelegate sendPluginResult:pluginResult callbackId: _myPushListenerCallbackId];
}

@end
