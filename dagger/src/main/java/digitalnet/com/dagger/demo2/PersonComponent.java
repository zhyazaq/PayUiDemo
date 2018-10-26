package digitalnet.com.dagger.demo2;

import dagger.Component;

/**

 * 创建时间：2018/10/25 17:04  星期四
 * 类描述 ： This is  PersonComponent
 * </p>
 **/

/*****
 * 必须有modules 告诉我们component想要的类型以及实例是谁
 */
@Component(modules = PersonModule.class)
public interface PersonComponent {

      void inject(Demo2Activity demo2Activity);
}
