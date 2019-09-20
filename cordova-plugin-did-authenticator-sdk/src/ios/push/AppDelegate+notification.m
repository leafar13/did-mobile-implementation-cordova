//
//  AppDelegate+notification.m
//  pushtest
//
//  Created by Robert Easterday on 10/26/12.
//
//

#import "AppDelegate+notification.h"
#import <objc/runtime.h>
#import <didm_auth_sdk_iOS/didm_auth_sdk_iOS.h>
#import "DIDPluginTransactionOpenListener.h"
#import "DIDPluginPushAlertOpenListener.h"

#define SYSTEM_VERSION_GRATERTHAN_OR_EQUALTO(v)  ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] != NSOrderedAscending)

static char launchNotificationKey;

@implementation AppDelegate (notification)

- (id) getCommandInstance:(NSString*)className
{
    return [self.viewController getCommandInstance:className];
}

+ (void)load
{
    Method original, swizzled;
    
    original = class_getInstanceMethod(self, @selector(init));
    swizzled = class_getInstanceMethod(self, @selector(swizzled_init));
    method_exchangeImplementations(original, swizzled);
}

- (AppDelegate *)swizzled_init
{
    UIUserNotificationSettings *settings = [UIUserNotificationSettings settingsForTypes:(UIUserNotificationTypeBadge
                                                                                         | UIUserNotificationTypeAlert
                                                                                         | UIUserNotificationTypeSound)
                                                                             categories:[[DetectID sdk] getNotificationActionCategoriesForNotifications] ];
    [[UIApplication sharedApplication] registerUserNotificationSettings:settings];

    return [self swizzled_init];
}

- (void)createNotificationChecker:(NSNotification *)notification {
    
    if(SYSTEM_VERSION_GRATERTHAN_OR_EQUALTO(@"10.0")){
        UNUserNotificationCenter *center = [UNUserNotificationCenter currentNotificationCenter];
        center.delegate = self;
        [center requestAuthorizationWithOptions:(UNAuthorizationOptionSound | UNAuthorizationOptionAlert | UNAuthorizationOptionBadge) completionHandler:^(BOOL granted, NSError * _Nullable error){
            if(!error){
                dispatch_async(dispatch_get_main_queue(), ^{
                    [[UIApplication sharedApplication] registerForRemoteNotifications];
                });
                
            }
        }];
        [center setNotificationCategories:[[DetectID sdk] getUNNotificationActionCategoriesForNotifications]];
    }
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    
    [[[DetectID sdk] PUSH_API] setPushTransactionOpenDelegate:self];
    [[[DetectID sdk] PUSH_API] setPushAlertOpenDelegate:self];
    [[[DetectID sdk] PUSH_API] enablePushTransactionServerResponseAlerts:NO];
    
    return [super application:application didFinishLaunchingWithOptions:launchOptions];
}

- (void)application:(UIApplication *)application didRegisterUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings{
    [[UIApplication sharedApplication] registerForRemoteNotifications];
}

- (void)application:(UIApplication *)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken {
    
    [[DetectID sdk] receivePushServiceId:deviceToken];
}

- (void)application:(UIApplication*)application didFailToRegisterForRemoteNotificationsWithError:(NSError*)error{
    //error handling
}

- (void)application:(UIApplication *)application
didReceiveRemoteNotification:(NSDictionary *)userInfo
fetchCompletionHandler:(void (^)(UIBackgroundFetchResult result))completionHandler{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSLog(@"didReceiveRemoteNotification");
        
        [[[DetectID sdk] PUSH_API] enablePushTransactionDefaultDialog:false];
        [[[DetectID sdk] PUSH_API] enablePushAlertDefaultDialog:false];
        
        [[DetectID sdk]subscribePayload:userInfo];
    });
}

- (void)application:(UIApplication *)application handleActionWithIdentifier:(NSString *)identifier forRemoteNotification:(NSDictionary *)userInfo completionHandler:(void (^)())completionHandler{
    
    [[DetectID sdk] handleActionWithIdentifier:identifier forNotification:userInfo]; completionHandler();
}

-(void)userNotificationCenter:(UNUserNotificationCenter *)center willPresentNotification:(UNNotification *)notification withCompletionHandler:(void (^)(UNNotificationPresentationOptions options))completionHandler{
    dispatch_async(dispatch_get_main_queue(), ^{

        [[[DetectID sdk] PUSH_API] enablePushTransactionDefaultDialog:false];
        [[[DetectID sdk] PUSH_API] enablePushAlertDefaultDialog:false];
        
        [[DetectID sdk] subscribePayload:notification withCompletionHandler:completionHandler];
    });
}

-(void)userNotificationCenter:(UNUserNotificationCenter *)center didReceiveNotificationResponse:(UNNotificationResponse *)response withCompletionHandler:(void(^)())completionHandler{
    [[DetectID sdk] handleActionWithIdentifier:response];
}

- (BOOL)application:(UIApplication *)application openURL:(NSURL *)url sourceApplication:(NSString *)sourceApplication annotation:(id)annotation{
    [[DetectID sdk] deviceRegistrationByCode:[url query]];
    
    return YES;
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
    NSLog(@"active");
}

- (NSMutableArray *)launchNotification{
    return objc_getAssociatedObject(self, &launchNotificationKey);
}

- (void)setLaunchNotification:(NSDictionary *)aDictionary{
    objc_setAssociatedObject(self, &launchNotificationKey, aDictionary, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
}

- (void)dealloc{
    self.launchNotification    = nil;
}

- (void)onPushTransactionOpen:(TransactionInfo *)transaction {
    
    DIDPluginTransactionOpenListener* pluginTransactionOpen = [DIDPluginTransactionOpenListener sharedInstance];
    
    pluginTransactionOpen.transactionInfo = transaction;
}

- (void)onPushAlertOpen:(TransactionInfo *)transaction {
    DIDPluginPushAlertOpenListener* pluginAlertOpen = [DIDPluginPushAlertOpenListener sharedInstance];
    
    pluginAlertOpen.transactionInfo = transaction;
}

@end
