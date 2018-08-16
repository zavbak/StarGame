package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGame extends Base2DScreen {
	SpriteBatch batch;
	//Texture imgMario;
	DrawFone drowFone;
	Mario mario;

	InfoText infoText;

	int step;

	public StarGame(Game game) {
		super(game);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		//imgMario = new Texture("spase.png");
		drowFone = new DrawFone(batch);
		mario = new Mario(batch);
		infoText = new InfoText(batch);
		infoText.setPosition(new Vector2(Gdx.graphics.getWidth() - 100,20));
	}




	@Override
	public void render (float delta) {
		Gdx.app.getGraphics().getWidth();
		Gdx.app.getGraphics().getHeight();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		draw();
		batch.end();
		nextStep();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		mario.setDestination(new Vector2(screenX,Gdx.graphics.getHeight() - screenY ));
		return false;
	}

	private void nextStep(){
		mario.go();
		step ++;
		infoText.setText("Step: " + step);
	}

	private void draw(){
		drowFone.draw();
		mario.draw();
		infoText.draw();
	}

	@Override
	public void dispose () {
		mario.dispose();
		batch.dispose();
		//imgMario.dispose();
	}
}
