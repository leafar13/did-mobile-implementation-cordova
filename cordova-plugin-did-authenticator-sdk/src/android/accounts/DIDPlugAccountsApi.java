package net.easysol.did.DetectIDCordovaPlugin.accounts;

import android.content.Context;

import net.easysol.did.DetectID;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;

public class DIDPlugAccountsApi extends CordovaPlugin {

    private final String TAG = "DetectIDCordovaPlugin";
    private Context myContext;

    private final String GET_ACCOUNTS = "getAccounts";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        myContext = cordova.getActivity().getApplicationContext();
        DetectID.sdk(myContext);

        if (action.equals(GET_ACCOUNTS)) {
            DIDPlugAccountsManager.getAccounts(myContext, callbackContext);
        }

        return true;
    }
}