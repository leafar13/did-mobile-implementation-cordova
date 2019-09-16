package net.easysol.did.DetectIDCordovaPlugin.registration;

import android.content.Context;
import android.util.Log;

import net.easysol.did.DetectID;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class DIDPlugRegistrationApi extends CordovaPlugin {

    private final String TAG = "DetectIDCordovaPlugin";
    private Context myContext;

    private final String INIT_WITH_PARAMS = "initDIDServerWithParams";
    private final String SET_DEVICE_REGISTRATION_SERVER_RESPONSE_LISTENER = "setDeviceRegistrationServerResponseListener";
    private final String DEVICE_REGISTRATION_BY_CODE = "deviceRegistrationByCode";
    private final String SET_REGISTRATION_VIEW_PROPERTIES = "setRegistrationViewProperties";
    private final String DISPLAY_DEVICE_REGISTRATION_DIALOG = "displayDeviceRegistrationDialog";
    private final String ENABLE_REGISTRATION_SERVER_RESPONSE_ALERTS = "enableRegistrationServerResponseAlerts";
    private final String DEVICE_REGISTRATION_BY_QR = "deviceRegistrationByQRCode";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            myContext = cordova.getActivity().getApplicationContext();
            DetectID.sdk(myContext);

            if (action.equals(INIT_WITH_PARAMS)) {
                DIDPlugRegistrationManager.initDIDServerWithParams(myContext, args, callbackContext);
            }
            if (action.equals(SET_DEVICE_REGISTRATION_SERVER_RESPONSE_LISTENER)) {
                DIDPlugRegistrationManager.setDeviceRegistrationListener(myContext, callbackContext);
            }
            if (action.equals(DEVICE_REGISTRATION_BY_CODE)) {
                DIDPlugRegistrationManager.setDeviceRegistrationByCode(myContext, args, callbackContext);
            }
            if (action.equals(DEVICE_REGISTRATION_BY_QR)) {
                DIDPlugRegistrationManager.setDeviceRegistrationByQrCode(myContext, args, callbackContext);
            }
            if (action.equals(SET_REGISTRATION_VIEW_PROPERTIES)) {
                DIDPlugRegistrationManager.setRegistrationViewProperties(myContext, args, callbackContext);
            }
            if (action.equals(DISPLAY_DEVICE_REGISTRATION_DIALOG)) {
                DIDPlugRegistrationManager.displayDeviceRegistration(myContext, callbackContext);
            }
            if (action.equals(ENABLE_REGISTRATION_SERVER_RESPONSE_ALERTS)) {
                DIDPlugRegistrationManager.enableRegistrationServerResponse(myContext, args, callbackContext);
            }

            return true;
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
            callbackContext.error(e.toString());
        }
        return false;
    }
}
