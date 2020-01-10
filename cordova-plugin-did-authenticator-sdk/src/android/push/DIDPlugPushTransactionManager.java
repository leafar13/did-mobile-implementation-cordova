
//
// Disclaimer
// © 2019, Cyxtera Cybersecurity, Inc. d/b/a AppGate.  All rights reserved.  

// Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: 
// (a) redistributions of source code must retain the above copyright notice, this list of conditions and the disclaimer below, and (b) 
// redistributions in binary form must reproduce the above copyright notice, this list of conditions and the disclaimer below in the documentation
// and/or other materials provided with the distribution. 

// THE CODE AND SCRIPTS POSTED ON THIS WEBSITE ARE PROVIDED ON AN “AS IS” BASIS AND YOUR USE OF SUCH CODE AND/OR SCRIPTS IS AT YOUR OWN RISK.  
// APPGATE DISCLAIMS ALL EXPRESS AND IMPLIED WARRANTIES, EITHER IN FACT OR BY OPERATION OF LAW, STATUTORY OR OTHERWISE, INCLUDING, BUT NOT LIMITED TO, 
// ALL WARRANTIES OF MERCHANTABILITY, TITLE, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT, ACCURACY, COMPLETENESS, COMPATABILITY OF SOFTWARE OR 
// EQUIPMENT OR ANY RESULTS TO BE ACHIEVED THEREFROM.  APPGATE DOES NOT WARRANT THAT SUCH CODE AND/OR SCRIPTS ARE OR WILL BE ERROR-FREE.  
// IN NO EVENT SHALL APPGATE BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, RELIANCE, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES, OR ANY LOSS 
// OF GOODWILL, LOSS OF ANTICIPATED SAVINGS, COST OF PURCHASING REPLACEMENT SERVICES, LOSS OF PROFITS, REVENUE, DATA OR DATA USE, ARISING IN ANY WAY OUT 
// OF THE USE AND/OR REDISTRIBUTION OF SUCH CODE AND/OR SCRIPTS, REGARDLESS OF THE LEGAL THEORY UNDER WHICH SUCH LIABILITY IS ASSERTED AND REGARDLESS 
// OF WHETHER APPGATE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH LIABILITY.
//
package net.easysol.did.DetectIDCordovaPlugin.push;

import android.content.Context;
import com.google.gson.Gson;

import net.easysol.did.DetectID;
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginTransactionOpenListener;
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginTransactionReceiveListener;
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginTransactionServerResponseListener;
import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.transaction.PushTransactionViewProperties;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class DIDPlugPushTransactionManager {

    private static final String CONFIRM = "CONFIRM";
    private static final String DECLINE = "DECLINE";
    private static final String SERVER_RESPONSE_CODE_96 = "SERVER_RESPONSE_CODE_96";
    private static final String SERVER_RESPONSE_CODE_98 = "SERVER_RESPONSE_CODE_98";
    private static final String SERVER_RESPONSE_CODE_99 = "SERVER_RESPONSE_CODE_99";
    private static final String SERVER_RESPONSE_CODE_1001 = "SERVER_RESPONSE_CODE_1001";
    private static final String SERVER_RESPONSE_CODE_1002 = "SERVER_RESPONSE_CODE_1002";
    private static final String SERVER_RESPONSE_CODE_1012 = "SERVER_RESPONSE_CODE_1012";
    private static final String SERVER_RESPONSE_CODE_1020 = "SERVER_RESPONSE_CODE_1020";
    private static final String SERVER_RESPONSE_CODE_1021 = "SERVER_RESPONSE_CODE_1021";
    private static final String SERVER_RESPONSE_CODE_1022 = "SERVER_RESPONSE_CODE_1022";
    private static final String ENABLE_NOTIFICATION_QUICK_ACTIONS = "ENABLE_NOTIFICATION_QUICK_ACTIONS";
    private static final String NOTIFICATION_ICON_RESOURCE = "NOTIFICATION_ICON_RESOURCE";
    private static final String CONFIRM_ICON_RESOURCE = "CONFIRM_ICON_RESOURCE";
    private static final String DECLINE_ICON_RESOURCE = "DECLINE_ICON_RESOURCE";
    private static final String DRAWABLE = "drawable";

    private DIDPlugPushTransactionManager(){}

    public static void setPushTransactionViewProperties(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject jsonPushTransactionViewProperties = new JSONObject(args.get(0).toString());
        PushTransactionViewProperties pushTransactionViewProperties = new PushTransactionViewProperties(myContext);

        if (jsonPushTransactionViewProperties.has(NOTIFICATION_ICON_RESOURCE)) {
            pushTransactionViewProperties.NOTIFICATION_ICON_RESOURCE = myContext
                    .getResources()
                    .getIdentifier(jsonPushTransactionViewProperties.getString(NOTIFICATION_ICON_RESOURCE), DRAWABLE, myContext.getPackageName());
        }
        if (jsonPushTransactionViewProperties.has(CONFIRM_ICON_RESOURCE)) {
            pushTransactionViewProperties.CONFIRM_ICON_RESOURCE = myContext
                    .getResources()
                    .getIdentifier(jsonPushTransactionViewProperties.getString(CONFIRM_ICON_RESOURCE), DRAWABLE, myContext.getPackageName());
        }
        if (jsonPushTransactionViewProperties.has(DECLINE_ICON_RESOURCE)) {
            pushTransactionViewProperties.DECLINE_ICON_RESOURCE = myContext
                    .getResources()
                    .getIdentifier(jsonPushTransactionViewProperties.getString(DECLINE_ICON_RESOURCE), DRAWABLE, myContext.getPackageName());
        }
        if (jsonPushTransactionViewProperties.has(ENABLE_NOTIFICATION_QUICK_ACTIONS)) {
            pushTransactionViewProperties.ENABLE_NOTIFICATION_QUICK_ACTIONS = jsonPushTransactionViewProperties.getBoolean(ENABLE_NOTIFICATION_QUICK_ACTIONS);
        }
        if (jsonPushTransactionViewProperties.has(CONFIRM)) {
            pushTransactionViewProperties.CONFIRM = jsonPushTransactionViewProperties.getString(CONFIRM);
        }
        if (jsonPushTransactionViewProperties.has(DECLINE)) {
            pushTransactionViewProperties.DECLINE = jsonPushTransactionViewProperties.getString(DECLINE);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_96)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_96 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_96);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_98)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_98 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_98);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_99)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_99 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_99);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_1001)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_1001 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_1001);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_1002)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_1002 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_1002);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_1012)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_1012 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_1012);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_1020)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_1020 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_1020);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_1021)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_1021 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_1021);
        }
        if (jsonPushTransactionViewProperties.has(SERVER_RESPONSE_CODE_1022)) {
            pushTransactionViewProperties.SERVER_RESPONSE_CODE_1022 = jsonPushTransactionViewProperties.getString(SERVER_RESPONSE_CODE_1022);
        }
        DetectID.sdk(myContext).PUSH_API.setPushTransactionViewProperties(pushTransactionViewProperties);
        callbackContext.success();
    }

    public static void setPushTransactionServerResponseListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DetectID.sdk(myContext).PUSH_API.setPushTransactionServerResponseListener(new DIDPluginTransactionServerResponseListener(callbackContext));
    }

    public static void setPushTransactionReceiveListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DetectID.sdk(myContext).PUSH_API.setPushTransactionReceivedListener(new DIDPluginTransactionReceiveListener(callbackContext));
    }

    public static void setPushTransactionOpenListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DIDPluginTransactionOpenListener.getInstance().setCallbackContext(callbackContext);
        DetectID.sdk(myContext).PUSH_API.setPushTransactionOpenListener(DIDPluginTransactionOpenListener.getInstance());
    }

    public static void confirmPushTransactionAction(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        TransactionInfo transactionInfo = new Gson().fromJson(args.getString(0), TransactionInfo.class);
        transactionInfo.type = TransactionInfo.TransactionType.PUSH_AUTHENTICATION;
        DetectID.sdk(myContext).PUSH_API.setPushTransactionServerResponseListener(new DIDPluginTransactionServerResponseListener(callbackContext));
        DetectID.sdk(myContext).PUSH_API.confirmPushTransactionAction(transactionInfo);
    }

    public static void declinePushTransactionAction(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        TransactionInfo transactionInfo = new Gson().fromJson(args.getString(0), TransactionInfo.class);
        transactionInfo.type = TransactionInfo.TransactionType.PUSH_AUTHENTICATION;
        DetectID.sdk(myContext).PUSH_API.setPushTransactionServerResponseListener(new DIDPluginTransactionServerResponseListener(callbackContext));
        DetectID.sdk(myContext).PUSH_API.declinePushTransactionAction(transactionInfo);
    }

    public static void setPushAuthenticationResponseAdditionalInfo(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Map<String, String> map = new Gson().fromJson(args.get(0).toString(), Map.class);
        DetectID.sdk(myContext).PUSH_API.setPushAuthenticationResponseAdditionalInfo(map);
    }
}
