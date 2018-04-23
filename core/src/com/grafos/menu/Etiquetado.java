package com.grafos.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Etiquetado
{
    private SpriteBatch batch;
    private BitmapFont font;
    private String texto;
    private int h;
    public Etiquetado(String s,int h)
    {
        texto=s;
        font = new BitmapFont();
        font.getData().setScale(0.9f);
        this.h=h;
        batch=new SpriteBatch();
    }
    public void dibujar()
    {
        batch.begin();
        font.draw(batch,texto,0,h-20+font.getLineHeight()/2,Gdx.graphics.getWidth(),1,true);
        batch.end();
    }

}
