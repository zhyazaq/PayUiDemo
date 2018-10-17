package rnjf.com.payuidemo.payUI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import rnjf.com.payuidemo.R;



@SuppressLint("AppCompatCustomView")
public class PassWordEditText extends EditText {
      //分割线的paint
      private Paint linePaint;
      //数字密码的paint
      private Paint passwordPaint;
      //数字密码的大小
      private int passwordSize = 1;
      //分割线的大小
      private int lineSize = 1;
      //分割线的颜色
      private int lineColor = Color.parseColor("#d1d2d6");
      //密码的颜色
      private int passwordColor = Color.parseColor("#d1d2d6");
      //圆形密码的颜色
      private int passwordCircleColor = Color.parseColor("#d1d2d6");
      //密码数字的个数
      private int passwordNumber = 6;
      //背景边框的颜色
      private int mBgColor = Color.parseColor("#d1d2d6");
      //密码圆形的半径大小
      private int passwordCircleRadius = 4;
      //背景边框圆角的大小
      private int mBgCorner = 1;
      //是否展示密码输入框里面的数字
      private boolean isShowNum = true;
      //是否绘制圆角背景框
      private boolean useBgCorner = true;
      //背景的宽度
      private int mBgSize = 1;
      //一个密码需要的宽度
      private int mPassWordItemWith;


      public PassWordEditText(Context context) {
            super(context,null);
      }

      public PassWordEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            initAttributeSet(context, attrs);
            initPaint();
            // 默认只能够设置数字和字母
            setInputType(EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
      }

      private void initPaint() {
            //绘制线的画笔
            linePaint = new Paint();
            linePaint.setAntiAlias(true);
            linePaint.setDither(true);
            //绘制密码的画笔
            passwordPaint = new Paint();
            passwordPaint.setDither(true);
            passwordPaint.setAntiAlias(true);
            passwordPaint.setTextAlign(Paint.Align.CENTER);
      }

      private void initAttributeSet(Context context, AttributeSet attrs) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PassWordEditText);
            mBgColor = array.getColor(R.styleable.PassWordEditText_bgColor, mBgColor);
            lineColor = array.getColor(R.styleable.PassWordEditText_lineColor, lineColor);
            lineSize = (int) array.getDimension(R.styleable.PassWordEditText_lineSize, dip2px(lineSize));
            mBgCorner = (int) array.getDimension(R.styleable.PassWordEditText_bgCorner, dip2px(mBgCorner));
            passwordCircleRadius = (int) array.getDimension(R.styleable.PassWordEditText_passwordCircleRadius, dip2px(passwordCircleRadius));
            passwordCircleColor = array.getColor(R.styleable.PassWordEditText_passwordColor, passwordCircleColor);
            isShowNum = array.getBoolean(R.styleable.PassWordEditText_isShowNum, isShowNum);
            useBgCorner = array.getBoolean(R.styleable.PassWordEditText_useBgCorner, useBgCorner);
            mBgSize = (int) array.getDimension(R.styleable.PassWordEditText_bgSize, mBgSize);
            array.recycle();
      }

      public float dip2px(int dip) {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
      }

      @Override
      protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
            //一个密码所需要的宽度
            mPassWordItemWith = (getWidth() - 2 * mBgSize - (passwordNumber - 1) * lineSize) / passwordNumber;
            //绘制背景
            drawBg(canvas);
            //绘制分割线
            drawLinedivise(canvas);
            //绘制密码
            drawPassWord(canvas);

            if (mPasswordFullListener != null) {
                  String pwd = getText().toString().trim();
                  if (pwd.length()>=passwordNumber) {
                        mPasswordFullListener.passwordFull(pwd);
                  }
            }
      }

      /***
       * 绘制密码
       * @param canvas
       */
      private void drawPassWord(Canvas canvas) {
            //密码绘制是实心的
            passwordPaint.setStyle(Paint.Style.FILL);
            passwordPaint.setColor(passwordColor);
            String pwd = getText().toString().trim();
            int pwdLenth=pwd.length();
            for (int i = 0; i < pwdLenth; i++) {
                  int cy=getHeight()/2;
                  int cx=mBgSize+i*mPassWordItemWith+i*lineSize+mPassWordItemWith/2;
                  if (isShowNum) {
                        passwordPaint.setTextSize(getHeight()/2);
                        canvas.drawText(pwd.charAt(i)+"",cx,getHeight()/4*3,passwordPaint);
                  }else{
                        canvas.drawCircle(cx,cy,passwordCircleRadius,passwordPaint);
                  }
            }
      }

      /**
       * 绘制分割线
       * @param canvas
       */
      private void drawLinedivise(Canvas canvas) {
            linePaint.setStrokeWidth(lineSize);
            linePaint.setColor(lineColor);
            for (int i=0;i<passwordNumber;i++){
                  int startX=mBgSize+(i+1)*mPassWordItemWith+i*lineSize;
                  int startY= mBgSize;
                  int endX=startX;
                  int endY=getHeight()-mBgSize;
                  canvas.drawLine(startX,startY,endX,endY,linePaint);
            }
      }

      /***
       * 绘制背景
       * @param canvas
       */
      private void drawBg(Canvas canvas) {
            RectF rectF = new RectF(mBgSize, mBgSize, getWidth() - mBgSize, getHeight() - mBgSize);
            linePaint.setStrokeWidth(mBgSize);
            linePaint.setColor(mBgColor);
            linePaint.setStyle(Paint.Style.STROKE);
            if (useBgCorner) {
                  canvas.drawRoundRect(rectF, mBgCorner, mBgCorner, linePaint);
            } else {
                  canvas.drawRect(rectF, linePaint);
            }


      }

      /***
       * 删除一个密码
       */
      public void deleteLastPassWord(){
            String password=getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                  return;
            }
            password = password.substring(0, password.length() - 1);
            setText(password);
      }

      /***
       * 添加一个密码
       * @param number
       */
      public void addPassWord(String number){
            String password = getText().toString().trim();
            if (password.length()>= passwordNumber) {
                  return;
            }
            password+=number;
            setText(password);
      }

      //设置当前密码是否已满的接口回调
      private PasswordFullListener mPasswordFullListener;

      public void setPasswordFullListener(PasswordFullListener passwordFullListener) {
            mPasswordFullListener = passwordFullListener;
      }

      public interface  PasswordFullListener{
            public void passwordFull(String password);
      }

}
