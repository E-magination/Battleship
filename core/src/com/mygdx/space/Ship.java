package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * the basic ships in the game
 * Created by Stephen on 6/12/2015.
 */
public class Ship extends Destructible {

    Ship(){}

    Ship(float x, float y, boolean b){
        stats.setCurrent_hp(1000);
        stats.setAlive(true);
        stats.setName("enemy");
        stats.setSpeed(2.5f);
        texture = new Texture(Gdx.files.internal("Destructables/V_ship.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setSize(18, 18);
        sprite.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        weapons.add(new Cannon(sprite.getX(), sprite.getY()));
        vision = new Circle();
        input = new Vector2();




    }
    Ship(float x, float y){
        stats.setCurrent_hp(100);
        stats.setAlive(true);
        stats.setName("enemy");
        stats.setSpeed(2.5f);
        texture = new Texture(Gdx.files.internal("Destructables/fleet.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setSize(18, 18);
        sprite.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        weapons.add(new Cannon(sprite.getX(), sprite.getY()));
        vision = new Circle();
        input = new Vector2();


    }
    /*this will be the main A.I. for ships */
    public void move(){
        vision.setPosition(sprite.getX(), sprite.getY());
        for(Weapon w: weapons){
            w.getVision().setPosition(sprite.getX() + w.getFixtureX(),sprite.getY() + w.getFixtureY());
        }
        sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
      // if they are below 0 health destroy them
        if(stats.getCurrent_hp() <= 0){
            stats.setAlive(false);
        }
        rotate();
        if(target == null) {
            if (sprite.getX() < 420) {
                sprite.setX(sprite.getX() + 1);
            }
            if (sprite.getY() < 390) {
                sprite.setY(sprite.getY() + 1);
            }
        }


    }
    public void rotate(){
        // rotate to face your target
        if(target != null) {
            input.set(target.getSprite().getX(), target.getSprite().getY());
            double degrees = (float) ((Math.atan2(input.x - (sprite.getX() + sprite.getWidth() / 2), -(input.y - (sprite.getY() + sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
            sprite.setRotation((float) degrees);
        }


    }
}
