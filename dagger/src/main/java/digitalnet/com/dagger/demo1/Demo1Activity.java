package digitalnet.com.dagger.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import digitalnet.com.dagger.R;

/**

 * 创建时间：2018/10/25 16:38  星期四
 * 类描述 ： This is  Demo1Activity
 * 缺点
 * 1.只能标记一个构造方法，两个构造方法的时候编译就会报错，详见user类，不知道用哪个构造器，没有进行区分
 * 2.不能标记第三方库，我们没有办法在其构造器添加@inject 方法
 *
 * </p>
 **/
public class Demo1Activity extends Activity {
      @Inject
       User mUser; // 不能用private 修饰 错误: Dagger does not support injection into private fields
      private TextView mTvUserName;

      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_one);
            //完成注入
            DaggerOneCompone.builder().build().inject(this);
            initView();
            mTvUserName.setText(mUser.getName());
      }

      private void initView() {
            mTvUserName = (TextView) findViewById(R.id.tv_user_name);
      }
}
