package digitalnet.com.dagger.demo5;

import javax.inject.Inject;

/**

 * 创建时间：2018/10/25 17:55  星期四
 * 类描述 ： This is  SingletonBean
 * </p>
 **/
public class SingletonBean {
      private String name;
      @Inject
      public SingletonBean(String name) {
            this.name = name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getName() {
            return name;
      }
}
