package digitalnet.com.dagger.demo2;

import dagger.Module;
import dagger.Provides;

/**

 * 创建时间：2018/10/25 17:02  星期四
 * 类描述 ： This is  PersonModule
 * </p>
 **/

@Module
public class PersonModule {
      @Provides
      Person providePerson() {//没有参数的方法可以用create直接创建注入
            return new Person();
      }
}
