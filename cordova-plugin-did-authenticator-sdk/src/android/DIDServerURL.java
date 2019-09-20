package net.easysol.did.DetectIDCordovaPlugin;

import java.util.regex.Pattern;

/**
 * Created by John Garcia on 28/05/2018.
 */

public class DIDServerURL {

    private final String serverURL;
    private static final String regexUrlServer = "^(http:\\/\\/|https:\\/\\/)((([0-9]{1,3}).){3}(([0-9]{1,3}))|(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?)(:[0-9]{2,4})?(\\/detect\\/public\\/registration\\/mobileServices.htm\\?code=)([0-9]{0,6})?";
    private static final Pattern patternServerUrl = Pattern.compile(regexUrlServer);

    /**
     * Private constructor
     *
     * @param serverURL serverUrl
     */
    private DIDServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    /**
     * Method to get instance of DIDServerURL
     *
     * @param serverURL serverUrl client
     * @return DIDServerUrl
     */
    public static DIDServerURL getInstance(String serverURL) {
        validateServerURL(serverURL);
        return new DIDServerURL(serverURL);
    }

    /**
     * Public method to get server Url
     *
     * @return serverUrl
     */
    public String getServerURL() {
        return serverURL;
    }

    /**
     * Method to validate server url
     *
     * @param url client url
     */
    private static void validateServerURL(String url) {
        if (!patternServerUrl.matcher(url).matches()) {
            throw new IllegalArgumentException("Invalid Server Url");
        }
    }

}
