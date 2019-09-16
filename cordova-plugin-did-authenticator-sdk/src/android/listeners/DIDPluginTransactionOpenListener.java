package net.easysol.did.DetectIDCordovaPlugin.listeners;



import com.cyxtera.did.sdk.data.utils.LogMessagePriority;
import com.cyxtera.did.sdk.data.utils.LogUtils;
import com.google.gson.Gson;

import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.transaction.listener.PushTransactionOpenListener;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

public class DIDPluginTransactionOpenListener implements PushTransactionOpenListener {

    private CallbackContext callbackContext;
    private static DIDPluginTransactionOpenListener instance;
    private TransactionInfo transactionInfo;

    private DIDPluginTransactionOpenListener (){
    }

    public static DIDPluginTransactionOpenListener getInstance(){
        if (instance == null){
            instance = new DIDPluginTransactionOpenListener();
        }
        return instance;
    }

    public void setCallbackContext(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
        if (transactionInfo!=null){
            onPushTransactionOpen(transactionInfo);
            transactionInfo = null;
        }
    }

    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    @Override
    public void onPushTransactionOpen(TransactionInfo transactionInfo) {
        try {
            String jsonTransactionInfo = new Gson().toJson(transactionInfo);
            jsonTransactionInfo = jsonTransactionInfo.replace(":\"PUSH_AUTHENTICATION\",", ":1,");
            JSONObject jsonObject = new JSONObject(jsonTransactionInfo);
            PluginResult result = new PluginResult(PluginResult.Status.OK, jsonObject);
            result.setKeepCallback(true);
            callbackContext.sendPluginResult(result);
        } catch (JSONException e) {
            LogUtils.logErrorWithPriority(getClass().getSimpleName(), "onPushTransactionOpen", e.getMessage(), LogMessagePriority.NOT_IMPORTANT_NOT_URGENT);
        }
    }
}
