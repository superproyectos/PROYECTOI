package com.grafos.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.grafos.Config;
import com.grafos.Grafos;

public class Boton
{
    private TextButton boton;
    private CampoTexto A,B;
    private int tipo;
    public Boton(float x,float y,int tipo,String s, float ancho)
    {
        Skin skin = new Skin(Gdx.files.internal("skin/light-mdpi/Holo-light-mdpi.json"));
        this.tipo=tipo;
        boton = new TextButton(s, skin);
        boton.setX(x);
        boton.setY(y);
        boton.setHeight(50);
        boton.setWidth(ancho);
        oyente();
        Config.STAGE.addActor(boton);
    }
    public Boton(float x,float y,CampoTexto A,CampoTexto B)
    {
        Skin skin = new Skin(Gdx.files.internal("skin/light-mdpi/Holo-light-mdpi.json"));
        this.tipo=1;
        boton = new TextButton("Algortimo de Dijkstra", skin);
        boton.setX(x);
        boton.setY(y);
        boton.setHeight(50);
        boton.setWidth(Config.W/3);
        this.A=A;
        this.B=B;
        oyente();
        Config.STAGE.addActor(boton);
    }
    public void setWidth(float w)
    {
        boton.setWidth(w);
    }
    private void oyente()
    {
        boton.addListener(new ClickListener()
        {

            @Override
            public void clicked(InputEvent event, float x, float y)
            {

                switch (getTipo())
                {
                    case 0:
                        Grafos.grafo=Grafos.grafo.Prim();
                        Etiquetado.setTexto("Algortimo de Prim");
                        break;
                    case 1:
                        Grafos.grafo.Dijktra(Integer.parseInt("0"+A.getTexto()),Integer.parseInt("0"+B.getTexto()));
                        Etiquetado.setTexto("Algoritmo de Dijkstra");
                        break;
                    case 2:
                        new SelectorDeArchivo();
                        Etiquetado.setTexto("Grafo Introducido");
                        break;
                    case 3:
                        Grafos.grafo.clear();
                        Grafos.grafo.grafoRandom(7,Config.aleatorio(21)+1);
                        break;
                }

            }

        });
    }
    public int getTipo()
    {
        return tipo;
    }
}
