package mvpsample.tongzhang.com.mvpsample.base.contract;

import mvpsample.tongzhang.com.mvpsample.base.BasePresenter;
import mvpsample.tongzhang.com.mvpsample.base.BaseView;

public interface LoginContract {
    interface View extends BaseView {
        void loginSuccess();

        void loginFail();
    }

    interface Presenter extends BasePresenter<LoginContract.View> {
        void login(String account, String password);
    }
}
