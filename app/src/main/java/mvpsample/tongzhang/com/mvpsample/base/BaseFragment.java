package mvpsample.tongzhang.com.mvpsample.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView{
    protected T mPresenter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }
    protected abstract void initPresenter();

    @Override
    public void showNetWaitingDialog() {
        showDialog();
    }

    @Override
    public void dismissNetWaitingDialog() {
        cancelDialog();
    }

    @Override
    public void showErrorMessage(String msg) {
        cancelDialog();
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
