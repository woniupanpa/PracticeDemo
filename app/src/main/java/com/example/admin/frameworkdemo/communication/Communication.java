

package com.example.admin.frameworkdemo.communication;

import io.reactivex.Observable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Communication {
    public static final int METHOD_TCP = 1;
    public static final int METHOD_HTTPS = 2;
    public static final int METHOD_HTTP = 3;
    protected int connectTimeout = 15;
    protected int receiveTimeout = 60;
    protected boolean sslEnabled;
    protected String certificateFile = "certificate/ca-cert.pem";
    protected String certificatePassword = "";
    protected boolean mutualAuthEnabled;
    protected String caFile;
    protected String privateKeyFile;
    protected String protocol = "TLSv1.2";

    protected final String FAIL_TO_RECEIVE_DATA = "Fail to receive data";
    protected final String FAIL_TO_CONNECT = "Fail to connect";
    protected final String OPERATION_NOT_SUPPORT = "Operation not support";

    public Communication() {
    }

    public abstract Observable<CommunicationEvent> connect();

    public abstract Observable<CommunicationEvent> send(byte[] var1);

    public abstract Observable<CommunicationEvent> receive();

    public abstract Observable<CommunicationEvent> receive(int var1);

    public abstract Observable<CommunicationEvent> sendAndReceive(byte[] var1);

    public abstract void disconnect();

    public String getCertificateFile() {
        return this.certificateFile;
    }

    public void setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
    }

    public boolean isMutualAuthEnabled() {
        return this.mutualAuthEnabled;
    }

    public void setMutualAuthEnabled(boolean mutualAuthEnabled) {
        this.mutualAuthEnabled = mutualAuthEnabled;
    }

    public String getCaFile() {
        return this.caFile;
    }

    public void setCaFile(String caFile) {
        this.caFile = caFile;
    }

    public String getPrivateKeyFile() {
        return this.privateKeyFile;
    }

    public void setPrivateKeyFile(String privateKeyFile) {
        this.privateKeyFile = privateKeyFile;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    public void setSslEnabled(boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }

    public String getCertificatePassword() {
        return this.certificatePassword;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommunicationMethod {
    }
}
