package mvpsample.tongzhang.com.mvpsample.base;

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

}
