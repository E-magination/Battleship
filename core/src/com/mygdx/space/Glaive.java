package com.mygdx.space;


import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;

/**
 * can fire through targets and hit multiple targets very inaccurate against moving targets
 * Created by Stephen on 6/13/2015.
 */
public class Glaive extends Weapon {
    Glaive(float x, float y){
        range = 200;
        vision = new Circle(x,y,range);
        target = null;
        projectiles = new ArrayList();
        accuracy = 8;
        fixtureX = rand.nextInt(2)*16 + 8;
        fixtureY = rand.nextInt(2)*16 + 8;

        for(int i = 0; i < 2; i++){
            projectiles.add(new Bouncer());
        }
        fireRate = 90 * projectiles.size();
    }


}
