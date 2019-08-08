package mvpsample.tongzhang.com.mvpsample.base.contract;

import mvpsample.tongzhang.com.mvpsample.base.BasePresenter;
import mvpsample.tongzhang.com.mvpsample.base.BaseView;

public interface MainContract {
    interface View extends BaseView{

    }
    interface Presenter extends BasePresenter<MainContract.View>{
        void login();
    }
}
