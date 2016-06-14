package helper;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


public class MyViewPager extends ViewPager {

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.v("111", getCurrentItem() + "");
        if(getCurrentItem() >= 0) {
            super.onTouchEvent(e);
            return true;
        }
        //super.onTouchEvent(e);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.v("111", getCurrentItem() + "");
        if(getCurrentItem() >= 0) {
            super.onInterceptTouchEvent(e);
            //return true;
        }
        //super.onInterceptTouchEvent(e);
        return true;
    }*/
}
