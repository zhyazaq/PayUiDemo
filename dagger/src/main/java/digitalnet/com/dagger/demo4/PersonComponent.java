package digitalnet.com.dagger.demo4;

import dagger.Component;

/**

 * 创建时间：2018/10/25 17:38  星期四
 * 类描述 ： This is  PersonComponent
 * </p>
 **/
@Component(modules = DataModule.class)
public interface PersonComponent {
      void inject(QualifierAcitivity qualifierAcitivity);
}
