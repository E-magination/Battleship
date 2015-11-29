package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Stephen on 6/12/2015.
 */
public class Beam extends Projectile {
int init = 3;
    int direction = 0;
    Beam(int i){
        speed = 0;
        damage = 2;
        texture = new Texture(Gdx.files.internal("Projectiles/lazer.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
        sprite.setSize(2, 2);
        piercing = true;
        sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        direction = i;
    }
    public void move(float x, float y){
        input = new Vector2(x , y);
        double degrees = (float) ((Math.atan2(input.x - (sprite.getX() + sprite.getWidth() / 2), -(input.y - (sprite.getY() + sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
        sprite.setRotation((float) degrees);
        direction = rand.nextInt(2);



    }
    public void fly(){

        if(input != null && firing) {
            init --;
            if (init <= 0) {
                init = 60;
                firing = false;
                sprite.setSize(0,0);
                sprite.setPosition(-50,-50);

            } else {

                System.out.println(direction + "i");
                pathX = input.x  - sprite.getX();
                pathY = input.y  - sprite.getY();
                float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY) +12;
                directionX = pathX / distance;
                directionY = pathY / distance;
                sprite.setSize(1, 200);
                sprite.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
                if(direction == 0) {
                    sprite.rotate(1);
                }else{
                    sprite.rotate(-1);
                }
                sprite.setX(sprite.getX() + (directionX * speed));
                sprite.setY(sprite.getY() + (directionY * speed));
            }
        }
    }

}
