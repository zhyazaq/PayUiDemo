package digitalnet.com.dagger.demo5;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**

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
