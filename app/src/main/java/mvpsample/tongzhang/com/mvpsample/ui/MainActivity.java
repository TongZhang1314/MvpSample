package mvpsample.tongzhang.com.mvpsample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;

import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.MainContract;
import mvpsample.tongzhang.com.mvpsample.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @Override
    protected void initPresentet() {

    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }



    @Override
    public void loginSuccess() {

    }
}