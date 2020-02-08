package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.jbox2d.dynamics.World;
import org.jbox2d.common.Vec2;
import java.util.ArrayList;
import org.jbox2d.collision.AABB;
import android.graphics.Color;
import org.jbox2d.dynamics.contacts.ContactRegister;
import org.jbox2d.dynamics.ContactManager;
import org.jbox2d.dynamics.contacts.Contact;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;

public class MainActivity extends AppCompatActivity
{

    ArrayList<MyBody> bodyList=new ArrayList<MyBody>();
    SensorManager manager;
	Sensor sensor;
	SensorEventListener event;
    public World world;
	Vec2 v;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
v=new Vec2(0,10);
AABB aabb=new AABB();
aabb.upperBound.set(-100,-100);
aabb.lowerBound.set(100,100);
		world = new World(v);
manager=(SensorManager) getSystemService(SENSOR_SERVICE);
sensor=manager.getDefaultSensor(Sensor.TYPE_GRAVITY);
	event=new SensorEventListener(){

			@Override
			public void onSensorChanged(SensorEvent p1)
			{
				float x=p1.values[0];
				float y=p1.values[1];
				float z=p1.values[2];
				world.setGravity(new Vec2(-x,y));
			}

			@Override
			public void onAccuracyChanged(Sensor p1, int p2)
			{
			}
		};
   
world.setContactListener(new MyContactListener());

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
	   manager.registerListener(event,sensor,manager.SENSOR_DELAY_UI);
        super.onPause();
    }

    @Override
    protected void onStart()
    {
        setContentView(new MySurfaceView(this));
        super.onStart();
    }

	@Override
	protected void onResume()
	{manager.registerListener(event,sensor,manager.SENSOR_DELAY_UI);
		super.onResume();
	}




}
