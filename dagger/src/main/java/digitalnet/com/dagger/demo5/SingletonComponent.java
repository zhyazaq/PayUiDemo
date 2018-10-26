package digitalnet.com.dagger.demo5;

import javax.inject.Singleton;

import dagger.Component;

/**

 * 创建时间：2018/10/25 17:58  星期四
 * 类描述 ： This is  SingletonComponent
 * </p>
 **/

/***
 * 注意当singleton 在module 使用了，component也必须使用，作用域要一样，否则会编译错误
 */
@Component(modules = DataModule.class)
@Singleton
public abstract class SingletonComponent {
      /**
       * /@Component不仅可以注解接口也可以注解抽象类，为了方便测试单例，把Component改为抽象类，
       * 实际开发中可以在Application中创建单例。
       */
      public abstract  void inject(SingletonTestActivity singletonTestActivity);

      private static  SingletonComponent sSingletonComponent;
      public static  SingletonComponent getInstance(){
            if (sSingletonComponent != null) {
                  sSingletonComponent=DaggerSingletonComponent.builder().build();
            }
            return  sSingletonComponent;
      }
}
