package ru.geekbrains.stargame.screen.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.math.Rnd;

public class Ship extends Sprite {

    private Rect worldBounds;
    private Vector2 v = new Vector2();

    private Ship(TextureRegion region) {
        super(region);
    }

    public static Ship getInstance(TextureAtlas atlas){
        Texture texture = atlas.findRegion("main_ship").getTexture();
        TextureRegion region = new TextureRegion(texture,0,0,texture.getWidth()/2,texture.getHeight());
        return new Ship(region);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = 0;
        float posY = -0.3f;
        pos.set(posX, posY);
    }
}
