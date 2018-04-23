package com.grafos.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Menu
{
    private BarraMenu barra;
    private Etiquetado etiqueta;

    public Menu()
    {
        final int h=50;
        barra=new BarraMenu(0,Gdx.graphics.getHeight()-h,h,new Color(40/255f, 55/255f, 71/255f,1));
        etiqueta=new Etiquetado("Grafo Introducido",Gdx.graphics.getHeight()-h);
    }

    public void dibujar()
    {
        barra.dibujar();
        etiqueta.dibujar();
    }
}
