package com.grafos.menu;

import com.grafos.Config;

public class Menu
{
    private BarraMenu barra;
    private Etiquetado etiqueta;
    private Boton boton;
    public Menu()
    {
        barra=new BarraMenu(0,Config.H-Config.MenuH,Config.MenuH, Config.color(40, 55, 71,1));
        etiqueta=new Etiquetado("Grafo Introducido",Config.H-Config.MenuH);
        boton=new Boton(10,Config.H-Config.MenuH,0,"Algoritmo de Prim");
        boton=new Boton(200,Config.H-Config.MenuH,1,"Algoritmo de Dijkstra");
        boton=new Boton(390,Config.H-Config.MenuH,2,"Leer Archivo");
        new CampoTexto();
    }

    public void dibujar()
    {
        barra.dibujar();
        etiqueta.dibujar();
    }
}
