package com.grafos.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import com.grafos.Config;


public class CampoTexto
{
    private TextField texto;
    public CampoTexto()
    {
        BitmapFont font = new BitmapFont();
        TextField.TextFieldStyle a=new TextField.TextFieldStyle();
        a.font=font;
        Sprite q=new Sprite(new Texture(1,10,Pixmap.Format.RGB888));
        a.cursor=new SpriteDrawable(q);
        a.fontColor=Color.WHITE;
        texto=new TextField("INICIO",a);
        texto.setX(20);
        texto.setY(20);
        texto.setWidth(200);
        texto.setHeight(50);
        Config.STAGE.addActor(texto);
    }
    //IBEAM
}
