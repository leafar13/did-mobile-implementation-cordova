package net.easysol.did.DetectIDCordovaPlugin.otp;

import android.content.Context;

import net.easysol.did.DetectID;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;

public class DIDPlugOtpApi extends CordovaPlugin {

    private final String TAG = "DetectIDCordovaPlugin";
    private Context myContext;

    private final String GET_TOKEN_VALUE = "getTokenValue";
    private final String UPDATE_TOKEN_TIMESTEP_VALUE = "updateTokenTimeStepValue";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        myContext = cordova.getActivity().getApplicationContext();
        DetectID.sdk(myContext);

        if (action.equals(GET_TOKEN_VALUE)) {
            DIDPlugOtpManager.getTokenValue(myContext, args, callbackContext);
        }
        if (action.equals(UPDATE_TOKEN_TIMESTEP_VALUE)) {
            DIDPlugOtpManager.updateTokenTimeStepValue(myContext, args, callbackContext);
        }

        return true;
    }
}
