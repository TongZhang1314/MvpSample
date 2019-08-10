package mvpsample.tongzhang.com.mvpsample.model.http.api;

import io.reactivex.Observable;
import mvpsample.tongzhang.com.mvpsample.model.bean.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 登陆数据
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse> getLoginData(@Field("username") String username, @Field("password") String password);

    /**
     * 注册 https://www.wanandroid.com/user/register
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("/user/register")
    Observable<BaseResponse> getRegisterData(@Query("username") String username,@Query("password")String password,@Query("repassword")String repassword);
}
