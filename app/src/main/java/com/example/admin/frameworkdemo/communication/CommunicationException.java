//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.admin.frameworkdemo.communication;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CommunicationException extends Exception {
    public static final int CONNECT_FAILED = 32;
    public static final int SEND_FAILED = 33;
    public static final int RECEIVE_FAILED = 34;
    private int type;

    public CommunicationException() {
    }

    public CommunicationException(String message) {
        super(message);
    }

    public CommunicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunicationException(String message, Throwable cause, int type) {
        super(message, cause);
        this.type = type;
    }

    public CommunicationException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public int getType() {
        return this.type;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
