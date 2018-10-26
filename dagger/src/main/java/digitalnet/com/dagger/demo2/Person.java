package digitalnet.com.dagger.demo2;

/**

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
