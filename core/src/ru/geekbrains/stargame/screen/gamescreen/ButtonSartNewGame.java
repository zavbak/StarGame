package ru.geekbrains.stargame.screen.gamescreen;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.stargame.base.ActionListener;
import ru.geekbrains.stargame.base.ScaledTouchUpButton;
import ru.geekbrains.stargame.math.Rect;

public class ButtonSartNewGame extends ScaledTouchUpButton {

    private static final float HEIGHT = 0.1f;
    private static final float BOTTOM_MARGIN = 0.009f;

    public ButtonSartNewGame(TextureAtlas atlas, ActionListener actionListener, float pressScale) {
        super(atlas.findRegion("button_new_game"), actionListener, pressScale);
        setHeightProportion(HEIGHT);
        setBottom(BOTTOM_MARGIN);

    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom() + 0.3f);
    }
}
