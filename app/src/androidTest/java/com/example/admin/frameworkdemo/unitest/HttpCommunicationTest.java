package com.example.admin.frameworkdemo.unitest;

import com.example.admin.frameworkdemo.BytesUtil;
import com.example.admin.frameworkdemo.communication.CommunicationEvent;
import com.example.admin.frameworkdemo.communication.HttpCommunication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import timber.log.Timber;

import static org.junit.Assert.*;

/**
 * @author yanjim
 * @Date 2021/5/6 19:23
 */
public class HttpCommunicationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void httpsClientTest2() {
        try {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            OkHttpClient client = builder.build();

            MediaType JSON = MediaType.parse("text/plain;charset=UTF-8");

            RequestBody body = RequestBody.create(JSON, "111222333444555666777888asdfasdfasdfasdfasdfasdfasdf");

            Request request = new Request.Builder()
                    .url("http://192.168.43.110:5555/")
                    .get()
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                Timber.i(response.body().string());
            } else {
                throw new IOException("Unexpected code " + response);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void httpsClientTest() {
        HttpCommunication httpCommunication = new HttpCommunication("https://192.168.43.110:5555", false, 15, 60);

        byte[] sendData = {0x31, 0x32, 0x33, 0x34, 0x35, 0x36};

        //String string = "city=yourcity&key=yourkey";
        String string = "111111111";

        httpCommunication.sendAndReceive(string.getBytes())
                .subscribe(communicationEvent -> {

                            Timber.i(praseCommunicationType(communicationEvent.getCommunicationType()));

                            switch (communicationEvent.getCommunicationType()) {
                                case CommunicationEvent.SENDING:
                                case CommunicationEvent.SENDED:
                                    Timber.e("send data:" + BytesUtil.bytes2HexString(communicationEvent.getData()));
                                    break;
                                case CommunicationEvent.RECEIVED:
                                    Timber.e("RECEIVED data:" + BytesUtil.bytes2HexString(communicationEvent.getData()));
                                    break;
                            }
                        }, throwable -> Timber.e("OnError:" + throwable.getMessage()),
                        () -> Timber.e("OnComplete"));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String praseCommunicationType(@CommunicationEvent.Type int type) {
        switch (type) {
            case CommunicationEvent.CONNECTING:
                return "CONNECTING";
            case CommunicationEvent.CONNECTED:
                return "CONNECTED";
            case CommunicationEvent.SENDING:
                return "SENDING";
            case CommunicationEvent.SENDED:
                return "SENDED";
            case CommunicationEvent.RECEIVEING:
                return "RECEIVEING";
            case CommunicationEvent.RECEIVED:
                return "RECEIVED";
        }

        return "unknown";
    }

}