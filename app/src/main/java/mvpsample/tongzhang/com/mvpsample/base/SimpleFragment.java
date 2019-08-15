package mvpsample.tongzhang.com.mvpsample.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.widget.WaitingDialog;

public abstract class SimpleFragment extends SupportFragment {
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    protected boolean isInited = false;
    private boolean noAnimation;
    protected WaitingDialog waitingDialog;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        initDialog();
        super.onAttach(context);
    }

    private void initDialog() {
        waitingDialog = new WaitingDialog.Builder(mContext).setMessage("正在加载..").setCancelable(false).create();
    }

    protected void showDialog(){
        waitingDialog.show();
    }

    protected void cancelDialog(){
        waitingDialog.dismiss();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(),null);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this,view);
    }
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        isInited = true;
        initEventAndData();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if(!noAnimation) {
            getActivity().overridePendingTransition(R.anim.anim_in_right, R.anim.anim_out_left);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(!noAnimation) {
            getActivity().overridePendingTransition(R.anim.anim_in_right, R.anim.anim_out_left);
        }
    }

    protected abstract int getLayoutId();
    protected abstract void initEventAndData();

    public void setNoAnimation(boolean noAnimation) {
        this.noAnimation = noAnimation;
    }
}
