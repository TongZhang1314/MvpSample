package mvpsample.tongzhang.com.mvpsample.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mvpsample.tongzhang.com.mvpsample.di.component.BaseFragmentComponent;
import mvpsample.tongzhang.com.mvpsample.ui.home.fragment.HomeFragment;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {

    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment contributesHomeFragmentInject();
}
