package mvpsample.tongzhang.com.mvpsample.base.contract.home;

import mvpsample.tongzhang.com.mvpsample.base.BasePresenter;
import mvpsample.tongzhang.com.mvpsample.base.BaseView;

public interface HomeContract {
    interface View extends BaseView{

    }
    interface Presenter extends BasePresenter<HomeContract.View>{

    }
}
