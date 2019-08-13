package mvpsample.tongzhang.com.mvpsample.ui.login;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.contract.RegisterContract;
import mvpsample.tongzhang.com.mvpsample.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements RegisterContract.View {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_repassword)
    EditText etRePassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @OnClick(R.id.btn_register)
    void register() {
        if (etAccount.getText().toString().isEmpty()) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
        } else if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
        } else if (etRePassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show();
        } else {
            mPresenter.register(etAccount.getText().toString(),
                    etPassword.getText().toString(),
                    etRePassword.getText().toString());
        }
    }

    @Override
    protected void initPresentet() {
        mPresenter = new RegisterPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void registerSuccess() {
        finish();
    }

    @Override
    public void registerFail() {

    }
}
