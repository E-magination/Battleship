package com.mygdx.space;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is where all the action happens will hold all the destructables
 * and friendly that will be in the game.
 * Created by Stephen on 6/12/2015.
 */
public class PlayScreen implements Screen {
    Game game;
    ArrayList<Destructible> friendly;
    ArrayList<Destructible> empire;
    SpriteBatch batch;
    Random rand;


    public PlayScreen(Game game){
    this.game = game;
    }
    /* This is called when it is first created*/
    @Override
    public void show() {
        batch = new SpriteBatch();
        friendly = new ArrayList();
        empire = new ArrayList();
        rand = new Random();
        friendly.add(new Player_Ship());
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));
        friendly.add(new Ship(rand.nextInt(300),rand.nextInt(300),true));

        empire.add(new BattleStation(440,400));



    }
    /*This is called multiple times this is where you update images
    * and data*/
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.2f, .2f, .2f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(int i = 0; i < 2; i++){
            if(i == 0)
               updateTeams(friendly, empire);
            else
                updateTeams(empire, friendly);
        }
        removeDead(friendly,empire);









        batch.end();

    }
    /* resize if you use a camera to adjust everything accordingly*/
    @Override
    public void resize(int width, int height) {

    }
    /*Call this when the game gets paused*/
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
    /*Destroy anything associated with playscreen here when it exits*/
    @Override
    public void dispose() {

    }
    public void updateTeams(ArrayList<Destructible> a, ArrayList<Destructible> b){
        for(Destructible d: a){
            d.getSprite().draw(batch);
            d.move();
            for(Weapon w: d.getWeapons()){
                for(Destructible e: b) {
                    if(w.getTarget() != null) {
                        if (w.getVision().contains(w.getTarget().getSprite().getX(), w.getTarget().getSprite().getY())) {
                            w.fire(d.getSprite().getX(),d.getSprite().getY());
                            break;
                        }
                        else{
                            w.setTarget(null);
                            d.setTarget(null);
                        }
                    }
                    else if (w.getVision().contains(e.getSprite().getX(), e.getSprite().getY())) {
                        w.acquireTarget(e);
                        d.acquireTarget(e);
                        break;
                    }
                }
                for(Projectile p: w.getProjectiles()){
                    p.fly();
                    p.getSprite().draw(batch);
                    for(Destructible e: b){
                        if(p.getSprite().getBoundingRectangle().overlaps(e.getSprite().getBoundingRectangle())){
                            e.isHit(p.getDamage());
                            if(!p.isPiercing()) {
                                p.getSprite().setPosition(-50, -50);
                                p.setFiring(false);
                            }
                        }
                    }
                }

            }
        }

    }
    public void removeDead(ArrayList<Destructible> a, ArrayList<Destructible> b){
        for(int i = 0; i < a.size(); i ++){
            if(!a.get(i).isDead()){
                a.get(i).destroy();
                a.remove(i);
            }
        }
        for(int i = 0; i < b.size(); i ++){
            if(!b.get(i).isDead()){
                b.get(i).destroy();

                b.remove(i);

            }
        }

    }

}
