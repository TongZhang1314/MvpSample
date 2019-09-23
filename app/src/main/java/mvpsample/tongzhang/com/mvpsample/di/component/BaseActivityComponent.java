package mvpsample.tongzhang.com.mvpsample.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import mvpsample.tongzhang.com.mvpsample.base.BaseActivity;

@Subcomponent(modules = AndroidInjectionModule.class)
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {

    @Subcomponent.Builder
    abstract class BaseBuilder extends Builder<BaseActivity>{

    }
}
