package digitalnet.com.dagger.demo3;

import dagger.Module;
import dagger.Provides;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 17:19  星期四
 * 类描述 ： This is  DataModule
 * </p>
 **/
@Module
public class DataModule {
      @Provides
      priorityBean providePriority(){
            return new priorityBean("我是module提供的对象");
      }
}
