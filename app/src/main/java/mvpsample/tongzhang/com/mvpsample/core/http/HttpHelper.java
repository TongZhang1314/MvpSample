package mvpsample.tongzhang.com.mvpsample.core.http;

import io.reactivex.Observable;
import mvpsample.tongzhang.com.mvpsample.core.bean.BaseResponse;

public interface HttpHelper {


    Observable<BaseResponse> login(String account, String password);

    Observable<BaseResponse> register(String account, String password, String repassword);
}
