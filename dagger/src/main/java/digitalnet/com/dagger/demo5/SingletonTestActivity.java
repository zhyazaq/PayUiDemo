package digitalnet.com.dagger.demo5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import digitalnet.com.dagger.R;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 18:01  星期四
 * 类描述 ： This is  SingletonTestActivity
 * </p>
 **/
public class SingletonTestActivity extends Activity {
      private TextView mTvUserName;

      @Inject
      SingletonBean mSingletonBean;

      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_one);
//            DaggerSingletonComponent.builder().build().inject(this);
            SingletonComponent.getInstance().inject(this);
            initView();
            mTvUserName.setText(mSingletonBean.getName()+"---地址---"+mSingletonBean);
      }

      private void initView() {
            mTvUserName = (TextView) findViewById(R.id.tv_user_name);
//            mTvUserName.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View view) {
//
//                  }
//            });
      }
}
