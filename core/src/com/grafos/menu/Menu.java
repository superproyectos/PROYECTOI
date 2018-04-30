package com.grafos.menu;

import com.grafos.Config;

public class Menu
{
    private BarraMenu barra;
    private Etiquetado etiqueta;

    public Menu()
    {
        barra=new BarraMenu(0,Config.H-Config.MenuH,Config.MenuH, Config.color(40, 55, 71,1));
        etiqueta=new Etiquetado("Grafo Introducido",Config.H-Config.MenuH);
        new Boton(10,Config.H-Config.MenuH,0,"Algoritmo de Prim",Config.W/3);
        new Boton(200,Config.H-Config.MenuH, new CampoTexto(10,20,1), new CampoTexto(70,20,2));
        new Boton(390,Config.H-Config.MenuH,2,"Leer Archivo",Config.W/3);
        Boton b=new Boton(Config.W-50,0,3,"+",50);
        b.setWidth(50);
    }

    public void dibujar()
    {
        SelectorDeArchivo.compruebaArchivo();
        barra.dibujar();
        etiqueta.dibujar();
    }
}
