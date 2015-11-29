package com.mygdx.space;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Super class for projeciles describes how they move when fired.
 * Created by Stephen on 6/12/2015.
 */
public class Projectile {
    int damage;
    float speed;
    Texture texture;
    Sprite sprite;
    boolean piercing = false;
    float pathX;
    float pathY;
    float directionX;
    float directionY;
    Vector2 input;
    Random rand = new Random();
    boolean firing = false;
    public void motion(float x, float y){

    }
    // Gets initial direction to move
    public void move(float x, float y){
        input = new Vector2(x , y);
        double degrees = (float) ((Math.atan2(input.x - (sprite.getX() + sprite.getWidth() / 2), -(input.y - (sprite.getY() + sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
        sprite.setRotation((float)degrees);
        pathX = input.x - sprite.getX();
        pathY = input.y - sprite.getY();
        float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY) + 8;
        directionX = pathX / distance;
        directionY = pathY / distance;

    }
    // renders the object and has an anchor to remove after firing
    public void fly(){
        if(input != null && firing) {
            if (sprite.getX() >= input.x - 2 && sprite.getX() <= input.x + 2
                    && sprite.getY() >= input.y - 2 && sprite.getY() <= input.y + 2) {
                firing = false;
                sprite.setPosition(-50,-50);

            } else {
                sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
                sprite.setX(sprite.getX() + (directionX * speed));
                sprite.setY(sprite.getY() + (directionY * speed));
            }
        }
        }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public boolean isFiring() {
        return firing;
    }

    public void setFiring(boolean firing) {
        this.firing = firing;
    }

    public boolean isPiercing() {
        return piercing;
    }
    public void setPiercing(boolean piercing) {
        this.piercing = piercing;
    }
}
