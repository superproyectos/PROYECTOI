package com.grafos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Lado
{
    Vertice A;
    Vertice B;
    int peso;
    ShapeRenderer shape;
    SpriteBatch batch;
    private BitmapFont font;
    public Lado(Vertice A,Vertice B,int peso)
    {
        this.A=A;
        this.B=B;
        this.peso=peso;
        shape=new ShapeRenderer();
        batch=new SpriteBatch();
        font = new BitmapFont();
        font.setColor(133/255f, 193/255f, 233/255f,1);
        shape.setColor(44/255f, 62/255f, 80/255f,1);
    }
    public void dibujaLado()
    {

        if(B!=A)
        {
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.line(A.getX()+A.getWidth()/2, A.getY()+A.getWidth()/2,B.getX()+A.getWidth()/2,B.getY()+A.getWidth()/2);
            shape.end();
            batch.begin();
            font.draw(batch," "+peso,(A.getX()+B.getX()+A.getWidth())/2+1,(A.getY()+B.getY()+A.getHeight())/2+1);
            batch.end();
        }
        else
        {
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.circle(A.getX()+A.getWidth()/2, A.getY(),A.getWidth()/3);
            shape.end();
            batch.begin();
            font.draw(batch," "+peso,A.getX()+A.getWidth()/2,A.getY()-A.getHeight()/2);
            batch.end();
        }
    }
}
