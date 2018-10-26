package digitalnet.com.dagger.demo3;

import dagger.Component;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 17:21  星期四
 * 类描述 ： This is  PriorityComponet
 * </p>
 **/
@Component(modules = DataModule.class)
public interface PriorityComponet {
      void inject(PriorityTestActivity  priorityTestActivity);
}
