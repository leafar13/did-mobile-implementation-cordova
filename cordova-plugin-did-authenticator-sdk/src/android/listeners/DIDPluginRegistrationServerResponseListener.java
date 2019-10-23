package net.easysol.did.DetectIDCordovaPlugin.listeners;

import net.easysol.did.common.registration.listener.DeviceRegistrationServerResponseListener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

/**
 * Created by John Garcia on 29/05/2018.
 */

public class DIDPluginRegistrationServerResponseListener implements DeviceRegistrationServerResponseListener {

    private CallbackContext callbackContext;

    public DIDPluginRegistrationServerResponseListener(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    @Override
    public void onRegistrationServerResponse(String response) {
        PluginResult result = new PluginResult(PluginResult.Status.OK, response);
        callbackContext.sendPluginResult(result);
    }
}
