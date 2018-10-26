package digitalnet.com.dagger.demo4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

import digitalnet.com.dagger.R;

/**

 * 创建时间：2018/10/25 17:30  星期四
 * 类描述 ： This is  QualifierAcitivity
 * </p>
 **/
public class QualifierAcitivity extends Activity {
      @Inject
      Person mPerson;

      @Inject
      @Named("old")
      Person mPersonOld;

      @Inject
      @Named("yong")
      Person mPersonYong;

      @Inject
      @PersonQualifier
      Person mPersonQualifier;
      private TextView mTvDefult;
      private TextView mTvOld;
      private TextView mTvYong;
      private TextView mTvQualifier;

      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_qualifier);
//            DaggerPersonComponent.create().inject(this);
            DaggerPersonComponent.builder().dataModule(new DataModule()).build().inject(this);
            initView();
            mTvDefult.setText(mPerson.getName());
            mTvOld.setText(mPersonOld.getName());
            mTvYong.setText(mPersonYong.getName());
            mTvQualifier.setText(mPersonQualifier.getName());
      }


      private void initView() {
            mTvDefult = (TextView) findViewById(R.id.tv_defult);
            mTvOld = (TextView) findViewById(R.id.tv_old);
            mTvYong = (TextView) findViewById(R.id.tv_yong);
            mTvQualifier = (TextView) findViewById(R.id.tv_qualifier);
      }
}
