package com.grafos.menu;

import com.badlogic.gdx.graphics.Color;
import com.grafos.Config;
import com.grafos.Estructuras.Grafo;
import com.grafos.Grafos;

public class Menu
{
    private BarraMenu barra;
    private Titulo etiqueta;
    private Etiqueta peso;
    public Menu()
    {
        barra=new BarraMenu(0,Config.H-Config.MenuH,Config.MenuH, Config.color(40, 55, 71,1));
        etiqueta=new Titulo("Grafo Introducido",Config.H-Config.MenuH);
        new Boton(10,Config.H-Config.MenuH,0,"Algoritmo de Prim",Config.W/3);
        new Boton(200,Config.H-Config.MenuH,1, new CampoTexto(10,20,0), new CampoTexto(70,20,1),"Algortimo de Dijkstra",Config.W/3);
        new Boton(390,Config.H-Config.MenuH,2,"Leer Archivo",Config.W/3);

        new Boton(Config.W-50,10,3,new CampoTexto(440,20,2),new CampoTexto(500,20,3),"+",50);

        peso=new Etiqueta(0,Config.H-Config.MenuH-20,10,10,0.8f,"Peso: ", Color.WHITE);
    }

    public void dibujar()
    {
        SelectorDeArchivo.compruebaArchivo();
        barra.dibujar();
        etiqueta.dibujar();
        peso.setTexto("Costo : "+Grafos.grafo.getPeso());
    }
}
