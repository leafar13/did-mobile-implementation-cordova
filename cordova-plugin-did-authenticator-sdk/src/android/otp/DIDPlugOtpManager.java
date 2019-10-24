package net.easysol.did.DetectIDCordovaPlugin.otp;

import android.content.Context;

import com.google.gson.Gson;

import net.easysol.did.DetectID;
import net.easysol.did.common.account.Account;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

class DIDPlugOtpManager {

    private DIDPlugOtpManager() {

    }

    static void getTokenValue(Context context, JSONArray args, CallbackContext callbackContext) {
        try {
            Account account = getAccountFromJsonObject(args);
            String tokenValue = DetectID.sdk(context).OTP_API.getTokenValue(account);
            callbackContext.success(tokenValue);
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }

    static void updateTokenTimeStepValue(Context context, JSONArray args, CallbackContext callbackContext) {
        try {
            Account account = getAccountFromJsonObject(args);
            DetectID.sdk(context).OTP_API.updateTokenLifetime(account);
            callbackContext.success();
        } catch (IOException | JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }

    private static Account getAccountFromJsonObject(JSONArray args) throws JSONException {
        JSONObject accountJson = args.getJSONObject(0);
        return new Gson().fromJson(accountJson.toString(), Account.class);
    }
}
