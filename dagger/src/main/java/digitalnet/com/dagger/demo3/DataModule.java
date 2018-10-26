package digitalnet.com.dagger.demo3;

import dagger.Module;
import dagger.Provides;

/**

 * 创建时间：2018/10/25 17:19  星期四
 * 类描述 ： This is  DataModule
 * </p>
 **/
@Module
public class DataModule {
      @Provides
      priorityBean providePriority(){
            return new priorityBean("我是module提供的对象");
      }
}
