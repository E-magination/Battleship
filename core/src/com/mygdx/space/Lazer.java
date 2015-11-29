package com.mygdx.space;


import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;

/**
 * quick fire weapon not very accurate
 * Created by Stephen on 6/13/2015.
 */
public class Lazer extends Weapon {
    Lazer(float x, float y){
        range = 100;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 2;
        fixtureX = 16;
        fixtureY = 16;

        for(int i = 0; i < 1; i++){
            projectiles.add(new Beam(i));
        }
        fireRate = 60;

    }
    Lazer(float x, float y, boolean station){
        range = 200;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 2;
        fixtureX = 8 + rand.nextInt(48);
        fixtureY = 8 + rand.nextInt(48);

        for(int i = 0; i < 2; i++){
            projectiles.add(new Beam(i));
        }
        fireRate = 30;

    }

}
