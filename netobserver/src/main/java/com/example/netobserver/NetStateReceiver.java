package com.example.netobserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.netobserver.annotation.NetWork;
import com.example.netobserver.bean.MethodManager;
import com.example.netobserver.type.NetType;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetStateReceiver extends BroadcastReceiver {
    private NetType netType;
    private Map<Object, List<MethodManager>> networkList;

    public NetStateReceiver() {
        netType = NetType.NONE;
        networkList = new HashMap<>();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

    }

    public void registerObserver(Object object) {
        List<MethodManager> managerList = networkList.get(object);
        if (managerList == null) { //不为空 则存在
            managerList = findAnnotationMethod(object);
        }
    }

    private List<MethodManager> findAnnotationMethod(Object register) {
        List<MethodManager> methodList = new ArrayList<>();
        Class<?> clazz = register.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            //获取方法的注解
            NetWork netWork = method.getAnnotation(NetWork.class);
            if (netWork == null){
                continue;
            }
            //方法返回值校验
            Type type = method.getGenericReturnType();
            if (!"void".equalsIgnoreCase(type.toString())){
                throw new RuntimeException(method.getName()+"方法返回值必须为空");
            }
            //方法参数校验
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length!=1){
                throw new RuntimeException(method.getName()+"方法有且只有一个属性");
            }
            MethodManager methodManager = new MethodManager();
            methodManager.setType(parameterTypes[0]);
            methodManager.setNetType(netWork.netType());
            methodManager.setMethod(method);
            methodList.add(methodManager);
        }
        return methodList;
    }
}
