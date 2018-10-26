package digitalnet.com.dagger.demo2;

import dagger.Module;
import dagger.Provides;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 17:02  星期四
 * 类描述 ： This is  PersonModule
 * </p>
 **/

@Module
public class PersonModule {
      @Provides
      Person providePerson() {//没有参数的方法可以用create直接创建注入
            return new Person();
      }
}
