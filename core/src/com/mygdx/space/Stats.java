package com.mygdx.space;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Thiss will hold all getters and setters for attributes
 * of a destructible object to make saving easier
 * Created by Stephen on 6/12/2015.
 */
public class Stats {
    Vector2 position;
    Vector2 size;
    int current_hp;
    int maximum_hp;
    boolean alive;
    float speed;
    String name;
    Rectangle bounds;
    int xp;
    int maxXp;
    int lvl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public int getCurrent_hp() {
        return current_hp;
    }

    public void setCurrent_hp(int current_hp) {
        this.current_hp = current_hp;
    }

    public int getMaximum_hp() {
        return maximum_hp;
    }

    public void setMaximum_hp(int maximum_hp) {
        this.maximum_hp = maximum_hp;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
