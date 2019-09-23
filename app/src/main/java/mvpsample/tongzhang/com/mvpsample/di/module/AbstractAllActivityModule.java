package mvpsample.tongzhang.com.mvpsample.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mvpsample.tongzhang.com.mvpsample.di.component.BaseActivityComponent;
import mvpsample.tongzhang.com.mvpsample.ui.MainActivity;
import mvpsample.tongzhang.com.mvpsample.ui.login.activity.LoginActivity;
import mvpsample.tongzhang.com.mvpsample.ui.login.activity.RegisterActivity;

@Module(subcomponents = BaseActivityComponent.class)
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributesLoginActivityInject();

    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity contributesRegisterActivityInject();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInject();
}
