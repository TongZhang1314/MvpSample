package mvpsample.tongzhang.com.mvpsample.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mvpsample.tongzhang.com.mvpsample.app.MvpSampleApp;
import mvpsample.tongzhang.com.mvpsample.core.DataManager;
import mvpsample.tongzhang.com.mvpsample.core.db.DbHelper;
import mvpsample.tongzhang.com.mvpsample.core.db.DbHelperImpl;
import mvpsample.tongzhang.com.mvpsample.core.http.HttpHelper;
import mvpsample.tongzhang.com.mvpsample.core.http.HttpHelperImpl;
import mvpsample.tongzhang.com.mvpsample.core.prefs.PreferenceHelper;
import mvpsample.tongzhang.com.mvpsample.core.prefs.PreferenceHelperImpl;

@Module
public class AppModule {
    private MvpSampleApp application;

    public AppModule(MvpSampleApp application) {
        this.application = application;
    }
    @Provides
    @Singleton
    MvpSampleApp provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl){
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl dbHelperImpl){
        return dbHelperImpl;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl helper){
        return helper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DbHelper dbHelper,HttpHelper httpHelper,PreferenceHelper preferenceHelper){
        return new DataManager(dbHelper,httpHelper,preferenceHelper);
    }



}
