package com.example.admin.frameworkdemo.communication;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CommunicationEvent {
    public static final int CONNECTING = 0;
    public static final int CONNECTED = 16;
    public static final int SENDING = 1;
    public static final int SENDED = 17;
    public static final int RECEIVEING = 2;
    public static final int RECEIVED = 18;
    private int communicationType;
    private byte[] data;
    private CommunicationException exception;

    public CommunicationEvent(int communicationType, byte[] data, CommunicationException exception) {
        this.communicationType = communicationType;
        this.data = data;
        this.exception = exception;
    }

    public CommunicationEvent(int communicationType, byte[] data) {
        this.communicationType = communicationType;
        this.data = data;
    }

    public CommunicationEvent(int communicationType) {
        this.communicationType = communicationType;
    }

    public CommunicationEvent(int communicationType, CommunicationException exception) {
        this.communicationType = communicationType;
        this.exception = exception;
    }

    public int getCommunicationType() {
        return this.communicationType;
    }

    public byte[] getData() {
        return this.data;
    }

    public CommunicationException getException() {
        return this.exception;
    }

    public static boolean shouldFilterEvent(int communicationType) {
        return communicationType == 0 || communicationType == 16 || communicationType == 1 || communicationType == 17 || communicationType == 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
