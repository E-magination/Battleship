package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * This will be the players ship which will respond to inputs
 * and is what the camera and everything will be based around.
 * Created by Stephen on 6/12/2015.
 */

public class Player_Ship extends Ship {


    Player_Ship(){

        stats.setLvl(1);
        stats.setMaxXp(100);
        stats.setXp(0);
        stats.setAlive(true);
        stats.setMaximum_hp(100);
        stats.setCurrent_hp(100);
        stats.setName("player");

        stats.setSpeed(1.8f);
        texture = new Texture(Gdx.files.internal("Destructables/T_ship.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
        sprite.setSize(32, 32);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        //weapons.add(new Rocket(sprite.getX(), sprite.getY()));
        weapons.add(new Gatling(sprite.getX(),sprite.getY()));
        weapons.add(new Glaive(sprite.getX(),sprite.getY()));
       // weapons.add(new Lazer(sprite.getX(),sprite.getY()));




    }
/*these are used to calculate the rotation and movement direction*/
    Vector2 input = new Vector2();
    boolean turn = false;
    double degrees;
    double acceleration = .01;
    /*This is a listener to whenever there is a click it will figure out how much degrees to turn
    * and how far to move the player*/
    public void move(){
        for(Weapon w: weapons){
            w.getVision().setPosition(sprite.getX() + w.getFixtureX(),sprite.getY() + w.getFixtureY());
        }
        if(Gdx.input.justTouched()) {
            input = new Vector2(Gdx.input.getX(), 480 - Gdx.input.getY());
           findDegrees();
        }
        rotate();
        accelerate();

    }
    /*This calculates the amount to turn */
    public void findDegrees(){
        turn = true;
        degrees = (float) ((Math.atan2(input.x - (sprite.getX() + sprite.getWidth() / 2), -(input.y - (sprite.getY() + sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
        if(degrees - sprite.getRotation() > 180){
            degrees -= 360;
        }else if (sprite.getRotation() - degrees > 180){
            degrees += 360;
        }
    }
    /* this makes the ship have acceleration*/
    public void accelerate(){

        if(sprite.getX() >= input.x - 2 && sprite.getX() <= input.x + 2
                && sprite.getY() >= input.y - 2 && sprite.getY() <= input.y + 2) {
            acceleration = 0;

        }else{
            float pathX = input.x - sprite.getX();
            float pathY = input.y - sprite.getY();

            float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY);
            float directionX = pathX / distance;
            float directionY = pathY / distance;


                sprite.setX(sprite.getX() + (directionX * stats.getSpeed()) * (float) acceleration);
                sprite.setY(sprite.getY() + (directionY * stats.getSpeed()) * (float) acceleration);
            if ( distance > 50) {
                acceleration += .005;
                if (acceleration >= 1) {
                    acceleration = 1;
                }
            }
            else{
                acceleration -= .005;
                if (acceleration <= .2){
                    acceleration = .2;
                }
            }
        }


    }
    /*Spins the ship towards the mouse click*/
    public void rotate(){
        if(turn) {
                if (degrees > sprite.getRotation()) {
                    sprite.setRotation((sprite.getRotation() + stats.getSpeed()) % 360);
                } else {
                    sprite.setRotation((sprite.getRotation() - stats.getSpeed()) % 360);
                }
                if (sprite.getRotation() >= degrees - 2 && sprite.getRotation() <= degrees + 2) {
                    turn = false;
                }
            }
        }


}
