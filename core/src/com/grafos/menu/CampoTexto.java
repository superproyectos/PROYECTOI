package com.grafos.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.grafos.Config;


public class CampoTexto
{
    private TextField texto;
    private Label label;
    public CampoTexto(float x,float y,int tipo)
    {
        Skin skin = new Skin(Gdx.files.internal("skin/light-mdpi/Holo-light-mdpi.json"));
        texto=new TextField("0",skin);

        label=new Label(tipo==1?"Entrada":"Salida",skin);
        texto.setX(x);
        texto.setY(y);
        label.setX(x);
        label.setY(y-30);
        label.setWidth(60);
        label.setHeight(50);
        label.setFontScale(0.6f);
        label.setColor(Config.color(60, 80, 100,1));
        texto.setWidth(60);
        texto.setHeight(50);
        Config.STAGE.addActor(label);
        Config.STAGE.addActor(texto);
    }
    public String getTexto()
    {
        return texto.getText();
    }
    //IBEAM
}
