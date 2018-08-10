package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture imgSpase;
	DrawFone drowFone;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		imgSpase = new Texture("spase.png");
		drowFone = new DrawFone(batch);
	}

	@Override
	public void render () {

		Gdx.app.getGraphics().getWidth();
		Gdx.app.getGraphics().getHeight();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		draw();
		batch.end();
	}


	private void draw(){
		drowFone.draw();
	}

	@Override
	public void dispose () {
		batch.dispose();
		imgSpase.dispose();
	}
}
