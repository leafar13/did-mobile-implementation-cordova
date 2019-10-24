package net.easysol.did.DetectIDCordovaPlugin.listeners;

import net.easysol.did.push_auth.transaction.listener.PushTransactionServerResponseListener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

/**
 * Created by John Garcia on 29/05/2018.
 */

public class DIDPluginTransactionServerResponseListener implements PushTransactionServerResponseListener {
    private CallbackContext callbackContext;

    public DIDPluginTransactionServerResponseListener(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    @Override
    public void onPushTransactionServerResponse(String response) {
        PluginResult result = new PluginResult(PluginResult.Status.OK, response);
        callbackContext.sendPluginResult(result);
    }
}
