package mvpsample.tongzhang.com.mvpsample.ui.login;

import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.contract.LoginContract;
import mvpsample.tongzhang.com.mvpsample.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
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

    @Override
    public void loginFail() {

    }
}
