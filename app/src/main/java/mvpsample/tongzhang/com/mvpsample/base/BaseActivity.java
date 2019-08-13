package mvpsample.tongzhang.com.mvpsample.base;

import android.widget.Toast;

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView  {
    protected T mPresenter;

    @Override
    protected void onViewCreated() {
        initPresentet();
    }

    protected abstract void initPresentet();

    @Override
    public void showNetWaitingDialog() {
        showDialog();
    }

    @Override
    public void dismissNetWaitingDialog() {
        cancelDialog();
    }

    @Override
    public void showErrorMessage(String mes) {
        Toast.makeText(this,mes,Toast.LENGTH_SHORT).show();
    }
}
