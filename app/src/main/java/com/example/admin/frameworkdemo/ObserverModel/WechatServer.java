package com.example.admin.frameworkdemo.ObserverModel;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observable {
    List<Observer> list;
    String msg;
    public WechatServer() {
        this.list = new ArrayList<>();
    }


    @Override
    public void notifyObserver() {
        for(int i=0; i<list.size(); i++){
            Observer observer = list.get(i);
            observer.update(msg);
        }
    }

    @Override
    public void remove(Observer o) {
        if(list != null){
            list.remove(o);
        }
    }

    @Override
    public void register(Observer o) {
        list.add(o);
    }

    public void setInfo(String msg){
        this.msg = msg;
        notifyObserver();
    }
}
