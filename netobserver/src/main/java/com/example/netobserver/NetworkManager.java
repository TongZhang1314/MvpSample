package com.example.netobserver;

import android.app.Application;
import android.content.IntentFilter;

import com.example.netobserver.utils.Constants;

public class NetworkManager {
    private static NetworkManager instance;
    private NetStateReceiver receiver;
    private Application application;

    private NetworkManager(){
        receiver = new NetStateReceiver();
    }

    public static NetworkManager getDefault(){
        if (instance == null){
            synchronized (NetworkManager.class){
                if (instance == null){
                    instance = new NetworkManager();
                }
            }
        }
        return instance;
    }

    public Application getApplication(){
        if (application == null){
            throw new RuntimeException("application没有初始化");
        }
        return application;
    }

    public void init(Application app){
        this.application = app;
        IntentFilter intentFilter = new IntentFilter(Constants.ANDROID_NET_CHANGE_ACTION);
        application.registerReceiver(receiver,intentFilter);
    }
    public void registerObserver(Object object){
        receiver.registerObserver(object);
    }

    public void unRegisterObserver(Object object){
        receiver.unRegisterObserver(object);
    }
    public void unRegisterAll(){
        receiver.unRegisterAll();
    }
}
