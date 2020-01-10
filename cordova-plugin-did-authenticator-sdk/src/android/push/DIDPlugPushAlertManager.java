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
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginPushAlertOpenListener;
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginPushAlertReceiveListener;
import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.alert.PushAlertViewProperties;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DIDPlugPushAlertManager{

    private static final String NOTIFICATION_ICON_RESOURCE = "NOTIFICATION_ICON_RESOURCE";
    private static final String APPROVE = "APPROVE";
    private static final String DRAWABLE = "drawable";

    private DIDPlugPushAlertManager(){}

     public static void setPushAlertViewProperties(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject jsonPushAlertViewProperties = new JSONObject(args.get(0).toString());
        PushAlertViewProperties pushAlertViewProperties = new PushAlertViewProperties(myContext);
        if (jsonPushAlertViewProperties.has(APPROVE)) {
            pushAlertViewProperties.APPROVE = jsonPushAlertViewProperties.getString(APPROVE);
        }
        if (jsonPushAlertViewProperties.has(NOTIFICATION_ICON_RESOURCE)) {
            pushAlertViewProperties.NOTIFICATION_ICON_RESOURCE = myContext
                    .getResources()
                    .getIdentifier(jsonPushAlertViewProperties.getString(NOTIFICATION_ICON_RESOURCE), DRAWABLE, myContext.getPackageName());
        }
        DetectID.sdk(myContext).PUSH_API.setPushAlertViewProperties(pushAlertViewProperties);
        callbackContext.success();
    }

    public static void setPushAlertReceiveListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DetectID.sdk(myContext).PUSH_API.setPushAlertReceivedListener(new DIDPluginPushAlertReceiveListener(callbackContext));
    }

    public static void setPushAlertOpenListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DIDPluginPushAlertOpenListener.getInstance().setCallbackContext(callbackContext);
        DetectID.sdk(myContext).PUSH_API.setPushAlertOpenListener(DIDPluginPushAlertOpenListener.getInstance());
    }

    public static void approvePushAlert(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        TransactionInfo transactionInfo = new Gson().fromJson(args.getString(0), TransactionInfo.class);
        DetectID.sdk(myContext).PUSH_API.approvePushAlertAction(transactionInfo);
    }


}