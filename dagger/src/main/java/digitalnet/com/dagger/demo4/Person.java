package digitalnet.com.dagger.demo4;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 16:57  星期四
 * 类描述 ： This is  Person
 * </p>
 **/
public class Person {
      private String name;

      public Person() {
            this.name="太监总管";
      }

      public Person(String name) {
            this.name = name;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }
}
