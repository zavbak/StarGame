package ru.geekbrains.stargame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class InfoText {

    SpriteBatch batch;
    private BitmapFont font;
    private String text;

    Vector2 position;


    public InfoText(SpriteBatch batch) {
        this.batch = batch;
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        position = new Vector2(0,0);
        text = "";
    }


    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void draw(){
        font.draw(batch,text,position.x,position.y);
    }
}
