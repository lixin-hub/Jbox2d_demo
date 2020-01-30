package com.example.demo;

public class DrawThread extends Thread
{

    MySurfaceView ms;

    public DrawThread(MySurfaceView ms)
    {
        this.ms = ms;
    }

    @Override
    public void run()
    {
        while (Constant.DRAWTHREAD_FLAG)
        {
            ms.onDraw();
            ms.mainActivity.world.step(Constant.timeStep, Constant.itera, Constant.itera);

        }

        super.run();
    }


}
