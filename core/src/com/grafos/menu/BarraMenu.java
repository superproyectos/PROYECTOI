package com.grafos.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class BarraMenu extends Rectangle
{
    private ShapeRenderer shape;
    private Color color;
    public BarraMenu(int x, int y,int h, Color color)
    {
        this.x=x;
        this.y=y;
        this.width=Gdx.graphics.getWidth();
        this.height=h;
        this.color=color;
        shape=new ShapeRenderer();
    }
    public void dibujar()
    {
        shape.begin(ShapeRenderer.ShapeType.Filled);
            shape.setColor(color);
            shape.rect(x,y,width,height);
            shape.setColor(color.r-0.02f,color.g-0.02f,color.b-0.02f,1);
            shape.rect(x,y-30,width,30);
        shape.end();
    }

}
