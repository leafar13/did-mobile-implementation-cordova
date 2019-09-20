package net.easysol.did.DetectIDCordovaPlugin.push;

import android.content.Context;
import com.google.gson.Gson;
import net.easysol.did.DetectID;
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginPushAlertOpenListener;
import net.easysol.did.DetectIDCordovaPlugin.listeners.DIDPluginPushAlertReceiveListener;
import net.easysol.did.common.transaction.TransactionInfo;
import net.easysol.did.push_auth.alert.PushAlertViewProperties;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DIDPlugPushAlertManager{

    private static final String NOTIFICATION_ICON_RESOURCE = "NOTIFICATION_ICON_RESOURCE";
    private static final String APPROVE = "APPROVE";
    private static final String DRAWABLE = "drawable";

    private DIDPlugPushAlertManager(){}

     public static void setPushAlertViewProperties(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject jsonPushAlertViewProperties = new JSONObject(args.get(0).toString());
        PushAlertViewProperties pushAlertViewProperties = new PushAlertViewProperties(myContext);
        if (jsonPushAlertViewProperties.has(APPROVE)) {
            pushAlertViewProperties.APPROVE = jsonPushAlertViewProperties.getString(APPROVE);
        }
        if (jsonPushAlertViewProperties.has(NOTIFICATION_ICON_RESOURCE)) {
            pushAlertViewProperties.NOTIFICATION_ICON_RESOURCE = myContext
                    .getResources()
                    .getIdentifier(jsonPushAlertViewProperties.getString(NOTIFICATION_ICON_RESOURCE), DRAWABLE, myContext.getPackageName());
        }
        DetectID.sdk(myContext).PUSH_API.setPushAlertViewProperties(pushAlertViewProperties);
        callbackContext.success();
    }

    public static void setPushAlertReceiveListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DetectID.sdk(myContext).PUSH_API.setPushAlertReceivedListener(new DIDPluginPushAlertReceiveListener(callbackContext));
    }

    public static void setPushAlertOpenListener(Context myContext, JSONArray args, CallbackContext callbackContext) {
        DIDPluginPushAlertOpenListener.getInstance().setCallbackContext(callbackContext);
        DetectID.sdk(myContext).PUSH_API.setPushAlertOpenListener(DIDPluginPushAlertOpenListener.getInstance());
    }

    public static void approvePushAlert(Context myContext, JSONArray args, CallbackContext callbackContext) throws JSONException {
        TransactionInfo transactionInfo = new Gson().fromJson(args.getString(0), TransactionInfo.class);
        DetectID.sdk(myContext).PUSH_API.approvePushAlertAction(transactionInfo);
    }


}