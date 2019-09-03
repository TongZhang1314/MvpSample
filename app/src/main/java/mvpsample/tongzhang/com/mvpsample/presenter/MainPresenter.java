package mvpsample.tongzhang.com.mvpsample.presenter;

import mvpsample.tongzhang.com.mvpsample.base.RxPresenter;
import mvpsample.tongzhang.com.mvpsample.base.contract.MainContract;
import mvpsample.tongzhang.com.mvpsample.model.NetModel;

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private NetModel netModel;

    public MainPresenter(MainContract.View view) {
        mView = view;
        this.netModel = NetModel.getInstance();
    }

    @Override
    public void login() {

    }

    @Override
    public void getBanner() {

    }

    @Override
    public void getDataList() {

    }
}
