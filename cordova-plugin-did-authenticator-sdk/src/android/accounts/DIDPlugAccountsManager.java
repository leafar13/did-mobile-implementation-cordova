package net.easysol.did.DetectIDCordovaPlugin.accounts;

import android.content.Context;

import com.google.gson.Gson;

import net.easysol.did.DetectID;
import net.easysol.did.common.account.Account;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class DIDPlugAccountsManager {

    private DIDPlugAccountsManager() {

    }

    public static void getAccounts(Context context, CallbackContext callbackContext) {
        try {
            List<Account> accounts = DetectID.sdk(context).getAccounts();
            String result = new Gson().toJson(accounts);
            JSONArray jsonArray = new JSONArray(result);
            callbackContext.success(jsonArray);
        } catch (IllegalArgumentException | JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }
}
