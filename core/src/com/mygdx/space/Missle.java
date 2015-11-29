package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Stephen on 6/12/2015.
 */
public class Missle extends Projectile {

    Missle(){
        speed = 3;
        damage = 6;
        texture = new Texture(Gdx.files.internal("Projectiles/missle.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
        sprite.setSize(10, 10);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
    }

    /* Allows the missle to be homing*/
    public void motion(float x, float y){
        if(input != null) {
            input.set(x, y);
            double degrees = (float) ((Math.atan2(input.x - (sprite.getX() + sprite.getWidth() / 2), -(input.y - (sprite.getY() + sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
            sprite.setRotation((float)degrees);
        }

    }
    public void move(float x, float y){
        input = new Vector2(x , y);
        double degrees = (float) ((Math.atan2(input.x - (sprite.getX() + sprite.getWidth() / 2), -(input.y - (sprite.getY() + sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
        sprite.setRotation((float)degrees);


    }
    public void fly(){

        if(input != null && firing) {
            if (sprite.getX() >= input.x - 2 && sprite.getX() <= input.x + 2
                    && sprite.getY() >= input.y - 2 && sprite.getY() <= input.y + 2) {
                firing = false;
                sprite.setPosition(-50,-50);

            } else {
                sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
                float pathX = input.x - sprite.getX();
                float pathY = input.y - sprite.getY();

                float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY);
                float directionX = pathX / distance;
                float directionY = pathY / distance;


                sprite.setX(sprite.getX() + (directionX * speed));
                sprite.setY(sprite.getY() + (directionY * speed));


            }
        }
    }
}
