package com.grafos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class Vertice extends Actor
{
    private ShapeRenderer shape;
    private BitmapFont font;
    private int numero;
    public Vertice(float x,float y,int numero)
    {
        shape=new ShapeRenderer();
        this.setHeight(50);
        this.setWidth(50);
        this.setX(x);
        this.setY(y);
        this.numero=numero;
        font = new BitmapFont();
        font.setColor(Color.TEAL);
        shape.setColor(Color.CYAN);

        addListener(new DragListener()
        {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer)
            {
                moveBy(x - getWidth()/2, y - getHeight()/2);
            }
        });

    }
    @Override
    public void draw (Batch batch, float parentAlpha)
    {
        super.draw(batch,parentAlpha);
        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(this.getX()+25, this.getY()+25, 25);
        shape.end();
        batch.begin();
        font.draw(batch,Integer.toString(numero),this.getX(),this.getY()+getHeight()/2+font.getXHeight()/2,getWidth(),1,true);

    }
    @Override
    public void act (float delta)
    {
        super.act(delta);
    }
}
