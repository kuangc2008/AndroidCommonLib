package com.kc.androidlib.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.kc.androidlib.R;
import com.kc.androidlib.activity.TextToBitmapActivity;

public class ProgressView extends View {

    Bitmap left;
    Bitmap rightBitmap;
    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (left == null) {
            left = BitmapFactory.decodeResource(getResources(), R.drawable.left_ic);
            rightBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.right_ic);
        }


        drawAudios(canvas, 100, 0, false);
//        drawMask(canvas);
        drawAudios(canvas, 100, 0, true);



    }

    private int mnHoverTag = 3;
    public void setSelectIndex() {

    }


    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private void drawMask(Canvas canvas) {
        if (true) {
            mPaint.setColor(Color.parseColor("#99000000"));
//            mPaint.setColor(Color.parseColor("#0000ff"));
            mPaint.setAntiAlias(true);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawAudios(Canvas canvas, long right, int margin, boolean bDrawSel) {
        int nMusicMargin =20;

        int nFirstVisible = 0;


        for (int n = 0; n < TextToBitmapActivity.texts.size(); n++) {
            if ((bDrawSel && n == mnHoverTag)
                    || (!bDrawSel && n != mnHoverTag)) {
//                long lStartX = mDataController.convertTimeToPosition(audioBean.getStartTime());
//                long lEndX = mDataController.convertTimeToPosition(audioBean.getEndTime());


                int halfWidth = 3;

                int width = 0;
                if (n == 0) {
                    width = getWidth() *  (TextToBitmapActivity.widths.get(n)) / 100 - halfWidth;
                } else {
                    width = getWidth() *  (TextToBitmapActivity.widths.get(n) - TextToBitmapActivity.widths.get(n - 1)) / 100 - halfWidth * 2;
                }

                int left = 0;
                if (n > 0) {
                    left = getWidth() *  (TextToBitmapActivity.widths.get(n - 1)) / 100 + halfWidth;
                } else {
                    left = 0;
                }



                drawOneAudio(TextToBitmapActivity.texts.get(n), canvas, margin, (int) left, (int) left + width, bDrawSel);
            }
        }
    }


    private final float s = getContext().getResources().getDisplayMetrics().density;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawOneAudio(String  text, Canvas canvas, int margin, int nStartX, int right, boolean bSelected) {


        Log.i("kcc", "startX:" + nStartX + " right:" + right);

        canvas.save();
//        Path path = new Path();
//        if (bSelected) {
//            path.addRoundRect(nStartX, 0, right, getHeight(), 0 * s, 0 * s, Path.Direction.CCW);
//        } else {
//            path.addRoundRect(nStartX, 9, right, getHeight(), 4 * s, 4 * s, Path.Direction.CCW);
//        }
//
//
//        canvas.clipPath(path);




        //选中时更改颜色
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        if (!bSelected) {
            mPaint.setColor(Color.parseColor("#151515"));
        } else {
            mPaint.setColor(Color.parseColor("#007CFF"));
        }


        canvas.drawRoundRect(nStartX, (int) (0), right,  getHeight(), 8, 8, mPaint);

//        drawWave(audioBean, canvas, margin, nStartX, right, bSelected);


        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);


        mPaint.setTextSize(12 * s);
        mPaint.setColor(Color.rgb(255, 255, 255));
        String sTitle = text;
        Rect textRc = new Rect();
        if (sTitle != null && sTitle.length() != 0) {
            mPaint.getTextBounds(sTitle, 0, sTitle.length(), textRc);
            int textWidth = textRc.width();
            if (textRc.width() >= (right - nStartX)) {
                @SuppressLint("DrawAllocation")
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(12 * s);
                sTitle = TextUtils.ellipsize(sTitle, textPaint, (right - (nStartX)), TextUtils.TruncateAt.END).toString();
                textWidth = right - nStartX;
            }

            int nTextLeft = nStartX +  (  right - nStartX - textWidth  )/2;
            int nTextTop = (int) (getHeight() - textRc.height() ) / 2 - textRc.top;
//            int nTextTop = 0;
            canvas.drawText(sTitle, nTextLeft, nTextTop, mPaint);
        }

        if (bSelected) {



            canvas.drawBitmap(left, nStartX - left.getWidth()/2, getHeight()/2 - left.getHeight()/2, null);
            canvas.drawBitmap(rightBitmap,      right - rightBitmap.getWidth()/2, getHeight()/2 - rightBitmap.getHeight()/2, null);
        }

    }


}
