package mvpsample.tongzhang.com.mvpsample.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import mvpsample.tongzhang.com.mvpsample.base.BaseFragment;

@Subcomponent(modules = AndroidInjectionModule.class)
public interface BaseFragmentComponent extends AndroidInjector<BaseFragment> {

    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseFragment>{

    }
}
