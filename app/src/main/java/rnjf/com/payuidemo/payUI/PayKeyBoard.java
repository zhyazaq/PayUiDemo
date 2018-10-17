package rnjf.com.payuidemo.payUI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import rnjf.com.payuidemo.R;



public class PayKeyBoard extends LinearLayout implements View.OnClickListener {
      public PayKeyBoard(Context context) {
            super(context,null);
      }

      public PayKeyBoard(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            inflate(context, R.layout.layout_custom_key_board,this);
            setItemClickListener(this);
      }

      private void setItemClickListener(View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup= (ViewGroup) view;
                  int childCount = viewGroup.getChildCount();
                  for (int i = 0; i < childCount; i++) {
                        View childView=viewGroup.getChildAt(i);
                        setItemClickListener(childView);
                  }
            }else{
                  if(view instanceof TextView){
                        String pwd=((TextView)view).getText().toString();
                        if(!TextUtils.isEmpty(pwd) && pwd.length()>1){
                              SpannableString textSpan = new SpannableString(pwd);
                              textSpan.setSpan(new AbsoluteSizeSpan(80),0,1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                              textSpan.setSpan(new AbsoluteSizeSpan(22),1,pwd.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                              ((TextView)view).setText(textSpan);
                        }
                  }
                  view.setOnClickListener(this);
            }
      }

      @Override
      public void onClick(View v) {
            if(v instanceof TextView){
                  String number = ((TextView) v).getText().toString().trim();
                  if (mCustomerKeyboardClickListener != null) {
                        mCustomerKeyboardClickListener.click(number.substring(0,1));
                  }
            }

            if(v instanceof ImageView){
                  if (mCustomerKeyboardClickListener != null) {
                        mCustomerKeyboardClickListener.delete();
                  }

            }
      }

      private CustomerKeyboardClickListener mCustomerKeyboardClickListener;

      public void setCustomerKeyboardClickListener(CustomerKeyboardClickListener customerKeyboardClickListener) {
            mCustomerKeyboardClickListener = customerKeyboardClickListener;
      }

      public interface  CustomerKeyboardClickListener{
            public void click(String number);
            public void delete();
      }
}
