//
//  DIDPluginTransactionServerResponseListener.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPluginTransactionOpenListener.h"
#import "DIDPlugHelper.h"


@implementation DIDPluginTransactionOpenListener
{
	__block CDVInvokedUrlCommand *commandPluginTransactionOpenListener;
    CDVPlugin *pushPlugin;
}

+ (id)sharedInstance{
    static DIDPluginTransactionOpenListener *pluginTransactionOpen = nil;
    @synchronized(self){
        if (pluginTransactionOpen == nil) {
            pluginTransactionOpen = [[self alloc]init];
        }
        [[[DetectID sdk] PUSH_API] setPushTransactionOpenDelegate: pluginTransactionOpen];
    }
    return pluginTransactionOpen;
}

-(void)setCommand:(CDVInvokedUrlCommand *)command withPlugin: (CDVPlugin*)plugin{
    commandPluginTransactionOpenListener = command;
    pushPlugin = plugin;
    
    if(_transactionInfo)
    {
        [self onPushTransactionOpen:_transactionInfo];
        _transactionInfo = nil;
    }
}

- (void)onPushTransactionOpen:(TransactionInfo *)transaction {
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary: [DIDPlugHelper convertTransactionInfoToDictionary:transaction] ];
    [pluginResult setKeepCallbackAsBool:YES];
    [pushPlugin.commandDelegate sendPluginResult:pluginResult callbackId:commandPluginTransactionOpenListener.callbackId];
}

@end

