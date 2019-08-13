package mvpsample.tongzhang.com.mvpsample.presenter;

import android.util.Log;

import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.LoginContract;
import mvpsample.tongzhang.com.mvpsample.model.NetModel;
import mvpsample.tongzhang.com.mvpsample.model.bean.BaseResponse;
import mvpsample.tongzhang.com.mvpsample.utils.BaseObserver;
import mvpsample.tongzhang.com.mvpsample.utils.RxUtils;

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {
    private NetModel netModel;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        netModel = NetModel.getInstance();
    }

    @Override
    public void login(String account, String password) {
        addSubscribe(netModel.login(account, password)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObserver<BaseResponse>(mView) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        if (baseResponse.getErrorCode() == -1){
                            mView.showErrorMessage(baseResponse.getErrorMsg());
                            mView.loginFail();
                        }else {
                            mView.loginSuccess();
                        }
                    }
                })
        );

    }
}
