package ru.geekbrains.stargame.screen.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;



public class Life extends Sprite {

    private static final float HEIGHT = 0.02f;
    //private static final float TOP = -0.09f;


    public Life(TextureRegion region) {
        super(region);
         setLeft(0.3f);
         setBottom(-0.45f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }

}
