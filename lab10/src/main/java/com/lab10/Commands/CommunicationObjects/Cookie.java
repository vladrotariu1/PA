package com.lab10.Commands.CommunicationObjects;

import java.io.Serializable;
import java.util.HashMap;

public class Cookie implements Serializable {
    private HashMap<String, String> cookieInfo = new HashMap<>();

    public Cookie() {}

    public Cookie(HashMap<String, String> cookieInfo) {
        this.cookieInfo = cookieInfo;
    }

    public HashMap<String, String> getCookieInfo() {
        return cookieInfo;
    }

    public void setCookieInfo(HashMap<String, String> cookieInfo) {
        this.cookieInfo = cookieInfo;
    }

    public void addInfo(String key, String value) {
        cookieInfo.put(key, value);
    }

    public int loggedUserId() {
        if (cookieInfo.get("logged") == null)
            return -1;
        else
            return Integer.parseInt(cookieInfo.get("logged"));
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "cookieInfo=" + cookieInfo +
                '}';
    }
}
