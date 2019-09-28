package mvpsample.tongzhang.com.mvpsample.di.component;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import mvpsample.tongzhang.com.mvpsample.app.MvpSampleApp;
import mvpsample.tongzhang.com.mvpsample.core.DataManager;
import mvpsample.tongzhang.com.mvpsample.di.module.AbstractAllActivityModule;
import mvpsample.tongzhang.com.mvpsample.di.module.AbstractAllFragmentModule;
import mvpsample.tongzhang.com.mvpsample.di.module.AppModule;
import mvpsample.tongzhang.com.mvpsample.di.module.HttpModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllFragmentModule.class,
        AbstractAllActivityModule.class,
        AppModule.class,
        HttpModule.class
})
public interface AppComponent {
        void inject(MvpSampleApp app);

        MvpSampleApp getContext();

        DataManager getDataManager();
}
