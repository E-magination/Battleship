package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Stephen on 6/27/2015.
 */
public class Bouncer extends Projectile {
    int init = 60;
    Bouncer() {
        speed = 4;
        damage = 1;
        texture = new Texture(Gdx.files.internal("Projectiles/zap.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
        sprite.setSize(7, 7);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        piercing = true;
    }


    public void fly(){

        if(input != null && firing) {
            init --;
            if (init <= 0) {
                init = 60;
                firing = false;
                sprite.setPosition(-50,-50);

            } else {
                sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
                sprite.rotate(3);
                sprite.setX(sprite.getX() + (directionX * speed));
                sprite.setY(sprite.getY() + (directionY * speed));
            }
        }
    }


}
