package mvpsample.tongzhang.com.mvpsample.ui.home.fragment;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import mvpsample.tongzhang.com.mvpsample.R;
import mvpsample.tongzhang.com.mvpsample.base.BaseFragment;
import mvpsample.tongzhang.com.mvpsample.base.contract.home.HomeContract;

public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {
    @BindView(R.id.srl_main)
    SmartRefreshLayout srlMain;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {

    }
}
