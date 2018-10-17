package rnjf.com.payuidemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;

import rnjf.com.payuidemo.payUI.PayPopWindow;

public class MainActivity extends AutoLayoutActivity {

      private ConstraintLayout mRoot;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initView();
      }

      public void showPopwindow(View view) {
            PayPopWindow payPopWindow = new PayPopWindow(this);
                 //mRoot 是最外层布局
            payPopWindow.showPopWindowBottom(mRoot);
            payPopWindow.setPopWindowContent("短信验证码已发送至你的手机，请注意查收！");
            payPopWindow.setPayPopWindowComplete(new PayPopWindow.payPopWindowComplete() {
                  @Override
                  public void complete(String pwd) {
                        Toast.makeText(MainActivity.this,   "密码输入完成", Toast.LENGTH_SHORT).show();
                  }
            });
      }

      private void initView() {
            mRoot = (ConstraintLayout) findViewById(R.id.root);
      }
}
