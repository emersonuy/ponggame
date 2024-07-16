package com.iamsoft.ponggame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.iamsoft.ponggame.R;

public class GameView extends View {
    Handler handler;
    Runnable runnable;
    Paint text_paint = new Paint();
    Bitmap bg;
    Bitmap[] fire = {
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_1),
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_2),
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_3),
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_4),
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_3),
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_2),
            BitmapFactory.decodeResource(getResources(), R.drawable.fire_1),
    };

    int fire_current_frame = 0;

    public GameView(Context context) {
        super(context);

        text_paint.setColor(Color.WHITE);
        text_paint.setTextSize(100);
        bg = BitmapFactory.decodeResource(getResources(), R.drawable.casino_bg);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        Rect screen_rect = new Rect();
        screen_rect.set(0, 0, this.getWidth(), this.getHeight());
        canvas.drawBitmap(bg, null, screen_rect, null);
        canvas.drawText("Hello", 100, 500, text_paint);

        fire_current_frame++;
        canvas.drawBitmap(fire[fire_current_frame % fire.length], 0, 100, null);
    }
}
