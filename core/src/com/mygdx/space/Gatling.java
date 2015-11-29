package com.mygdx.space;


import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;

/**
 * quick fire weapon not very accurate
 * Created by Stephen on 6/13/2015.
 */
public class Gatling extends Weapon {
    Gatling(float x, float y){
        range = 150;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 64;
        fixtureX = rand.nextInt(2)*16 + 8;
        fixtureY = rand.nextInt(2)*16 + 8;

        for(int i = 0; i < 7; i++){
            projectiles.add(new Bullet());
        }
        fireRate = 15;
    }
    Gatling(float x, float y,boolean station){
        range = 200;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 128;
        fixtureX = rand.nextInt(64);
        fixtureY = rand.nextInt(64);

        for(int i = 0; i < 7; i++){
            projectiles.add(new Bullet());
        }
        fireRate = 10;
    }
}
