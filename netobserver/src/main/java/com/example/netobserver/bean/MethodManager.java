package com.example.netobserver.bean;

import com.example.netobserver.type.NetType;

import java.lang.reflect.Method;

public class MethodManager {
    //参数类型  NetType
    private Class<?> type;

    //网络类型  netType = NetType.AUTO
    private NetType netType;

    //需要执行的方法
    private Method method;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public NetType getNetType() {
        return netType;
    }

    public void setNetType(NetType netType) {
        this.netType = netType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
