//
//  DIDPlugRegexHelper.h
//  Exceptions
//
//  Created by Juan Pablo Combariza on 5/29/18.
//  Copyright © 2018 Easysol. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface DIDPlugRegexHelper : NSObject
+ (BOOL)validateStringFormat:(NSString *)string withPattern:(NSString *)pattern;
@end
