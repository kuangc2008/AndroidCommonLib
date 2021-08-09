package com.kc.androidlib.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TextToBitmapActivity extends AppCompatActivity implements View.OnClickListener{

    static List<String> texts = new ArrayList<>();
    static List<Integer> widths = new ArrayList<>();


    static {
        texts.add("前言");
        texts.add("编辑时添加标记");
        texts.add("编辑时添加标记编辑时添加标记");
        texts.add("时间轴");
        texts.add("结尾");

        widths.add(20);
        widths.add(50);
        widths.add(60);
        widths.add(90);
        widths.add(100);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        /**
         *      Bitmap bmp;
         *             if (reuseBmp != null && reuseBmp.getWidth() == boundsWidth
         *                     && reuseBmp.getHeight() == bmpHeight) {
         *                 // if previous bitmap exists, and it's width/height is the same - reuse it
         *                 bmp = reuseBmp;
         *                 bmp.eraseColor(Color.TRANSPARENT); // erase color when reusing
         *             } else {
         *                 bmp = Bitmap.createBitmap(boundsWidth, bmpHeight, Bitmap.Config.ARGB_8888);
         *             }
         */
        Log.i("kcc", "draw  stat");
        Bitmap c = Bitmap.createBitmap(720 , 120,  Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(c);
        canvas.drawColor(Color.RED);


        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize( 20 );
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.DEFAULT);


        Paint dividePaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        dividePaint.setStyle(Paint.Style.FILL);
        dividePaint.setColor(Color.parseColor("#33ffffff"));
//        dividePaint.setColor(Color.parseColor("#00ff00"));
        dividePaint.setTypeface(Typeface.DEFAULT);




        // drawing text guide : http://ivankocijan.xyz/android-drawing-multiline-text-on-canvas/
        // Static layout which will be drawn on canvas


        for (int i = 0; i < texts.size(); i++) {
            canvas.save();


            int halfWidth = 6 / 2;


            int width = 0;
            if (i == 0) {
                width = c.getWidth() *  (widths.get(i)) / 100 - halfWidth;
            } else {
                width = c.getWidth() *  (widths.get(i) - widths.get(i - 1)) / 100 - halfWidth * 2;
            }

            int left = 0;
            if (i > 0) {
                left = c.getWidth() *  (widths.get(i - 1)) / 100 + halfWidth;
            } else {
                left = halfWidth;
            }


            StaticLayout staticLayout = null;
            if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                staticLayout = StaticLayout.Builder
                        .obtain(texts.get(i), 0, texts.get(i).length(), textPaint, width)
                        .setAlignment(Layout.Alignment.ALIGN_CENTER)
                        .setMaxLines(2)
                        .setEllipsize(TextUtils.TruncateAt.END)
                        .build();
            } else {
                Log.i("kcc", "static  start 1");
                staticLayout = new StaticLayout(
                        texts.get(i), // - text which will be drawn
                        textPaint,
                        width ,
                        Layout.Alignment.ALIGN_CENTER, // - layout alignment
                        1, // 1 - text spacing multiply
                        0, // 1 - text spacing add
                        true
                ); // true - include padding
                if (staticLayout.getLineCount() > 1) {
                    // if it exceeds our max number of lines then truncate the text & recreate the layout
                    int endIndex = staticLayout.getLineEnd(1) - 2; // minus 2 chars for the ellipse
                    SpannableStringBuilder displayText = new SpannableStringBuilder(texts.get(i).subSequence(0, endIndex) + "…");
                    staticLayout = new StaticLayout(displayText,
                            textPaint,
                            width,
                            Layout.Alignment.ALIGN_CENTER,
                            1f,
                            0,
                            true);
                }
            }

            if (i > 0) {
                canvas.drawRect(left - halfWidth, 0, left + halfWidth,  c.getHeight(), dividePaint);
            }

            canvas.translate(left, (c.getHeight() - staticLayout.getHeight())/2 );


            //draws static layout on canvas
            staticLayout.draw(canvas);



            canvas.restore();

            Log.i("kcc", "static  start 2");
        }

        imageView.setImageBitmap(c);
        setContentView(imageView);

        Log.i("kcc", "draw  end");
    }

    @Override
    public void onClick(View v) {

    }
}
