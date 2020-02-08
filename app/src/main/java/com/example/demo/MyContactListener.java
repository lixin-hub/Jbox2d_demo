package com.example.demo;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Body;
import android.graphics.Color;

public class MyContactListener implements ContactListener
{

    @Override
    public void beginContact(Contact p1)
    {
        Body body1=p1.getFixtureB().getBody();
        if (body1.getType() == BodyType.STATIC)
        {
            body1.setUserData(Color.BLUE);
        }
    }

    @Override
    public void endContact(Contact p1)
    {
        // TODO: Implement this method
    }

    @Override
    public void preSolve(Contact p1, Manifold p2)
    {
        // TODO: Implement this method
    }

    @Override
    public void postSolve(Contact p1, ContactImpulse p2)
    {
        // TODO: Implement this method
    }

}
