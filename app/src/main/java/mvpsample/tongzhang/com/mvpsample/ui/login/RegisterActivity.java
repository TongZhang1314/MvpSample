package mvpsample.tongzhang.com.mvpsample.ui.login;

import android.widget.EditText;

import butterknife.BindView;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;
import mvpsample.tongzhang.com.mvpsample.base.contract.RegisterContract;

public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements RegisterContract.View {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_repassword)
    EditText etRePassword;

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
    public void registerSuccess() {

    }

    @Override
    public void registerFail() {

    }
}
