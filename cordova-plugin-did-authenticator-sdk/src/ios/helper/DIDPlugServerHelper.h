//
//  DIDServerURL.h
//  Exceptions
//
//  Created by Juan Pablo Combariza on 5/29/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface DIDPlugServerHelper : NSObject
+ (DIDPlugServerHelper *)getInstance:(NSString *)serverURL;
- (NSString *)getServerURL;
@end
