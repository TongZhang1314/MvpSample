package mvpsample.tongzhang.com.mvpsample.core.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import mvpsample.tongzhang.com.mvpsample.app.Constant;
import mvpsample.tongzhang.com.mvpsample.app.MvpSampleApp;

public class PreferenceHelperImpl implements PreferenceHelper {
    private SharedPreferences mPrefers;

    @Inject
    public PreferenceHelperImpl() {
        this.mPrefers = MvpSampleApp.getInstance().getSharedPreferences(Constant.MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginAccount(String account) {
        mPrefers.edit().putString(Constant.ACCOUNT,account).apply();
    }



    @Override
    public void setLoginPassword(String password) {
        mPrefers.edit().putString(Constant.PASSWORD,password).apply();
    }

    @Override
    public String getLoginAccount() {
        return mPrefers.getString(Constant.ACCOUNT,"");
    }

    @Override
    public String getLoginPassword() {
        return mPrefers.getString(Constant.PASSWORD,"");
    }
}
