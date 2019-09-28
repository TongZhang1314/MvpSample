package mvpsample.tongzhang.com.mvpsample.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mvpsample.tongzhang.com.mvpsample.core.http.api.WanAndroidApi;
import mvpsample.tongzhang.com.mvpsample.di.qualifier.WanAndroidUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Provides
    @Singleton
    WanAndroidApi provideWanAndroidApi(@WanAndroidUrl Retrofit retrofit){
        return retrofit.create(WanAndroidApi.class);
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    @WanAndroidUrl
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client,WanAndroidApi.HOST);
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder){
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);

        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }



    Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client,String url){
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
