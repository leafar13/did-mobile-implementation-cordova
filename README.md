# Integración DetectID-SDK con PhoneGap

## Objeto Principal de los métodos expuesto en DetectID-SDK
    DetectIDCordovaPlugin
    
## Firma de los métodos expuestos en el plugin DetectIDCordova
#### *Método inicialización*
    Este método sirve para inicializar el SDK, se debe colocar una sola vez al momento que la aplicación termine de cargar. Recibe 3 parámetros las cuales los dos primeros son callbacks de respuestas y el último es un String Json que recibe un objeto de initParams con la url, como lo muestra en la siguiente implementación    
#####  Método expuesto :
    initDIDServerWithParams : function(success, fail, initParams);     
##### Implementación :
    var initParams = '{"url": "http://URL:PORT/detect/public/registration/mobileServices.htm?code="}';
    DetectIDCordovaPlugin.initDIDServerWithParams(function(successMsg) {
        console.log("successMsg", successMsg);
    }, function(failedMsg) {
        console.log("failedMsg", failedMsg)
    }, initParams);

#### Métodos de registro
Para realizar un registro se puede utilizar unos de los dos métodos expuestos, por código o por QrCode, para cualquiera de los dos se debe implementar el listener que permite tener una respuesta al momento que se envia la petición.
##### *Registro por código*
    Este método recibe 3 parámetros, los dos primeros son callbacks de respuestas y el último es un String con el código de registro.
##### Método expuesto
    deviceRegistrationByCode : function (success, fail, code);
##### Implementación
    var code = document.getElementById("inputRegistrationCode").value;
    DetectIDCordovaPlugin.deviceRegistrationByCode(function(successRegistrationResponse) {
        console.log("successRegistrationResponse", successRegistrationResponse);
    }, function(failedRegistrationResponse) {
        console.log("failedRegistrationResponse", failedRegistrationResponse)
    }, code);
    
##### *Registro por QR*
    Este método recibe 2 parámetros las cuales son callbacks de respuestas.
##### Método expuesto :
    deviceRegistrationByQRCode : function (success, fail);
##### Implementación
    DetectIDCordovaPlugin.deviceRegistrationByQRCode(function(successRegistrationResponse) {
        console.log("successRegistrationResponse", successRegistrationResponse);
    }, function(failedRegistrationResponse) {
        console.log("failedRegistrationResponse", failedRegistrationResponse)
    });
        
#### *Métodos de OTP* 

##### *updateTokenTimeStepValue*
    Este método recibe 3 parámetros los cuales son 2 callbacks de respuesta y un objeto cuenta.
##### Método expuesto 
    updateTokenTimeStepValue  : function (success, fail, account);
##### Implementación 
    DetectIDCordovaPlugin.getAccounts(function(accounts) {
    let account = accounts[0];
    DetectIDCordovaPlugin.updateTokenTimeStepValue(function() {
    console.log("onSuccess", "updateTokenTimeStepValue");
    },
    function(error) {
    console.log("onError", error);
    }, account);
    });

##### *getTokenValue*
    Este método recibe 3 parámetros los cuales son 2 callbacks de respuesta y un objeto cuenta.
##### Método expuesto 
    getTokenValue  : function (success, fail, account);
##### Implementación 
    DetectIDCordovaPlugin.getAccounts(function(accounts) {
        let account = accounts[0];
        DetectIDCordovaPlugin.getTokenValue(function() {
        console.log("onSuccess", "getTokenValue");
    },
    function(error) {
        console.log("onError", error);
        }, account);
    });
    
## Otros métodos expuestos en el plugin de JavaScript DetectIDCordova
Los método listener a continuación se debe colocar una sola vez al momento que la aplicación termine de cargar.

##### *displayDeviceRegistrationDialog*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    displayDeviceRegistrationDialog : function (success, fail);
##### Implementación 
    DetectIDCordovaPlugin.displayDeviceRegistrationDialog(
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }
    );
    
##### *setDeviceRegistrationServerResponseListener*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta. Este método es el que devuelve los codigos de respuesta del servidor.
##### Método expuesto 
    setDeviceRegistrationServerResponseListener : function (success, fail);
##### Implementación 
    DetectIDCordovaPlugin.setDeviceRegistrationServerResponseListener (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }
    );
        
##### *setRegistrationViewProperties*
    Este método recibe 3 parámetros los cuales son 2 callbacks de respuesta y un objeto registrationViewProperties.
##### Método expuesto 
    setRegistrationViewProperties : function (success, fail);
##### Implementación 
    var registrationViewProperties = {
        "TITLE": "Titulo  personalizado",
        "MESSAGE": "Mensaje personalizado",
        "CONFIRM": "Confirmar la transaccion",
        "CANCEL": "Declinar la transaccion",
        "SERVER_RESPONSE_CODE_98": "codigo 98",
        "SERVER_RESPONSE_CODE_99": "codigo 99",
        "SERVER_RESPONSE_CODE_1002": "codigo 1002",
        "SERVER_RESPONSE_CODE_1010": "codigo 1010",
        "SERVER_RESPONSE_CODE_1011": "codigo 1011",
        "SERVER_RESPONSE_CODE_1012": "codigo 1012",
        "SERVER_RESPONSE_CODE_1013": "codigo 1013",
        "SERVER_RESPONSE_CODE_1014": "codigo 1014",
        "SERVER_RESPONSE_CODE_1020": "codigo 1020",
        "CAMERA_PERMISSION_REQUEST": "CAMERA_PERMISSION_REQUEST",
        "CAMERA_PERMISSION_SETTINGS": "CAMERA_PERMISSION_SETTINGS",
        "CAMERA_PERMISSION_CANCEL": "CAMERA_PERMISSION_CANCEL"
    };
    DetectIDCordovaPlugin.setRegistrationViewProperties (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }, registrationViewProperties);
        
##### *setPushTransactionViewProperties*
    Este método recibe 3 parámetros los cuales son 2 callbacks de respuesta y un objeto transactionViewProperties.
##### Método expuesto 
    setPushTransactionViewProperties : function (success, fail);
##### Implementación 
    var transactionViewProperties = {
        "TITLE": "Titulo  personalizado",
        "MESSAGE": "Mensaje personalizado",
        "CONFIRM": "Confirmar push",
        "DECLINE": "Declinar push",
        "SERVER_RESPONSE_CODE_96": "codigo 96",
        "SERVER_RESPONSE_CODE_98": "codigo 98",
        "SERVER_RESPONSE_CODE_99": "codigo 99",
        "SERVER_RESPONSE_CODE_1001": "codigo 1001",
        "SERVER_RESPONSE_CODE_1002": "codigo 1002",
        "SERVER_RESPONSE_CODE_1010": "codigo 1010",
        "SERVER_RESPONSE_CODE_1012": "codigo 1012",
        "SERVER_RESPONSE_CODE_1020": "codigo 1020",
        "SERVER_RESPONSE_CODE_1021": "codigo 1021",
        "SERVER_RESPONSE_CODE_1022": "codigo 1022",
        "CAMERA_PERMISSION_REQUEST": "CAMERA_PERMISSION_REQUEST",
        "CAMERA_PERMISSION_SETTINGS": "CAMERA_PERMISSION_SETTINGS",
        "CAMERA_PERMISSION_CANCEL": "CAMERA_PERMISSION_CANCEL"
    }
    
    DetectIDCordovaPlugin.setPushTransactionViewProperties (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }, transactionViewProperties);
        
##### *setPushAlertViewProperties*
    Este método recibe 2 parámetros los cuales son 2 callbacks de respuesta y un objeto alertViewProperties.
##### Método expuesto 
    setPushAlertViewProperties  : function (success, fail);
##### Implementación 
    var alertViewProperties = {
        "APPROVE": "Aprobar"
    }
    DetectIDCordovaPlugin.setPushAlertViewProperties (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }, alertViewProperties);
                
##### *setPushTransactionServerResponseListener *
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    setPushTransactionServerResponseListener : function(success, fail)
##### Implementación
    DetectIDCordovaPlugin.setPushTransactionServerResponseListener(function(successTransactionServerResponseListener) {
        console.log("successTransactionServerResponseListener", successTransactionServerResponseListener);
    }, function(failTransactionServerResponseListener) {
        console.log("failTransactionServerResponseListener", failTransactionServerResponseListener)
    });
    
##### *setPushTransactionReceiveListener*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    setPushTransactionReceiveListener : function(success, fail)
##### Implementación 
    DetectIDCordovaPlugin.setPushTransactionReceiveListener(function(successTransactionReceiveListener) {
        console.log("successTransactionReceiveListener", successTransactionReceiveListener);
    }, function(failTransactionReceiveListener) {
        console.log("failTransactionReceiveListener", failTransactionReceiveListener)
    });
##### *setPushTransactionOpenListener*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    setPushTransactionOpenListener : function(success, fail)
##### Implementación 
    DetectIDCordovaPlugin.setPushTransactionOpenListener(function(successTransactionOpenListener) {
        console.log("successTransactionOpenListener", successTransactionOpenListener);
    }, function(failTransactionOpenListener) {
        console.log("failTransactionOpenListener", failTransactionOpenListener)
    });
    
##### *setPushTransactionActionListener*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    setPushTransactionActionListener : function(success, fail)
##### Implementación 
    DetectIDCordovaPlugin.setPushTransactionActionListener(function(successTransactionActionListener) {
        console.log("successTransactionActionListener", successTransactionActionListener);
    }, function(failTransactionActionListener) {
        console.log("failTransactionActionListener", failTransactionActionListener)
    });
    
##### *confirmPushTransactionAction*
    Este método recibe 3 parámetros, los dos primeros son callbacks de respuestas y el último es un objeto TransactionInfo.
##### Método expuesto 
    confirmPushTransactionAction : function(success, fail, transactionJson)
##### Implementación 
    DetectIDCordovaPlugin.confirmPushTransactionAction(function(successConfirmTransactionActionListener) {
        console.log("successConfirmTransactionActionListener", successConfirmTransactionActionListener);
    }, function(failConfirmTransactionActionListener) {
        console.log("failConfirmTransactionActionListener", failConfirmTransactionActionListener)
    }, transactionJson);
    
##### *declinePushTransactionAction*
    Este método recibe 3 parámetros, los dos primeros son callbacks de respuestas y el último es un objeto TransactionInfo.
##### Método expuesto
    declinePushTransactionAction : function(success, fail, transactionJson)
##### Implementación 
    DetectIDCordovaPlugin.declinePushTransactionAction(function(successDeclineTransactionActionListener) {
        console.log("successDeclineTransactionActionListener", successDeclineTransactionActionListener);
    }, function(failDeclineTransactionActionListener) {
        console.log("failDeclineTransactionActionListener", failDeclineTransactionActionListener)
    }, transactionJson);
    
##### *setPushAuthenticationResponseAdditionalInfo*
##### Método expuesto 
    setPushAuthenticationResponseAdditionalInfo : function(success, fail, additionalInfoJson)
##### Implementación 
    var mappAdditionalInfo = {
        "MAP": "VALUE",
        "MAP2": "VALUE2",
        "MAP3": "VALUE3",
        "MAP4": "VALUE4"
    }
    
    DetectIDCordovaPlugin.setPushAuthenticationResponseAdditionalInfo(function(successSettingAdditionalInfo) {
        console.log("successSettingAdditionalInfo", successSettingAdditionalInfo);
    }, function(failSettingAdditionalInfo) {
        console.log("failSettingAdditionalInfo", failSettingAdditionalInfo)
    }, mappAdditionalInfo);
        
##### *setPushAlertViewProperties*
    Este método recibe 2 parámetros los cuales son 2 callbacks de respuesta y un objeto alertViewProperties.
##### Método expuesto 
    setPushAlertViewProperties  : function (success, fail);
##### Implementación 
    var alertViewProperties = {
        "APPROVE": "Aprobar"
    }
    DetectIDCordovaPlugin.setPushAlertViewProperties (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }, alertViewProperties);
        
##### *setPushAlertReceiveListener*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    setPushAlertReceiveListener  : function (success, fail);
##### Implementación 
    DetectIDCordovaPlugin.setPushAlertReceiveListener (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        });
        
##### *setPushAlertOpenListener*
    Este método recibe 2 parámetros los cuales son callbacks de respuesta.
##### Método expuesto 
    setPushAlertOpenListener  : function (success, fail);
##### Implementación 
    DetectIDCordovaPlugin.setPushAlertOpenListener (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        });
        
##### *approvePushAlert*
    Este método recibe 2 parámetros los cuales son 2 callbacks de respuesta y un objeto transactionJson.
##### Método expuesto 
    approvePushAlert  : function (success, fail);
##### Implementación 
    var transactionJson = {
        ...
    }
    DetectIDCordovaPlugin.approvePushAlert (
        function(success) {
            console.log("onSuccess", success);
        },
        function(error) {
            console.log("onError", error);
        }, transactionJson);
        

## Author
DID SDK, didsdk-admin@cyxtera.com
## License
Cyxtera
