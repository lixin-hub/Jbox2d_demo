package com.example.demo;
import org.jbox2d.dynamics.World;
import android.graphics.Color;
import org.jbox2d.dynamics.BodyDef.*;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.collision.shapes.MassData;

public class BodyUtil
{

    public static MyCircleBody createCircleBody(float x, float y, int r, World world , int color, boolean isStatic)
    {
        BodyDef bd=new BodyDef();
        if (isStatic)
        {bd.type = BodyType.STATIC;}
        else
        {bd.type = BodyType.DYNAMIC;}
        bd.position.set(x / Constant.RATE, y / Constant.RATE);
        Body body=world.createBody(bd);
        CircleShape cs=new CircleShape();
        cs.m_radius = r / Constant.RATE;
        FixtureDef fd=new FixtureDef();
        fd.density = 10;
        fd.friction = 4f;
        fd.restitution = 0.8f;
        fd.shape = cs;
        body.setUserData(color);
        body.createFixture(fd);
        return new MyCircleBody(r, body, color);
    }
}
