package com.example.demo;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.InputQueue.Callback;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import org.jbox2d.dynamics.BodyType;
import java.util.ArrayList;
import org.jbox2d.common.Vec2;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback
{

    MainActivity mainActivity;

    Paint paint;

    Canvas canvas;

    SurfaceHolder holder;

    DrawThread dt;

    ArrayList<Vec2> pointList=new ArrayList<Vec2>();
    public MySurfaceView(MainActivity mainActivity)
    {
        super(mainActivity);
        this.mainActivity = mainActivity;
        holder = this.getHolder();
        holder.addCallback(this);
        paint = new Paint();
        paint.setAntiAlias(true);
        dt = new DrawThread(this);
        Constant.DRAWTHREAD_FLAG = true;

    }




    @Override
    public void surfaceCreated(SurfaceHolder p1)
    {
        dt.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
    {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder p1)
    {
        Constant.DRAWTHREAD_FLAG = false;
    }

    public void onDraw()
    {
        canvas = holder.lockCanvas();
        if (canvas != null)
        {
            canvas.drawColor(Color.WHITE);
            for (MyBody body:mainActivity.bodyList)
            {
                paint.setColor(body.body.getUserData());
                body.drawSelf(canvas, paint);
            }
            holder.unlockCanvasAndPost(canvas);
		
        }
    }
	
	
	
}
