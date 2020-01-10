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
import android.util.Log;

import net.easysol.did.DetectID;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class DIDPlugPushApi extends CordovaPlugin {
    private Context myContext;
    private final String TAG = "DetectIDCordovaPlugin";
    private final String SET_PUSH_TRANSACTION_SERVER_RESPONSE_LISTENER = "setPushTransactionServerResponseListener";
    private final String SET_PUSH_TRANSACTION_RECEIVE_LISTENER = "setPushTransactionReceiveListener";
    private final String SET_PUSH_TRANSACTION_OPEN_LISTENER = "setPushTransactionOpenListener";
    private final String CONFIRM_PUSH_TRANSACTION_ACTION = "confirmPushTransactionAction";
    private final String DECLINE_PUSH_TRANSACTION_ACTION = "declinePushTransactionAction";
    private final String SET_PUSH_ALERT_RECEIVE_LISTENER = "setPushAlertReceiveListener";
    private final String SET_PUSH_ALERT_OPEN_LISTENER = "setPushAlertOpenListener";
    private final String APPROVE_PUSH_ALERT = "approvePushAlertAction";
    private final String SET_PUSH_AUTHENTICATION_RESPONSE_ADDITIONAL_INFO = "setPushAuthenticationResponseAdditionalInfo";
    private final String SET_TRANSACTION_VIEW_PROPERTIES = "setPushTransactionViewProperties";
    private final String SET_ALERT_VIEW_PROPERTIES = "setPushAlertViewProperties";
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        myContext = cordova.getActivity().getApplicationContext();
        DetectID.sdk(myContext);
        try {

        if (action.equals(SET_TRANSACTION_VIEW_PROPERTIES)) {
            DIDPlugPushTransactionManager.setPushTransactionViewProperties(myContext, args, callbackContext);
        }
        if (action.equals(SET_PUSH_TRANSACTION_SERVER_RESPONSE_LISTENER)) {
            DIDPlugPushTransactionManager.setPushTransactionServerResponseListener(myContext, args, callbackContext);
        }
        if (action.equals(SET_PUSH_TRANSACTION_RECEIVE_LISTENER)) {
            DIDPlugPushTransactionManager.setPushTransactionReceiveListener(myContext, args, callbackContext);
        }
        if (action.equals(SET_PUSH_TRANSACTION_OPEN_LISTENER)) {
            DIDPlugPushTransactionManager.setPushTransactionOpenListener(myContext, args, callbackContext);
        }
        if (action.equals(CONFIRM_PUSH_TRANSACTION_ACTION)) {
            DIDPlugPushTransactionManager.confirmPushTransactionAction(myContext, args, callbackContext);
        }
        if (action.equals(DECLINE_PUSH_TRANSACTION_ACTION)) {
            DIDPlugPushTransactionManager.declinePushTransactionAction(myContext, args, callbackContext);
        }
        if (action.equals(SET_PUSH_ALERT_RECEIVE_LISTENER)) {
            DIDPlugPushAlertManager.setPushAlertReceiveListener(myContext, args, callbackContext);
        }
        if (action.equals(SET_PUSH_ALERT_OPEN_LISTENER)) {
            DIDPlugPushAlertManager.setPushAlertOpenListener(myContext, args, callbackContext);
        }
        if (action.equals(APPROVE_PUSH_ALERT)) {
            DIDPlugPushAlertManager.approvePushAlert(myContext, args, callbackContext);
        }
        if (action.equals(SET_PUSH_AUTHENTICATION_RESPONSE_ADDITIONAL_INFO)) {
            DIDPlugPushTransactionManager.setPushAuthenticationResponseAdditionalInfo(myContext, args, callbackContext);
        }
        if (action.equals(SET_ALERT_VIEW_PROPERTIES)) {
            DIDPlugPushAlertManager.setPushAlertViewProperties(myContext, args, callbackContext);
        }

    } catch (JSONException e) {
        Log.e(TAG, e.toString());
        callbackContext.error(e.toString());
    }
        return true;
    }
}
