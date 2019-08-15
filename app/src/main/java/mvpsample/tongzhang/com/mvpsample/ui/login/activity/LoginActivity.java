package mvpsample.tongzhang.com.mvpsample.ui.login.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.contract.LoginContract;
import mvpsample.tongzhang.com.mvpsample.presenter.LoginPresenter;
import mvpsample.tongzhang.com.mvpsample.ui.MainActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;


    @OnClick(R.id.tv_register)
    void goRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @OnClick(R.id.btn_login)
    void goLogin() {
        if (etAccount.getText().toString().isEmpty()) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
        } else if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
        }else {
            mPresenter.login(etAccount.getText().toString(),etPassword.getText().toString());
        }
    }

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
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void loginFail() {

    }
}
