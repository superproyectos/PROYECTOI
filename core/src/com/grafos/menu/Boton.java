package com.grafos.menu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.grafos.Config;

public class Boton
{
    private BitmapFont font;
    private TextButton boton;
    private int tipo;
    public Boton(float x,float y,int tipo,String s)
    {
        font = new BitmapFont();
        TextButton.TextButtonStyle a=new TextButton.TextButtonStyle();
        a.font=font;
        this.tipo=tipo;
        boton = new TextButton(s, a);
        boton.setX(x);
        boton.setY(y);
        boton.setHeight(50);
        boton.setWidth(Config.W/3);

        boton.addListener(new ClickListener()
        {

            @Override
            public void clicked(InputEvent event, float x, float y)
            {

                switch (getTipo())
                {
                    case 0:
                        Etiquetado.setTexto("Algortimo de Prim");
                        break;
                    case 1:
                        Etiquetado.setTexto("Algoritmo de Dijkstra");
                        break;
                    case 2:
                        new SelectorDeArchivo();
                        Etiquetado.setTexto("Grafo Introducido");
                        break;
                }

            }

        });
        Config.STAGE.addActor(boton);
    }
    public int getTipo()
    {
        return tipo;
    }
}
