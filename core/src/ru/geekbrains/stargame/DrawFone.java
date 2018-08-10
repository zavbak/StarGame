package ru.geekbrains.stargame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DrawFone {

    SpriteBatch batch;
    Texture imgSpase;

    public DrawFone(SpriteBatch batch) {
        this.batch = batch;
        imgSpase = new Texture("spase.png");
    }

    private void drawLine(int hight) {
        int widthMax = Gdx.app.getGraphics().getWidth();
        int width = 0;

        do {
            batch.draw(imgSpase, width, hight);
            width += imgSpase.getWidth();
        } while (width < widthMax);
    }

    public void draw() {

        int hightmax = Gdx.app.getGraphics().getHeight();
        int hight = 0;

        do{
            drawLine(hight);
            hight += imgSpase.getHeight();
        }while (hight < hightmax);

    }

}
