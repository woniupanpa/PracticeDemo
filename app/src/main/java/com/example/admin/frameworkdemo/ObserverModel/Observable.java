package com.example.admin.frameworkdemo.ObserverModel;

public interface Observable {
    public void register(Observer o);
    public void remove(Observer o);
    public void notifyObserver();

}
