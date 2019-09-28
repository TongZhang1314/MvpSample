package mvpsample.tongzhang.com.mvpsample.core.http;

import javax.inject.Inject;

import io.reactivex.Observable;

import mvpsample.tongzhang.com.mvpsample.core.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.core.http.api.WanAndroidApi;

public class HttpHelperImpl implements HttpHelper {

    private WanAndroidApi api;
    @Inject
    public HttpHelperImpl(WanAndroidApi api) {
        this.api = api;
    }

    @Override
    public Observable<BaseResponse> login(String account, String password) {
        return api.getLoginData(account,password);
    }

    @Override
    public Observable<BaseResponse> register(String account, String password, String repassword) {
        return api.getRegisterData(account, password, repassword);
    }
}
