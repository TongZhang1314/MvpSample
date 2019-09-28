package mvpsample.tongzhang.com.mvpsample.core;

import io.reactivex.Observable;
import mvpsample.tongzhang.com.mvpsample.core.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.core.http.RetrofitCreateHelper;
import mvpsample.tongzhang.com.mvpsample.core.http.api.WanAndroidApi;

public class NetModel {
    private static NetModel instance;
    private WanAndroidApi api;
    private NetModel() {
        api = RetrofitCreateHelper.createApi(WanAndroidApi.class, WanAndroidApi.HOST);
    }

    public static NetModel getInstance() {
        if (instance == null)
            synchronized (NetModel.class) {
                if (instance == null)
                    instance = new NetModel();
            }
        return instance;
    }

    public Observable<BaseResponse> login(String account,String password){
        return api.getLoginData(account,password);
    }

    public Observable<BaseResponse> register(String account, String password, String repassword){
        return api.getRegisterData(account,password,repassword);
    }
}
