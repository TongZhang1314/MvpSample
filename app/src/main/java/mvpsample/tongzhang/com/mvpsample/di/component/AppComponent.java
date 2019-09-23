package mvpsample.tongzhang.com.mvpsample.di.component;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import mvpsample.tongzhang.com.mvpsample.di.module.AbstractAllActivityModule;
import mvpsample.tongzhang.com.mvpsample.di.module.AbstractAllFragmentModule;

@Singleton
@Component( modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class,
        AbstractAllFragmentModule.class, AbstractAllActivityModule.class,
        })
public interface AppComponent {

}
