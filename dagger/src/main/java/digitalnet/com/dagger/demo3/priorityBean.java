package digitalnet.com.dagger.demo3;

import javax.inject.Inject;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 17:17  星期四
 * 类描述 ： This is  priorityBean
 * </p>
 **/
public class priorityBean  {
      private String name;

      @Inject
      public priorityBean() {
            this.name="我是@inject注解的对象";
      }

      public priorityBean(String name) {
            this.name = name;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }
}
