package com.grafos.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.grafos.Config;

public class Etiqueta
{
    private Label label;
    public Etiqueta(float x,float y,float w,float h,float scale, String texto, Color color)
    {
        label=new Label(texto,Config.SKIN);
        label.setX(x);
        label.setY(y);
        label.setWidth(w);
        label.setHeight(h);
        label.setFontScale(scale);
        label.setColor(color);
        Config.STAGE.addActor(label);
    }
    public void setTexto(String s)
    {
        label.setText(s);
    }
}
