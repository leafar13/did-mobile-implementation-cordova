//
//  DetectIDCordovaPlugin.h
//  didm_auth_sdk_iOS
//
//  Created by Juan Pablo Combariza on 16/05/18.
//  Copyright (c) 2014 Easy Solutions. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>

#define INVALID_PARAMETER_NULL @ "Argument was null or wrong parameter"
#define INVALID_PARAMETER_SIZE @ "Argument has an invalid size"
#define INVALID_PARAMETER_WRONG_TYPE @ "Argument parameter does't have the correct type"
#define INVALID_PARAMETER_WRONG_FORMAT @ "Argument has an invalid format"
#define NS_INVALID_ARGUMENT_EXCEPTION @ "This exception occurs when you pass an invalid argument to a method, such as a nil pointer where a non-nil object is required."

#define ERROR_CALLING_DEFAULT_REGISTRATION_DIALOG @ "Error calling displayDeviceRegistrationDialog method"
#define ERROR_CALLING_REGISTRATION_RESPONSE_DELEGATE @ "Error calling commandDeviceRegistrationServerResponseListener method"
#define ERROR_REGISTRATION_RESPONSE_DELEGATE_NULL @ "commandDeviceRegistrationServerResponseListener is null"
#define ERROR_CREATING_REGEX @ "Unable to create regular expression"

#define SUCCESS_PROCESS @ "Success method exceution"

#define URL_KEY @ "serverURL"
#define CODE_KEY @ "code"
#define ENABLE_KEY @ "enable"

#define serverUrlRegex @ "^(http:\\/\\/|https:\\/\\/)((([0-9]{1,3}).){3}(([0-9]{1,3}))|(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?)(:[0-9]{2,4})?(\\/detect\\/public\\/registration\\/mobileServices.htm\\?code=)([0-9]{0,6})?"
#define regitrationViewPropertiesRegex @ "^\\{(\\s{0,})\"TITLE\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"MESSAGE\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"CONFIRM\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"CANCEL\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_98\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_99\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1002\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1010\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1011\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1012\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1013\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1014\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"SERVER_RESPONSE_CODE_1020\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"CAMERA_PERMISSION_REQUEST\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"CAMERA_PERMISSION_SETTINGS\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,}),(\\s{0,})\"CAMERA_PERMISSION_CANCEL\"(\\s{0,}):(\\s{0,})\"(.*)\\\"(\\s{0,})\\}$"

#define CONFIRM_PROPERTIES @"CONFIRM"
#define DECLINE_PROPERTIES @"DECLINE"
#define APPROVE_PROPERTIES @"APPROVE"

#define SUPERCLASS_PROPERTIES @"superclass"
#define ACCOUNT_PROPERTIES @"account"
#define CHANNEL_PROPERTIES @"channel"
#define GESTURES_PROPERTIES @"gestures"

#define TRANSACTION_ID @"transactionID"
#define SUBJECT @"subject"
#define MESSAGE_PROPERTIES @"message"
#define SUBJECT_NOTIFICATION @"subjectNotification"
#define MESSAGE_NOTIFICATION @"messageNotification"
#define URL_TO_RESPONSE @"urlToResponse"
#define URL_TO_CONFIG_FACEID @"urlToConfigFaceID"
#define TIME_STAMP @"timeStamp"
#define TRANSACTION_OFFLINE_CODE @"transactionOfflineCode"
#define TYPE @"type"
#define BIOMETRIC_TYPE @"biometricType"
#define STATUS @"status"
#define USERNAME @"username"
#define ORGANIZATION_NAME @"organizationName"
#define ACTIVE_OTP_AUTH @"activeOTPAuth"
#define ACTIVE_PUSH_AUTH @"activePushAuth"
#define ACTIVE_QR_AUTH @"activeQRAuth"
#define ACTIVE_PUSH_ALERT @"activePushAlert"
#define ACTIVE_VOICE_AUTH @"activeVoiceAuth"
#define ACTIVE_FACE_AUTH @"activeFaceAuth"

#define ACTIVATION_URL @"activationURL"
#define REGISTRATION_DATE @"registrationDate"
#define IS_LEGACY @"isLegacy"
#define REGISTRATION_METHOD @"registrationMethod"
#define FACE_GESTURES @"faceGestures"
#define CHANNEL_NAME @"channelName"

#define SERVER_RESPONSE_CODE_96_PROPERTIES @"SERVER_RESPONSE_CODE_96"
#define SERVER_RESPONSE_CODE_98_PROPERTIES @"SERVER_RESPONSE_CODE_98"
#define SERVER_RESPONSE_CODE_99_PROPERTIES @"SERVER_RESPONSE_CODE_99"
#define SERVER_RESPONSE_CODE_1001_PROPERTIES @"SERVER_RESPONSE_CODE_1001"
#define SERVER_RESPONSE_CODE_1002_PROPERTIES @"SERVER_RESPONSE_CODE_1002"
#define SERVER_RESPONSE_CODE_1010_PROPERTIES @"SERVER_RESPONSE_CODE_1010"
#define SERVER_RESPONSE_CODE_1011_PROPERTIES @"SERVER_RESPONSE_CODE_1011"
#define SERVER_RESPONSE_CODE_1012_PROPERTIES @"SERVER_RESPONSE_CODE_1012"
#define SERVER_RESPONSE_CODE_1013_PROPERTIES @"SERVER_RESPONSE_CODE_1013"
#define SERVER_RESPONSE_CODE_1014_PROPERTIES @"SERVER_RESPONSE_CODE_1014"
#define SERVER_RESPONSE_CODE_1020_PROPERTIES @"SERVER_RESPONSE_CODE_1020"
#define SERVER_RESPONSE_CODE_1021_PROPERTIES @"SERVER_RESPONSE_CODE_1021"
#define SERVER_RESPONSE_CODE_1022_PROPERTIES @"SERVER_RESPONSE_CODE_1022"

#define  ENABLE_NOTIFICATION_QUICK_ACTIONS_PROPERTIES @"ENABLE_NOTIFICATION_QUICK_ACTIONS"
