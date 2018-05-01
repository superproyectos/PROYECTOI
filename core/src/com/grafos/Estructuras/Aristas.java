package com.grafos.Estructuras;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.grafos.Config;

public class Aristas extends Array<Lado>
{
    public boolean seRepiteLado(Vertice A, Vertice B)
    {
        for(Lado t:this)
        {
            Vertice ax1=t.getVerticeEntrada();
            Vertice ax2=t.getVerticeSalida();
            if((ax1==A&&ax2==B)||(ax2==A&&ax1==B))
                return true;
        }
        return false;
    }
    public boolean addLado(Vertice A, Vertice B,int peso)
    {
        if(!this.seRepiteLado(A,B))
            this.add(new Lado(A,B,peso));
        else
            return false;
        return true;
    }
    public void dibujaLados()
    {
        for (Lado a:this)
            a.dibujaLado();
    }
    public Array<Lado> getLadosVertice(Vertice v)
    {
        Array<Lado> ladovertice=new Array<Lado>();
        for (Lado a:this)
            if(a.getVerticeEntrada()==v||a.getVerticeSalida()==v)
                ladovertice.add(a);
        return ladovertice;
    }
    public void decolorar()
    {
        for (Lado a:this)
            a.setColor(Config.AZUL);
    }
    public int coloreaCamino(Grafo grafo, Color color)
    {
        int costo=0;
        for(Lado a:grafo.getLados())
        {
            int i=this.indexOf(a,false);
            if(i>=0) {
                this.get(i).setColor(color);
                costo += this.get(i).getPeso();
            }
        }
        return costo;
    }
    public Aristas getSucesores(Vertice v)
    {
        Aristas hijo=new Aristas();
        for(Lado a:this)
            if(a.getVerticeEntrada()==v||a.getVerticeSalida()==v)
                hijo.add(a);
        return hijo;
    }
    public boolean existenSucesores()
    {
        return this.size>0;
    }
    public void siguienteSucesor()
    {
        this.removeIndex(0);
    }

    public Lado ladoCostoMin (Array<Vertice> B)
    {
        Lado lado_min= null;
        for(Vertice a: B)
            for(Lado c: this.getLadosVertice(a))
                if((!c.getVerticeEntrada().getMarcado()) ||  (!c.getVerticeSalida().getMarcado()))
                    if(((lado_min ==null) ||  (c.getPeso() < lado_min.getPeso())) )
                        lado_min=c;
        return lado_min;

    }

}
