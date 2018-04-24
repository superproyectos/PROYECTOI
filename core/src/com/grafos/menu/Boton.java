package com.grafos.menu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.grafos.Config;

public class Boton
{
    private BitmapFont font;
    private TextButton boton;
    public Boton(float x,float y,String s)
    {
        font = new BitmapFont();
        TextButton.TextButtonStyle a=new TextButton.TextButtonStyle();
        a.font=font;
        boton = new TextButton(s, a);
        boton.setX(x);
        boton.setY(y);
        boton.setHeight(50);
        boton.setWidth(Config.W/3);
        Config.STAGE.addActor(boton);
    }
}
