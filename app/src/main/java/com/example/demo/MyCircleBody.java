package com.example.demo;
import android.graphics.Canvas;
import org.jbox2d.dynamics.Body;
import android.graphics.Color;
import android.graphics.Paint;

public class MyCircleBody extends MyBody
{
    int r;

    MyCircleBody(int r, Body body, int color)
    {
        this.r = r;
        this.body = body;
        this.color = color;
    }
    @Override
    public void drawSelf(Canvas canvas, Paint paint)
    {
        canvas.drawCircle(body.getPosition().x * Constant.RATE, body.getPosition().y * Constant.RATE, r, paint);

    }

}
