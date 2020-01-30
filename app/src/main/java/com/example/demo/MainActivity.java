package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.jbox2d.dynamics.World;
import org.jbox2d.common.Vec2;
import java.util.ArrayList;
import org.jbox2d.collision.AABB;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity
{

    ArrayList<MyBody> bodyList=new ArrayList<MyBody>();

    public World world;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        world = new World(new Vec2(0, 10f));

        bodyList.add(BodyUtil.createCircleBody(500, 500, 100, world, Color.RED, false));

        for (int i=0;i <= 720;i++)
        {
            // bodyList.add(BodyUtil.createCircleBody(10+i*100,10,50,world,Color.RED,false));

            bodyList.add(BodyUtil.createCircleBody(540 + 500 * (float)Math.cos(i), 800 + 500 * (float)Math.sin(i), 1, world, Color.BLACK, true));

        }

        setContentView(new MySurfaceView(this));

    }

    @Override
    protected void onPause()
    {
        setContentView(new MySurfaceView(this));
        super.onPause();
    }

    @Override
    protected void onStart()
    {
        setContentView(new MySurfaceView(this));
        super.onStart();
    }




}
