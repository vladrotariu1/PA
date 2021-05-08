package com.lab10.Commands.CommunicationObjects;

import java.io.Serializable;

public class Response implements Serializable {
    private String message;
    private Cookie cookie;

    public Response(String message, Cookie cookie) {
        this.message = message;
        this.cookie = cookie;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
}
