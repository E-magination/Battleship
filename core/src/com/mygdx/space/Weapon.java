package com.mygdx.space;

import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Super class for weapons describes how and when they fire
 * Created by Stephen on 6/12/2015.
 */
public class Weapon {
    int range;
    String name;
    Circle vision;
    Destructible target;
    ArrayList<Projectile> projectiles;
    Random rand = new Random();
    int accuracy;
    int fireRate;
    int curRate;
    int fixtureX;
    int fixtureY;
    boolean canFire = true;
    boolean inRange = false;



    public void acquireTarget(Destructible d){
        if(target == null) {
            this.target = d;
        }



    }
    public void fire(float x, float y){
        if(curRate <= 0){
            canFire = true;
            curRate = fireRate;
        }
        curRate --;
        if(vision.contains(target.getSprite().getX(), target.getSprite().getY())){
            if(canFire) {
                for (int i = 0; i < projectiles.size(); i++) {
                        while (projectiles.get(i).isFiring()) {
                            if (i >= projectiles.size() -1) {
                                break;
                            }
                            i++;
                        }
                        if (!projectiles.get(i).isFiring()) {
                            projectiles.get(i).getSprite().setPosition(x + fixtureX, y + fixtureY);

                            projectiles.get(i).move(target.getSprite().getX() + target.getSprite().getWidth()/2 + (rand.nextInt(accuracy) - accuracy/2),
                                    target.getSprite().getY() + target.getSprite().getHeight()/2 + (rand.nextInt(accuracy) - accuracy/2));
                        }
                            projectiles.get(i).setFiring(true);
                            canFire = false;
                            break;

                    }
                }
            for(Projectile p: projectiles) {
                    p.motion(target.getSprite().getX(), target.getSprite().getY());
            }

            }
        }

    public int getFixtureX() {
        return fixtureX;
    }

    public void setFixtureX(int fixtureX) {
        this.fixtureX = fixtureX;
    }

    public int getFixtureY() {
        return fixtureY;
    }

    public void setFixtureY(int fixtureY) {
        this.fixtureY = fixtureY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(ArrayList<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }


    public Circle getVision() {
        return vision;
    }

    public void setVision(Circle vision) {
        this.vision = vision;
    }

    public Destructible getTarget() {
        return target;
    }

    public void setTarget(Destructible target) {
        this.target = target;
    }

    public boolean isInRange() {
        return inRange;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }
}
