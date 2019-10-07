package com.example.netobserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.netobserver.annotation.NetWork;
import com.example.netobserver.bean.MethodManager;
import com.example.netobserver.type.NetType;
import com.example.netobserver.utils.Constants;
import com.example.netobserver.utils.NetworkUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetStateReceiver extends BroadcastReceiver {
    private NetType netType;
    private Map<Object, List<MethodManager>> networkList;

    public NetStateReceiver() {
        netType = NetType.NONE;
        networkList = new HashMap<>();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            Log.e(Constants.LOG_TAG, "接收意图为空");
            return;
        }
        if (intent.getAction().equalsIgnoreCase(Constants.ANDROID_NET_CHANGE_ACTION)) {
            Log.e(Constants.LOG_TAG, "网络发生改变");
            netType = NetworkUtils.getNetType();
            if (NetworkUtils.isNetworkAvailable()) {
                Log.e(Constants.LOG_TAG, "网络连接成功");
            } else {
                Log.e(Constants.LOG_TAG, "网络连接失败");
            }
            //通知所有注册的方法，网络发生改变
            post(netType);
        }

    }

    private void post(NetType netType) {
        Set<Object> set = networkList.keySet();
        for (Object getter : set) {
            List<MethodManager> methodList = networkList.get(getter);
            if (methodList != null) {
                for (MethodManager manager : methodList) {
                    // public void network(Object netType) {错误的、不匹配的
                    if (manager.getType().isAssignableFrom(NetType.class)) {
                        switch (manager.getNetType()) {
                            case AUTO:
                                invoke(manager, getter, netType);
                                break;
                            case WIFI:
                                if (netType == NetType.WIFI || netType == NetType.NONE) {
                                    invoke(manager, getter, netType);
                                }
                                break;
                            case CMWAP:
                                if (netType == NetType.CMWAP || netType == NetType.NONE) {
                                    invoke(manager, getter, netType);
                                }
                                break;

                            case CMNET:
                                if (netType == NetType.CMNET || netType == NetType.NONE) {
                                    invoke(manager, getter, netType);
                                }
                                break;

                            default:
                                break;
                        }
                    }
                }
            }
        }

    }

    private void invoke(MethodManager method, Object getter, NetType netType) {
        Method execute = method.getMethod();
        try {
            execute.invoke(getter,netType);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void registerObserver(Object object) {
        List<MethodManager> managerList = networkList.get(object);
        if (managerList == null) { //不为空 则存在
            managerList = findAnnotationMethod(object);
            networkList.put(object, managerList);
        }
    }

    private List<MethodManager> findAnnotationMethod(Object register) {
        List<MethodManager> methodList = new ArrayList<>();
        Class<?> clazz = register.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //获取方法的注解
            NetWork netWork = method.getAnnotation(NetWork.class);
            if (netWork == null) {
                continue;
            }
            //方法返回值校验
            Type type = method.getGenericReturnType();
            if (!"void".equalsIgnoreCase(type.toString())) {
                throw new RuntimeException(method.getName() + "方法返回值必须为空");
            }
            //方法参数校验
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1) {
                throw new RuntimeException(method.getName() + "方法有且只有一个属性");
            }
            MethodManager methodManager = new MethodManager();
            methodManager.setType(parameterTypes[0]);
            methodManager.setNetType(netWork.netType());
            methodManager.setMethod(method);
            methodList.add(methodManager);
        }
        return methodList;
    }

    public void unRegisterObserver(Object object){
        if (networkList.get(object)!=null){
            networkList.remove(object);
        }
    }

    public void unRegisterAll() {
        if (!networkList.isEmpty()){
            networkList.clear();
        }
        NetworkManager.getDefault().getApplication().unregisterReceiver(this);
        networkList = null;
        Log.e(Constants.LOG_TAG, "注销网络监听成功");
    }
}
