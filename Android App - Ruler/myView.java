package shahan59com.mainapplication;

import android.content.Context;
import android.graphics.Color;
import android.test.FlakyTest;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.widget.Toast;

public class myView extends View {

    GestureDetector gestureDetector;
    Paint paint = new Paint();
    float x0;
    float x1 = 0;
    int digit;


    public myView(Context context){
        super(context);
        gestureDetector = new GestureDetector(context, new GestureListener());
        digit = 0;
    }


    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

        final float testTextSize = 48f;
        paint.setTextSize(testTextSize);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float width = metrics.widthPixels;
        float height = metrics.heightPixels;
        float densityDpi = metrics.densityDpi;
        float x = 0;
        int mark = 0;
        while (x < width) {
            if (mark % 16 == 0) {
                canvas.drawLine(x, 0, x, height / 2, paint);
                canvas.drawText(digit + "", x + 10, height / 2, paint);
                digit++;
                mark = 0;
            } else if (mark % 2 != 0) {
                canvas.drawLine(x, 0, x, height / 12, paint);
            } else if (mark == 2 || mark == 6 || mark == 10 || mark == 14) {
                canvas.drawLine(x, 0, x, height / 8, paint);
            } else if (mark == 4 || mark == 12) {
                canvas.drawLine(x, 0, x, height / 6, paint);
            } else if (mark == 8) {
                canvas.drawLine(x, 0, x, height / 4, paint);
            }
            x = x + (densityDpi / 16);
            mark++;

        }

        canvas.drawText("Phone too short? Double-tap anywhere", 15, height-100, paint);
        canvas.drawText("Swipe Measurement (in inches):" + (x0/densityDpi), 15, height-200, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }



    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            x0 = e.getX();
            return true;
        }


        @Override
        public boolean onDoubleTap(MotionEvent e) {
            invalidate();

            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            digit = 0;
            invalidate();

            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                float distanceY) {

            x0 = distanceX;
            return false;
        }

    }

}


