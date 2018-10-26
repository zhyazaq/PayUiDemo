package digitalnet.com.dagger.demo1;

import dagger.Component;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 16:45  星期四
 * 类描述 ： This is  OneCompone
 * </p>
 **/
@Component
public interface OneCompone {
      /**
       * 必须有个目标让Component知道需要往哪个类中注入
       * 这个方法名可以是其它的，但是推荐用inject
       * 目标类Demo1Activity必须精确，不能用它的父类
       * 这是Dagger2的机制决定的
       */
      void inject(Demo1Activity demo1Activity);
}
