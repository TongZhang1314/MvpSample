package mvpsample.tongzhang.com.mvpsample.core;

import io.reactivex.Observable;
import mvpsample.tongzhang.com.mvpsample.core.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.core.db.DbHelper;
import mvpsample.tongzhang.com.mvpsample.core.http.HttpHelper;
import mvpsample.tongzhang.com.mvpsample.core.prefs.PreferenceHelper;

public class DataManager implements DbHelper, HttpHelper, PreferenceHelper {
    private DbHelper mDbHelper;
    private HttpHelper mHttpHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(DbHelper mDbHelper, HttpHelper mHttpHelper, PreferenceHelper mPreferenceHelper) {
        this.mDbHelper = mDbHelper;
        this.mHttpHelper = mHttpHelper;
        this.mPreferenceHelper = mPreferenceHelper;
    }

    @Override
    public Observable<BaseResponse> login(String account, String password) {
        return mHttpHelper.login(account, password);
    }

    @Override
    public Observable<BaseResponse> register(String account, String password, String repassword) {
        return mHttpHelper.register(account, password, repassword);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferenceHelper.setLoginPassword(password);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPreferenceHelper.getLoginPassword();
    }
}
