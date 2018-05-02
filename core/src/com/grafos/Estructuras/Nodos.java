package com.grafos.Estructuras;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.grafos.Config;


/**
 * <--------------------CLASE NODOS-------------------->
 *
 *     NODOS ES UN CONJUNTO DE VÉRTICES
 *     V=(v)
 *      1. Crear vértices.
 *      2. Desmarcar vértices.
 *      3. Validar etiqueta.
 *      4. Validar vértice.
 *      5. Menor vértice abierto
 *      6. Recorrer referencias.
 *      7. Ordenar vértices
 *      */

public class Nodos extends Array<Vertice>
{
    /*<--------------------1. Crear vértices-------------------->
    * Crea vértices en un círculo y los añade al conjunto*/

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

    /*<--------------------2. Desmarcar todos los vértices-------------------->*/

    public void desmarcar()
    {
        for(Vertice a: this)
        {
            a.setMarcado(false);
            a.asociarReferencia(null);
            a.setCosto(-1);
        }
    }

    /*<--------------------3. Validar etiqueta-------------------->
    * Devuelve si la etiqueta está entre los valores permitidos*/

    private boolean valida(int a)
    {
        return (a-1>=0&&a<=this.size);
    }

    /*<--------------------4. Validar vértice-------------------->
     * Devuelve si los vértices son válidos*/

    public boolean esVerticeValido(int primero,int segundo)
    {
        return this.size>0&&valida(primero)&&valida(segundo);
    }

    /*<--------------------5. Tomar menor vértice abierto-------------------->*/

    public Vertice getMenorVerticeAbierto()
    {
        Vertice menor=null;
        for(Vertice a:this)
            if(!a.getMarcado()&&a.getCosto()!=-1)
                menor=(menor==null||menor.getCosto()>a.getCosto()?a:menor);
        return menor;
    }

    /*<--------------------6. Recorrer referencias-------------------->
    * Recorre desde el final al principio coloreando el camino*/

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

    /*<--------------------7. Ordenar vértices-------------------->
     * Ordena vértices por número de etiqueta*/

    public Nodos ordenar()
    {
        Nodos aux=new Nodos();
        for(int i=1;i<this.size+1;i++)
            for(Vertice a:this)
                if(a.getEtiqueta()==i)
                {
                    aux.add(a);
                    break;
                }
        return aux;
    }
}
