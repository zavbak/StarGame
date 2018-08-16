package ru.geekbrains.stargame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Mario {
    SpriteBatch batch;
    Texture imgSpase;

    InfoText infoText;

    Vector2 position;
    Vector2 destination;
    Vector2 direction;

    float speed;
    Vector2 velocity;

    float distance;

    public void setDestination(Vector2 destination) {
        this.destination = destination;
    }


    private void setDistanse(){
        distance = position.dst(destination);
    }

    private void setDirection(){
        direction.set(destination).sub(position).nor();
    }

    private void setVelocity(){
        velocity.set(direction).scl(speed);
    }


    public Mario(SpriteBatch batch) {
        this.batch = batch;
        imgSpase = new Texture("mario.png");
        infoText = new InfoText(batch);

        position    = new Vector2(100,100);
        destination = new Vector2(position.x,position.y);

        direction   = new Vector2(0.0f,0.0f);
        speed = 0.3f;
        velocity = new Vector2(0.0f,0.0f);
    }

    public void draw() {
        int width = 0;
        int hight = 0;
        batch.draw(imgSpase, position.x, position.y);

        infoText.setText("point:" + position.x + " " + position.y + "\n" +
                         "destination:"  + destination.x + " " + destination.y + "\n" +
                         "distance:"     + distance + "\n" +
                         "direction:"    + direction.x + " " + direction.y + "\n" +
                         "speed: (" + speed + ") " + velocity.x + " " + velocity.y + "\n");
        infoText.setPosition(new Vector2(position.x, position.y -10));
        infoText.draw();

    }

    public void go(){

        setDistanse();
        setDirection();
        setVelocity();

        Vector2 movement = new Vector2();

        movement.set(velocity);
        if (position.dst2(destination) > movement.len2()) {
            position.add(movement);
        } else {
            position.set(destination);
        }

        //position.add(velocity);
    }

    public void dispose(){
        imgSpase.dispose();
    }
}
