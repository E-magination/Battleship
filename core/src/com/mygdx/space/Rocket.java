package com.mygdx.space;


import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;

/**
 * Created by Stephen on 6/13/2015.
 */
public class Rocket extends Weapon {
    Rocket(float x, float y){
        range = 250;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 8;
        fixtureX = 8 + (rand.nextInt(8) *2);
        fixtureX = 8 + (rand.nextInt(8) *2);

        for(int i = 0; i < 2; i++){
            projectiles.add(new Missle());
        }
        fireRate = 30 * projectiles.size();
    }
    Rocket(float x, float y, boolean station){
        range = 250;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 8;
        fixtureX = rand.nextInt(64);
        fixtureY = rand.nextInt(64);

        for(int i = 0; i < 2; i++){
            projectiles.add(new Missle());
        }
        fireRate = 30 * projectiles.size();
    }
}
