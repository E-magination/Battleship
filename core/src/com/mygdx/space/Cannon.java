package com.mygdx.space;


import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;

/**
 * basic accurate weapon
 * Created by Stephen on 6/13/2015.
 */
public class Cannon extends Weapon {
    Cannon(float x, float y){
        range = 125;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 16;
        fixtureX = rand.nextInt(2)*16 + 8;
        fixtureY = rand.nextInt(2)*16 + 8;

        for(int i = 0; i < 3; i++){
            projectiles.add(new Ball());
        }
        fireRate = 45;
    }
}
