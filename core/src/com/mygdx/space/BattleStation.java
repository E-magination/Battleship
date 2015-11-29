package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Stephen on 6/27/2015.
 */
public class BattleStation extends Destructible {
    BattleStation(float x, float y){
        stats.setCurrent_hp(2500);
        stats.setAlive(true);
        stats.setName("enemy");
        stats.setSpeed(0);
        texture = new Texture(Gdx.files.internal("Destructables/stationA.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setSize(64, 64);
        sprite.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        weapons.add(new Rocket(sprite.getX(), sprite.getY(),true));
        weapons.add(new Rocket(sprite.getX(), sprite.getY(),true));
        weapons.add(new Rocket(sprite.getX(), sprite.getY(),true));
        weapons.add(new Rocket(sprite.getX(),sprite.getY(),true));
        weapons.add(new Gatling(sprite.getX(),sprite.getY(),true));
        weapons.add(new Gatling(sprite.getX(),sprite.getY(),true));
        weapons.add(new Gatling(sprite.getX(),sprite.getY(),true));
        weapons.add(new Lazer(sprite.getX(),sprite.getY(),true));
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);

        vision = new Circle();
        input = new Vector2();

    }
    public void move(){
        sprite.rotate(1);
    }
}
