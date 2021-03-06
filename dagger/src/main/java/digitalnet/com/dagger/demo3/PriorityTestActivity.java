package digitalnet.com.dagger.demo3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import digitalnet.com.dagger.R;

/**

 * 创建时间：2018/10/25 17:17  星期四
 * 类描述 ： This is  PriorityTestActivity
 * </p>
 **/
public class PriorityTestActivity extends Activity {
      private TextView mTvUserName;
      @Inject
      priorityBean mPriorityBean;
      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_one);
          //  DaggerPriorityComponet.builder().dataModule(new DataModule()).build().inject(this);
            DaggerPriorityComponet.create().inject(this);
            initView();
            mTvUserName.setText(mPriorityBean.getName());
      }

      private void initView() {
            mTvUserName = (TextView) findViewById(R.id.tv_user_name);
      }
}
