package rnjf.com.payuidemo.payUI;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import rnjf.com.payuidemo.R;


/**
 * Description ： This is  PayPopWindow 自定义弹框仿支付宝密码输入框  基本使用
 * //                PayPopWindow payPopWindow=new PayPopWindow(mBaseActivity);
 *                     //mRoot 是最外层布局
 //                payPopWindow.showPopWindow(mRoot);
 //                payPopWindow.setPayPopWindowComplete(new PayPopWindow.payPopWindowComplete() {
 //                    @Override
 //                    public void complete(String pwd) {
 //
 //                    }
 //                });
 * </p>
 **/
public class PayPopWindow extends PopupWindow {


      private final PayKeyBoard mCusKeyBoard;
      private final PassWordEditText mPassWordEditText;
      private final TextView mContent;

      public  PayPopWindow(final Activity context){
          View view= LayoutInflater.from(context).inflate(R.layout.layout_pay_ui,null,false);
         int h= context.getWindowManager().getDefaultDisplay().getHeight();
         int w=context.getWindowManager().getDefaultDisplay().getWidth();
         this.setContentView(view);
         this.setWidth((int) (ViewGroup.LayoutParams.MATCH_PARENT));
         this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
         this.setAnimationStyle(R.style.PayUiAnim);
            //实例化一个ColorDrawable颜色为半透明
            ColorDrawable dw = new ColorDrawable(context.getResources().getColor(R.color.text_ffffff));
            //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
         this.setFocusable(false);
         this.setOutsideTouchable(false);
         this.update();
            mPassWordEditText = view.findViewById(R.id.passwordview);
            mPassWordEditText.setEnabled(false);
            mPassWordEditText.setPasswordFullListener(new PassWordEditText.PasswordFullListener() {
                  @Override
                  public void passwordFull(String password) {
                        mPayPopWindowComplete.complete(password);
                  }
            });
            mCusKeyBoard = view.findViewById(R.id.cus_key_board);
            mCusKeyBoard.setCustomerKeyboardClickListener(new PayKeyBoard.CustomerKeyboardClickListener() {
                  @Override
                  public void click(String number) {
                        mPassWordEditText.addPassWord(number);
                  }

                  @Override
                  public void delete() {
                        mPassWordEditText.deleteLastPassWord();
                  }
            });
            ImageView image=  view.findViewById(R.id.imag_back_pay_ui);
            image.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        dismisPayPopWindow();
                  }
            });
            mContent = view.findViewById(R.id.tv_content_pay_ui);

      }


      /***
       * 设置密码上面的内容提示语句
       * @param content
       */
      public void setPopWindowContent(String content){
            if(mContent != null){
                  mContent.setText(content);
            }

      }
      /***
       * 底部展示popwindow
       * @param view
       */
      public void showPopWindowBottom(View view){
            if (!this.isShowing()) {
                  this.showAtLocation(view, Gravity.CENTER_HORIZONTAL| Gravity.BOTTOM,0,0);
            }else{
                  this.dismiss();
            }

      }

      /***
       * 销毁popwindow
       */
      public void dismisPayPopWindow(){
            if (this.isShowing()) {
                  this.dismiss();
            }
      }

      private payPopWindowComplete mPayPopWindowComplete;

      public void setPayPopWindowComplete(payPopWindowComplete payPopWindowComplete) {
            mPayPopWindowComplete = payPopWindowComplete;
      }

      public interface  payPopWindowComplete{
            public void complete(String pwd);
      }
}
