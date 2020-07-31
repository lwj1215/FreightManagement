package com.example.freightmanagement.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

public class ElectronicSignature extends View {
    private Paint gesturePaint;
    private Path gesturePath;
    private int defaultPaintWidth = 15;
    private Context mContext;
    private Canvas canvas1;

    public ElectronicSignature(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public ElectronicSignature(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ElectronicSignature(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ElectronicSignature(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        gesturePaint = new Paint();
        gesturePaint.setAntiAlias(true);
        gesturePaint.setStyle(Paint.Style.STROKE);
        gesturePaint.setStrokeWidth(defaultPaintWidth);
        gesturePaint.setColor(Color.BLACK);
        gesturePath = new Path();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                touchNewMove(event);
                break;
        }
        return true;
    }

    /**
     * 在手指移动的时候则获取移动到的坐标，然后根据path的quadTo得到平滑的贝赛尔曲线，记录此时的坐标作为下次的起始坐标
     *
     * @param event
     */
    private void touchMove(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if (Math.abs(x - startX) > 10 && Math.abs(y - startY) > 10) {   //降低功耗
            float controalX = (x + startX) / 2;
            float controalY = (y + startY) / 2;
            gesturePath.quadTo(startX, startY, controalX, controalY);
            startX = x;
            startY = y;
            invalidate();
        }
    }

    /**
     * 测试说写字不连贯，所以做一点小处理
     * 在手指移动的时候则获取移动到的坐标，然后根据path的quadTo得到平滑的贝赛尔曲线，记录此时的坐标作为下次的起始坐标
     *
     * @param event
     */
    private void touchNewMove(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        float controalX = (x + startX) / 2;
        float controalY = (y + startY) / 2;
        gesturePath.quadTo(startX, startY, controalX, controalY);
        startX = x;
        startY = y;
        invalidate();
    }

    /**
     * 在手指按下后记录下坐标，将Path移动到该坐标并且作为起始坐标
     *
     * @param event
     */
    private float startX = 0f;
    private float startY = 0f;

    private void touchDown(MotionEvent event) {
        startX = event.getX();
        startY = event.getY();
        gesturePath.moveTo(startX, startY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas1 = canvas;
        canvas.drawPath(gesturePath, gesturePaint);
    }

    public Bitmap save() {
        Bitmap bitMap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitMap);//会将canvas上绘制的内容保存到bitMap中
        canvas.drawPath(gesturePath, gesturePaint);
        if (gesturePath.isEmpty()) {
            return null;
        }
        return bitMap;
    }

    public void clearCanvas() {
        gesturePath.reset();
        invalidate();
    }
}
