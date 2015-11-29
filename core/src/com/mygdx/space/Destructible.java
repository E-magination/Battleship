package com.mygdx.space;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * This is the superclass of anything that can be hit
 * any object in the game with hit points will fall under
 * this category
 * Created by Stephen on 6/12/2015.
 */
public abstract class Destructible {
    Stats stats;
    Texture texture;
    Sprite sprite;
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    Circle vision;
    Destructible target;
    Vector2 input;
    Destructible(){
        stats = new Stats();
        sprite = new Sprite();


    }
    public void isHit(int dmg){
        stats.setCurrent_hp(stats.getCurrent_hp() - dmg);
    }

    public void save(){

    }

    public void load(){

    }
    public void destroy(){
        sprite.setPosition(-50,-50);
        texture.dispose();


    }
    public void move(){
        if(stats.getCurrent_hp() <= 0){
            stats.setAlive(false);
        }

    }
    public void draw(SpriteBatch batch){
        batch.draw(sprite,stats.getPosition().x,stats.getPosition().y,stats.getSize().x,stats.getSize().y);

    }
    public void acquireTarget(Destructible t){
        if(target == null){
            target = t;
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    public boolean isDead(){
        return stats.isAlive();
    }

    public Destructible getTarget() {
        return target;
    }

    public void setTarget(Destructible target) {
            this.target = target;
    }

    public Circle getVision() {
        return vision;
    }

    public void setVision(Circle vision) {
        this.vision = vision;
    }
}
