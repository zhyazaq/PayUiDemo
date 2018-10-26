package digitalnet.com.dagger.demo4;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**

 * 创建时间：2018/10/25 17:33  星期四
 * 类描述 ： This is  DataModule
 * </p>
 **/
@Module
public class DataModule {
      //一个默认的太监总管
      @Provides
      Person providePerson(){
            return new Person();
      }

      @Provides
      @Named("old")
      Person providePersonOld(){
            return new Person("老太监");
      }

      @Provides
      @Named("yong")
      Person providePersonYong(){
            return  new Person("小太监");
      }

      @Provides
      @PersonQualifier
      Person providePersonByQualifier(){
            return  new Person("qualifier 太监");
      }
}
