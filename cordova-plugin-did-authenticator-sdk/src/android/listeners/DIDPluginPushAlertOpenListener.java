package net.easysol.did.DetectIDCordovaPlugin.listeners;

import com.cyxtera.did.sdk.data.utils.LogMessagePriority;
import com.cyxtera.did.sdk.data.utils.LogUtils;
import com.google.gson.Gson;

import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.alert.listener.PushAlertOpenListener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

public class DIDPluginPushAlertOpenListener implements PushAlertOpenListener {

    private CallbackContext callbackContext;
    private TransactionInfo transactionInfo;

    private static DIDPluginPushAlertOpenListener instance;

    private DIDPluginPushAlertOpenListener() {
    }

    public static DIDPluginPushAlertOpenListener getInstance() {
        if (instance == null) {
            instance = new DIDPluginPushAlertOpenListener();
        }
        return instance;
    }

    public void setCallbackContext(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
        if (transactionInfo != null) {
            onPushAlertOpen(transactionInfo);
            transactionInfo = null;
        }
    }

    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    @Override
    public void onPushAlertOpen(TransactionInfo transactionInfo) {
        try {
            String jsonTransactionInfo = new Gson().toJson(transactionInfo);
            JSONObject jsonObject = new JSONObject(jsonTransactionInfo);
            PluginResult result = new PluginResult(PluginResult.Status.OK, jsonObject);
            result.setKeepCallback(true);
            callbackContext.sendPluginResult(result);
        } catch (JSONException e) {
            LogUtils.logErrorWithPriority(getClass().getSimpleName(), "onPushTransactionOpen", e.getMessage(), LogMessagePriority.NOT_IMPORTANT_NOT_URGENT);
        }
    }
}
