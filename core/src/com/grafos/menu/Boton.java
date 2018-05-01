package com.grafos.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
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
        this.tipo=tipo;
        boton = new TextButton(s,Config.SKIN);
        boton.setX(x);
        boton.setY(y);
        boton.setHeight(50);
        boton.setWidth(ancho);
        oyente();
        Config.STAGE.addActor(boton);
    }
    public Boton(float x,float y,int tipo,CampoTexto A,CampoTexto B,String s,float ancho)
    {
        this.tipo=tipo;
        boton = new TextButton(s, Config.SKIN);
        boton.setX(x);
        boton.setY(y);
        boton.setHeight(50);
        boton.setWidth(ancho);
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
                        Titulo.setTexto("Algortimo de Prim");
                        break;
                    case 1:
                        Grafos.grafo.Dijktra(Integer.parseInt("0"+A.getTexto()),Integer.parseInt("0"+B.getTexto()));
                        Titulo.setTexto("Algoritmo de Dijkstra");
                        break;
                    case 2:
                        new SelectorDeArchivo();
                        Titulo.setTexto("Grafo Introducido");
                        break;
                    case 3:
                        int a=Integer.parseInt("0"+A.getTexto()),b=Integer.parseInt("0"+B.getTexto());
                        if(b<=a*(a-1)/2)
                        {
                            Grafos.grafo.clear();
                            Grafos.grafo.grafoRandom(a,b);
                        }
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
