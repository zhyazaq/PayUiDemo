package digitalnet.com.dagger.demo3;

import dagger.Component;

/**

 * 创建时间：2018/10/25 17:21  星期四
 * 类描述 ： This is  PriorityComponet
 * </p>
 **/
@Component(modules = DataModule.class)
public interface PriorityComponet {
      void inject(PriorityTestActivity  priorityTestActivity);
}
