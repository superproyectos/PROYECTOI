package com.grafos.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.grafos.Config;


public class CampoTexto
{
    private TextField texto;
    public CampoTexto(float x,float y,int tipo)
    {
        Skin skin = new Skin(Gdx.files.internal("skin/light-mdpi/Holo-light-mdpi.json"));
        texto=new TextField("0",skin);

        Etiqueta label=new Etiqueta(x,y -30,60,50,0.6f,Config.LABEL[tipo],Config.color(60, 80, 100,1));
        texto.setX(x);
        texto.setY(y);
        texto.setWidth(60);
        texto.setHeight(50);
        Config.STAGE.addActor(texto);
    }
    public String getTexto()
    {
        return texto.getText();
    }
    //IBEAM
}
