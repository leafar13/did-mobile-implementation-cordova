//
//  DIDPluginTransactionServerResponseListener.h
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import "DIDPluginPushAlertOpenListener.h"
#import "DIDPlugHelper.h"

@implementation DIDPluginPushAlertOpenListener
{
	__block CDVInvokedUrlCommand *commandPluginPushAlertOpenListener;
    CDVPlugin *pushPlugin;
}

+ (id)sharedInstance{
    static DIDPluginPushAlertOpenListener *pluginAlertOpen = nil;
    @synchronized(self){
        if (pluginAlertOpen == nil) {
            pluginAlertOpen = [[self alloc]init];
        }
        [[[DetectID sdk] PUSH_API] setPushAlertOpenDelegate: pluginAlertOpen];
    }
    return pluginAlertOpen;
}

-(void)setCommand:(CDVInvokedUrlCommand *)command withPlugin: (CDVPlugin*)plugin{
    commandPluginPushAlertOpenListener = command;
    pushPlugin = plugin;
    
    if(_transactionInfo)
    {
        [self onPushAlertOpen:_transactionInfo];
        _transactionInfo = nil;
    }
}

- (void)onPushAlertOpen:(TransactionInfo *)transaction {
	CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary: [DIDPlugHelper convertTransactionInfoToDictionary:transaction] ];
    [pluginResult setKeepCallbackAsBool:YES];
    [pushPlugin.commandDelegate sendPluginResult:pluginResult callbackId:commandPluginPushAlertOpenListener.callbackId];
}

@end
