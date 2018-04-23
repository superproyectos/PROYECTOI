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
        //final int curva=25;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(color);
        shape.rect(x,y,width,height);
        shape.setColor(color.r-0.02f,color.g-0.02f,color.b-0.02f,1);
        shape.rect(x,y-30,width,30);
        /*shape.rect(x+curva,y-curva,width-2*curva,height);
        shape.circle(x+curva,y,curva);
        shape.circle(width-curva,y,curva);*/
        shape.end();
    }

}
