package ru.geekbrains.stargame.screen.sprites;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.math.Rnd;


public class Ship extends Sprite {

    private Vector2 v = new Vector2();
    private Rect worldBounds;

    Vector2 destination = new Vector2(0,-0.4f);


    private final float STEP = 0.01f;

    private Boolean presedLeft  = false;
    private Boolean presedRight = false;

    Vector2 buf = new Vector2();


    private BitmapFont font;



    private Ship(TextureRegion region) {
        super(region);
        v.set(0, 0);
        setHeightProportion(0.1f);
        font = new BitmapFont();
        font.setColor(Color.WHITE);
    }

    public static Ship getInstanse(TextureAtlas atlas) {
        TextureRegion texture = atlas.findRegion("main_ship");
        return new Ship(new TextureRegion(texture, texture.getRegionWidth() / 2, 0, texture.getRegionWidth() / 2, texture.getRegionHeight()));
    }


    @Override
    public void update(float delta) {
        if (presedRight){
            destination.x = destination.x + STEP;
        }

        if (presedLeft){
            destination.x = destination.x - STEP;
        }

        if (destination.x > worldBounds.getRight()){
            destination.x = worldBounds.getRight();
        }

        if (destination.x > 0){
            if (destination.x > worldBounds.getRight()){
                destination.x = worldBounds.getRight();
            }
        }

        if (destination.x < 0){
            if (destination.x < worldBounds.getLeft()){
                destination.x = worldBounds.getLeft();
            }
        }

        pos.set(destination);

    }

    public void keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.RIGHT:
                presedRight = true;
                break;
            case Input.Keys.LEFT:
                presedLeft = true;
                break;
        }
    }


    public void keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.RIGHT:
                presedRight = false;
                break;
            case Input.Keys.LEFT:
                presedLeft = false;
                break;
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        pos.set(destination);
    }
}
