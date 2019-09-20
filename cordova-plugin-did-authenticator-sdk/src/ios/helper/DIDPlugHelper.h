//
//  DIDServerURL.h
//  Exceptions
//
//  Created by Katerin Lucia Vasquez on 26/12/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>
#import <objc/runtime.h>

@interface DIDPlugHelper : NSObject

+ (NSDictionary *)convertTransactionInfoToDictionary:(TransactionInfo*) transactionInfo;
+ (NSDictionary *)convertObjectToDictionary:(id)obj;
+ (PushTransactionViewProperties*)convertJsonToPushTransactionViewProperties:(NSDictionary*)json;
+ (TransactionInfo*)convertJsonToPushTransactionInfo:(NSDictionary*)json;
+ (Account*)convertJsonToAccount:(NSDictionary*)json;
+ (NSDictionary *)convertAccountToJson:(Account *)account;
+ (Gestures*)convertJsonToGestures:(NSDictionary*)json;
+ (Channel*)convertJsonToChannel:(NSDictionary*)json;
@end
