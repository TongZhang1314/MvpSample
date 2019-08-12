package mvpsample.tongzhang.com.mvpsample.base.contract;

import mvpsample.tongzhang.com.mvpsample.base.BasePresenter;
import mvpsample.tongzhang.com.mvpsample.base.BaseView;

public interface RegisterContract {
    interface View extends BaseView{
        void registerSuccess();
        void registerFail();
    }
    interface Presenter extends BasePresenter<RegisterContract.View>{
        void register(String account,String password,String repassword);
    }
}
