package mvpsample.tongzhang.com.mvpsample.presenter;

import android.util.Log;

import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.RegisterContract;
import mvpsample.tongzhang.com.mvpsample.model.NetModel;
import mvpsample.tongzhang.com.mvpsample.model.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.model.bean.login.UserData;
import mvpsample.tongzhang.com.mvpsample.utils.BaseObserver;
import mvpsample.tongzhang.com.mvpsample.utils.RxUtils;

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {
    private NetModel netModel;

    public RegisterPresenter(RegisterContract.View view) {
        mView = view;
        netModel = NetModel.getInstance();
    }

    @Override
    public void register(String account, String password, String repassword) {
        addSubscribe(netModel.register(account, password, repassword)
                .compose(RxUtils.rxSchedulerHelper())
//                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<BaseResponse>(mView) {
                    @Override
                    public void onNext(BaseResponse userData) {
                        if (userData.getErrorCode() == -1){
                            mView.showErrorMessage(userData.getErrorMsg());
                            mView.registerFail();
                        }else {
                            mView.registerSuccess();
                        }
                    }
                }));
    }
}
