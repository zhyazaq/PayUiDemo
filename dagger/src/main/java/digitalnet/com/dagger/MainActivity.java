package digitalnet.com.dagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import digitalnet.com.dagger.demo1.Demo1Activity;
import digitalnet.com.dagger.demo2.Demo2Activity;
import digitalnet.com.dagger.demo3.PriorityTestActivity;
import digitalnet.com.dagger.demo4.QualifierAcitivity;
import digitalnet.com.dagger.demo5.SingletonTestActivity;

public class MainActivity extends AppCompatActivity {

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
      }

      /***
       * @inject 最简单的用法
       * @param view
       */
      public void oneclick(View view){
            startActivity(new Intent(this, Demo1Activity.class));
      }

      /***
       * @module 初体验 采用@module依赖
       * @param view
       */
      public void twoclick(View view){
            startActivity(new Intent(this, Demo2Activity.class));
      }

      /***
       * @module 测试@inject与@module依赖优先级  @Module级别高于@Inject。
       * @param view
       */
      public void threeeclick(View view){
            startActivity(new Intent(this, PriorityTestActivity.class));
      }

      /***
       * @module测试@Qualifier限定符作用
       * @param view
       */
      public void fourclick(View view){
            startActivity(new Intent(this, QualifierAcitivity.class));
      }

      /***
       * 测试@sinfleton限定符作用
       * @param view
       */
      public void fiveclick(View view){
            startActivity(new Intent(this, SingletonTestActivity.class));
      }
}
