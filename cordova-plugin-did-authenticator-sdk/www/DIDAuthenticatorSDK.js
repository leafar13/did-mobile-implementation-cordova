var exec = require('cordova/exec');

var DetectIDCordovaPlugin={
	initDIDServerWithParams : function(success, fail, initParams){
		exec(success, fail, "DIDPlugRegistrationApi","initDIDServerWithParams", [{"initParams" : initParams}]);
	},
	displayDeviceRegistrationDialog : function (success, fail){
        exec(success, fail, "DIDPlugRegistrationApi","displayDeviceRegistrationDialog",[]);
	},
	deviceRegistrationByCode : function (success, fail, code){
        exec(success, fail, "DIDPlugRegistrationApi","deviceRegistrationByCode",[{"code":code}]);
	},
	deviceRegistrationByQRCode : function (success, fail){
        exec(success, fail, "DIDPlugRegistrationApi","deviceRegistrationByQRCode",[{}]);
	},
	setDeviceRegistrationServerResponseListener : function (success, fail){
        exec(success, fail, "DIDPlugRegistrationApi","setDeviceRegistrationServerResponseListener",[]);
	},
	setRegistrationViewProperties : function (success, fail, registrationViewProperties){
        exec(success, fail, "DIDPlugRegistrationApi","setRegistrationViewProperties", ["" + JSON.stringify(registrationViewProperties)]);
	},
	setPushTransactionViewProperties : function(success, fail, pushTransactionViewProperties){
	    exec(success, fail, "DIDPlugPushApi", "setPushTransactionViewProperties", ["" + JSON.stringify(pushTransactionViewProperties)]);
	},
	setPushQuickActionServerResponseListener : function(success, fail){
	    exec(success, fail, "DIDPlugPushApi", "setPushTransactionServerResponseListener", []);
	},
	setPushTransactionReceiveListener : function(success, fail){
		exec(success, fail, "DIDPlugPushApi", "setPushTransactionReceiveListener", []);
	},
	setPushTransactionOpenListener : function(success, fail){
	    exec(success, fail, "DIDPlugPushApi", "setPushTransactionOpenListener", []);
	},
	setPushTransactionActionListener : function(success, fail){
	    exec(success, fail, "DIDPlugPushApi", "setPushTransactionActionListener", []);
	},
	setPushAlertViewProperties : function(success, fail, setPushAlertViewProperties){
	    exec(success, fail, "DIDPlugPushApi", "setPushAlertViewProperties", [setPushAlertViewProperties]);
	},
	confirmPushTransactionAction : function(success, fail, transactionJson){
	    exec(success, fail, "DIDPlugPushApi", "confirmPushTransactionAction", [transactionJson]);
	},
	declinePushTransactionAction : function(success, fail, transactionJson){
	    exec(success, fail, "DIDPlugPushApi", "declinePushTransactionAction", [transactionJson]);
	},
	setPushAlertReceiveListener : function(success, fail){
        exec(success, fail, "DIDPlugPushApi", "setPushAlertReceiveListener", []);
	},
	setPushAlertOpenListener : function(success, fail){
        exec(success, fail, "DIDPlugPushApi", "setPushAlertOpenListener", []);
	},
	approvePushAlert : function(success, fail, transactionJson){
		exec(success, fail, "DIDPlugPushApi", "approvePushAlertAction", [transactionJson]);
	},
	setPushAuthenticationResponseAdditionalInfo : function(success, fail, additionalInfoJson){
	    exec(success, fail, "DIDPlugPushApi", "setPushAuthenticationResponseAdditionalInfo", [additionalInfoJson]);
	},
	getAccounts : function (success) {
        exec(success, null, "DIDPlugAccountsApi","getAccounts", [{}]);
	},
	updateTokenTimeStepValue : function(success, fail, account){
		exec(success, fail, "DIDPlugOtpApi", "updateTokenTimeStepValue", [account]);
	},
	getTokenValue: function(success, fail, account) {
		exec(success, fail, "DIDPlugOtpApi", "getTokenValue", [account]);
	},
	removeAccount: function(success, fail, account){
		exec(success, fail, "DIDPlugAccountsApi", "removeAccount", [{"currentAccount": account }]);
	},
	setAccountUsername: function (success, fail, username, account){
		exec(success, fail, "DIDPlugAccountsApi", "setAccountUsername", [{"username": username, "currentAccount": account }]);
	}


};

module.exports = DetectIDCordovaPlugin;