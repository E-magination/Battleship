package com.mygdx.space;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*This is the main game class that gets everything started and makes
sure that everything gets rendered and creates singles instances
of single use classes such as save manager or sound managager*/

public class Space extends Game {


    /*Create is called when the game first starts*/
	@Override
	public void create () {
        setScreen(new PlayScreen(this));

	}
    /* super.render will render any dependent classes of the game class*/
	@Override
	public void render () {
		super.render();
	}
    /*This will dispose all other dependent screens when game closes*/
    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    /*this will resize everything depending on camera boundaries*/
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
