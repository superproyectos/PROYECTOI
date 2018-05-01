package com.grafos.Estructuras;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.grafos.Config;

public class Nodos extends Array<Vertice>
{
    public void crearVertices(int n)
    {
        float x=Config.W/2,y=Config.H/2,r=150,ang;
        ang=2*3.141592f/n;
        for(int i=1;i<=n;i++)
        {
            Vertice c=new Vertice(x+r*(float)Math.cos(ang*i)-25,y+r*(float)Math.sin(ang*i)-25,i);
            this.add(c);
            Config.STAGE.addActor(c);
        }
    }
    public void desmarcar()
    {
        for(Vertice a: this)
        {
            a.setMarcado(false);
            a.asociarReferencia(null);
            a.setCosto(-1);
        }
    }
    public boolean valida(int a)
    {
        return (a-1>=0&&a<=this.size);
    }
    public boolean esVerticeValido(int primero,int segundo)
    {
        return this.size>0&&valida(primero)&&valida(segundo);
    }

    public Vertice getMenorVerticeAbierto()
    {
        Vertice menor=null;
        for(Vertice a:this)
            if(!a.getMarcado()&&a.getCosto()!=-1)
                menor=(menor==null||menor.getCosto()>a.getCosto()?a:menor);
        return menor;
    }
    public int recorreReferencias(Vertice m)
    {
        if(m.getReferencia()!=null)
        {

            Lado a=m.getReferencia();
            m.asociarReferencia(null);
            a.setColor(Color.PINK);
            if(a.getVerticeEntrada()!=m)
                return recorreReferencias(a.getVerticeEntrada())+a.getPeso();
            else
                return recorreReferencias(a.getVerticeSalida())+a.getPeso();
        }
        return 0;
    }
}
