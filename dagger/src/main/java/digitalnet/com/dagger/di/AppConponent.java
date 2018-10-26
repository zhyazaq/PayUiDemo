package digitalnet.com.dagger.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**

 * 创建时间：2018/10/25 19:02  星期四
 * 类描述 ： This is  AppConponent
 * </p>
 **/
@Singleton
@Component(modules = AppModule.class)
public interface AppConponent {
      Context context();
}
