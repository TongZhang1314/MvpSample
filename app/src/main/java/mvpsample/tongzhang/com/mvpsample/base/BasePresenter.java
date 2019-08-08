package mvpsample.tongzhang.com.mvpsample.base;

public  interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
