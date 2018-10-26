package digitalnet.com.dagger.demo4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**

 * 创建时间：2018/10/25 17:33  星期四
 * 类描述 ： This is  PersonQualifier
 * </p>
 **/
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonQualifier {

}
