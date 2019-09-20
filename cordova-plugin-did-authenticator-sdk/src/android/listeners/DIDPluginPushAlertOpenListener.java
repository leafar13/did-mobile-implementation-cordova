package net.easysol.did.DetectIDCordovaPlugin.listeners;

import com.google.gson.Gson;

import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.alert.listener.PushAlertOpenListener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

public class DIDPluginPushAlertOpenListener implements PushAlertOpenListener {

    private CallbackContext callbackContext;
    private TransactionInfo transactionInfo;

    private static DIDPluginPushAlertOpenListener instance;

    private DIDPluginPushAlertOpenListener(){}

    public static DIDPluginPushAlertOpenListener getInstance(){
        if (instance == null){
            instance = new DIDPluginPushAlertOpenListener();
        }
        return instance;
    }

    public void setCallbackContext(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
        if (transactionInfo!=null){
            onPushAlertOpen(transactionInfo);
            transactionInfo = null;
        }
    }

    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    @Override
    public void onPushAlertOpen(TransactionInfo transactionInfo) {
        String jsonTransactionInfo = new Gson().toJson(transactionInfo);
        PluginResult result = new PluginResult(PluginResult.Status.OK, jsonTransactionInfo);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
    }
}
