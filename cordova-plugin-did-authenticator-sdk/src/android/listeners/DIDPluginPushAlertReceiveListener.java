package net.easysol.did.DetectIDCordovaPlugin.listeners;

import com.google.gson.Gson;

import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.alert.listener.PushAlertReceivedListener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

public class DIDPluginPushAlertReceiveListener implements PushAlertReceivedListener {

    private CallbackContext callbackContext;

    public DIDPluginPushAlertReceiveListener(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    @Override
    public void onPushAlertReceived(TransactionInfo transactionInfo) {
        String jsonTransactionInfo = new Gson().toJson(transactionInfo);
        PluginResult result = new PluginResult(PluginResult.Status.OK, jsonTransactionInfo);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
    }
}
