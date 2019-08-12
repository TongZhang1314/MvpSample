package mvpsample.tongzhang.com.mvpsample.ui.login;

import android.util.ArraySet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.contract.LoginContract;
import mvpsample.tongzhang.com.mvpsample.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    @Override
    protected void initPresentet() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
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
