package mvpsample.tongzhang.com.mvpsample.presenter;

import android.util.Log;

import io.reactivex.functions.Function;
import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.RegisterContract;
import mvpsample.tongzhang.com.mvpsample.model.NetModel;
import mvpsample.tongzhang.com.mvpsample.model.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.utils.CommonSubscriber;
import mvpsample.tongzhang.com.mvpsample.utils.RxUtils;

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {
    private NetModel netModel;
    public RegisterPresenter(RegisterContract.View view) {
        mView = view;
        netModel = NetModel.getInstance();
    }

    @Override
    public void register(String account,String password,String repassword) {
        addSubscribe(netModel.register(account,password,repassword).subscribeWith(new CommonSubscriber<>(mView) {
            @Override
            public void onNext(Object o) {

            }
        }));
    }
}
