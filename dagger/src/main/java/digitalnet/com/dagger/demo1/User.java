package digitalnet.com.dagger.demo1;


import javax.inject.Inject;

/**

 * 创建时间：2018/10/25 16:42  星期四
 * 类描述 ： This is  User
 * </p>
 **/
public class User {

      public String name;
      /**
       * 用@Inject标记的构造函数如果有参数，那么这个参数也需要其它地方提供依赖。
       * 但是@Inject有一个缺陷，就是对于第三方的类无能为力。因为我们不能修改第三方的构造函数，
       * 所以对于String还有其他的一些我们不能修改的类，只能用@Module中的@Provides来提供实例了
       */
//      @Inject  //错误: Types may only contain one @Inject constructor.
//      public User(String name) {
//            this.name = name;
//      }

      @Inject
      public User() {
            name="曾红永";
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }
}
