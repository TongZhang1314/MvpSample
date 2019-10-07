package mvpsample.tongzhang.com.mvpsample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.netobserver.annotation.NetWork;
import com.example.netobserver.type.NetType;

import java.util.Objects;

import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.MainContract;
import mvpsample.tongzhang.com.mvpsample.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {


    @Override
    protected void initPresentet() {
        Log.i("zt", "initPresentet: ");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {


    }

    @NetWork(netType = NetType.WIFI)
    public void testNetWork(NetType netType){
        switch (netType){
            case WIFI:
                Toast.makeText(this,"当前网络切换至wifi",Toast.LENGTH_SHORT).show();
                break;
            case NONE:
                Toast.makeText(this,"当前网络切换至none",Toast.LENGTH_SHORT).show();
                break;
            case CMWAP:
                Toast.makeText(this,"当前网络切换至流量",Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
