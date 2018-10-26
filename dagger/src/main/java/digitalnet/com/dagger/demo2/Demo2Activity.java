package digitalnet.com.dagger.demo2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import digitalnet.com.dagger.R;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 16:38  星期四
 * 类描述 ： This is  Demo1Activity
 * 缺点
 * 1.只能标记一个构造方法，两个构造方法的时候编译就会报错，详见user类，不知道用哪个构造器，没有进行区分
 * 2.不能标记第三方库，我们没有办法在其构造器添加@inject 方法
 *
 * </p>
 **/
public class Demo2Activity extends Activity {

      private TextView mTvUserName;
      @Inject
      Person mPerson;

      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_one);
            //完成注入
//            DaggerPersonComponent.builder().personModule(new PersonModule()).build().inject(this);
            //注意如果module 里面只有一个默认的无参构造器，我们直接可以用create方法替代
            DaggerPersonComponent.create().inject(this);
            initView();
            mTvUserName.setText(mPerson.getName());
      }

      private void initView() {
            mTvUserName = (TextView) findViewById(R.id.tv_user_name);
      }
}
