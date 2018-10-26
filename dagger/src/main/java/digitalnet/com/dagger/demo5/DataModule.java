package digitalnet.com.dagger.demo5;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 17:56  星期四
 * 类描述 ： This is  DataModule
 * </p>
 **/
@Module
public class DataModule {
      @Provides
      @Singleton
      SingletonBean provideSingletonBean(){
            return new SingletonBean("测试单例");
      }
}
