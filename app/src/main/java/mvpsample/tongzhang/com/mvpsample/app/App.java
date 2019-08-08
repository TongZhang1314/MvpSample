package mvpsample.tongzhang.com.mvpsample.app;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;


import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.Stack;

public class App extends Application {
    private static App instance;
    private Stack<Activity> activities;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //全局设置默认的 Header
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context));
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context).setDrawableSize(20));
    }

    public void addActivity(Activity act) {
        if (activities == null)
            activities = new Stack<>();
        activities.add(act);
    }

    public void removeTop() {
        activities.pop();
    }

    public Activity getStackTopActivity() {
        return activities.peek();
    }

}
