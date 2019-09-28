package mvpsample.tongzhang.com.mvpsample.utils;

import io.reactivex.observers.ResourceObserver;
import mvpsample.tongzhang.com.mvpsample.base.BaseView;
import mvpsample.tongzhang.com.mvpsample.core.bean.BaseResponse;


/**
 * @author quchao
 * @date 2017/11/27
 *
 * @param <T>
 */

public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseObserver(BaseView view){
        this.mView = view;
    }

    protected BaseObserver(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(BaseView view, boolean isShowError){
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseObserver(BaseView view, String errorMsg, boolean isShowError){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
//        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
//            mView.showErrorMsg(mErrorMsg);
//        } else if (e instanceof ServerException) {
//            mView.showErrorMsg(e.toString());
//        } else if (e instanceof HttpException) {
//                mView.showErrorMsg(WanAndroidApp.getInstance().getString(R.string.http_error));
//        } else {
//            mView.showErrorMsg(WanAndroidApp.getInstance().getString(R.string.unKnown_error));
//            LogHelper.d(e.toString());
//        }
//        if (isShowError) {
//            mView.showError();
//        }
    }
}
