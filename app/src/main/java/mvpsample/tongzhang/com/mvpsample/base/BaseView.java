package mvpsample.tongzhang.com.mvpsample.base;

public interface BaseView {
    void showNetWaitingDialog();
    void dismissNetWaitingDialog();
    void showErrorMessage(String mes);
}
