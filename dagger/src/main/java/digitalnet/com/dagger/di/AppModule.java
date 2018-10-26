package digitalnet.com.dagger.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 19:00  星期四
 * 类描述 ： This is  AppModule
 * </p>
 **/

@Module
public class AppModule {
      private final  Application mApplication;

      public AppModule(Application application) {
            mApplication = application;
      }
      @Singleton
      @Provides
      Context getAppContext(){
            return  mApplication;
      }
}
