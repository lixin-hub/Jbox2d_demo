package com.example.demo;
import org.jbox2d.dynamics.Body;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class MyBody
{
    Body body;
    Paint paint;
    int color;
    public abstract void drawSelf(Canvas canvas,Paint paint);
    
    
}
