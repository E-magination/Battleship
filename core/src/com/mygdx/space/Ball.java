package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Basic primary weapon for all ships
 * Created by Stephen on 6/12/2015.
 */
public class Ball extends Projectile {

    Ball(){
        speed = 3;
        damage = 3;
        texture = new Texture(Gdx.files.internal("Projectiles/ball.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
        sprite.setSize(2, 2);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
    }

}
