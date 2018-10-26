package digitalnet.com.dagger;

import android.app.Application;

import digitalnet.com.dagger.di.AppConponent;
import digitalnet.com.dagger.di.AppModule;
import digitalnet.com.dagger.di.DaggerAppConponent;

/**

 * 创建时间：2018/10/25 19:00  星期四
 * 类描述 ： This is  App
 * </p>
 **/
public class App extends Application{
      private  static AppConponent sAppConponent;

      @Override
      public void onCreate() {
            super.onCreate();
            if (sAppConponent == null) {
                  sAppConponent= DaggerAppConponent.builder().appModule(new AppModule(this)).build();
            }
      }

      public static AppConponent getAppConponent() {
            //对外提供依赖appcomponent
            return sAppConponent;
      }
}
