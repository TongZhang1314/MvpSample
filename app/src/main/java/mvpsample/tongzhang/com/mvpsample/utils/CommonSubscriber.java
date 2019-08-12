package mvpsample.tongzhang.com.mvpsample.utils;

import android.util.Log;

import io.reactivex.subscribers.ResourceSubscriber;
import mvpsample.tongzhang.com.mvpsample.base.BaseView;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseView view){
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        Log.i("zt", "onError: "+e.getCause());
        Log.i("zt", "onError: "+e.getMessage());
        Log.i("zt", "onError: "+e.getLocalizedMessage());
        Log.i("zt", "onError: "+e.getStackTrace());
        Log.i("zt", "onError: "+e.getSuppressed());
    }

}
