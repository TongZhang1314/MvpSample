package mvpsample.tongzhang.com.mvpsample.presenter;

import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.LoginContract;
import mvpsample.tongzhang.com.mvpsample.model.NetModel;

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {
    private NetModel netModel;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        netModel = NetModel.getInstance();
    }

    @Override
    public void login(String account,String password) {
//        addSubscribe(netModel.login(account,password));
        //test contribution
    }
}
