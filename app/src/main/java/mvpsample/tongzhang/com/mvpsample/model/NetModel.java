package mvpsample.tongzhang.com.mvpsample.model;

import io.reactivex.Observable;
import mvpsample.tongzhang.com.mvpsample.model.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.model.http.RetrofitCreateHelper;
import mvpsample.tongzhang.com.mvpsample.model.http.api.Api;

public class NetModel {
    private static NetModel instance;
    private Api api;
    private NetModel() {
        api = RetrofitCreateHelper.createApi(Api.class, Api.HOST);
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
}
