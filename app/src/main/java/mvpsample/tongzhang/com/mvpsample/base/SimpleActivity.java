package mvpsample.tongzhang.com.mvpsample.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.app.MvpSampleApp;
import mvpsample.tongzhang.com.mvpsample.widget.WaitingDialog;

public abstract class SimpleActivity extends SupportActivity {
    private Unbinder mUnBinder;
    private Activity mContext;
    //等待框
    private WaitingDialog waitingDialog;
    //默认无动画
    private boolean noAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        onViewCreated();
        MvpSampleApp.getInstance().addActivity(this);
        whiteTheme();
        initEventAndData();
        initDialog();

    }
    private void initDialog() {
        waitingDialog = new WaitingDialog.Builder(mContext).setMessage("正在加载..").setCancelable(false).setCancelOutside(false).create();
    }

    protected void showDialog(){
        waitingDialog.show();
    }

    protected void cancelDialog(){
        waitingDialog.dismiss();
    }

    protected void whiteTheme(){
        customTheme(ContextCompat.getColor(this, R.color.white));
    }

    /**
     * 自定义状态栏颜色
     * @param color  颜色值
     */
    protected void customTheme(int color) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(color);
        }else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(color);
        }
    }
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if(!noAnimation) {
            overridePendingTransition(R.anim.anim_in_right, R.anim.anim_out_left);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(!noAnimation) {
            overridePendingTransition(R.anim.anim_in_right, R.anim.anim_out_left);
        }
    }

    @Override
    public void finish() {
        super.finish();
        if(!noAnimation) {
            overridePendingTransition(R.anim.anim_in_left, R.anim.anim_out_right);
        }
    }

    public void setNoAnimation(boolean noAnimation) {
        this.noAnimation = noAnimation;
    }



    protected abstract int getLayout();
    protected abstract void initEventAndData();
    protected abstract void onViewCreated();
}
