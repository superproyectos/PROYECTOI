package com.grafos.Estructuras;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grafos.Config;

/**
 * <--------------------CLASE VÉRTICE-------------------->
 *     0. ATRIBUTOS.
 *     0.0 CONSTRUCTOR
 *     REPRESENTACIÓN GRÁFICA DE NODOS.
 *      1. Dibujador.
 *      2. Actuador.
 *      3. Oyente Drag.
 *     GETTERS
 *      4. Número de etiqueta.
 *      5. Nodo Marcado.
 *      6. Costo.
 *      7. Referencia.
 *     SETTERS
 *      8. Número de etiqueta.
 *      9. Nodo Marcado.
 *      10. Costo.
 *      11. Referencia.
 *     DESTRUCTORES
 *      12. Destruir.
 *      */


public class Vertice extends Actor
{
    //Atributos gráfocos.
    private ShapeRenderer shape;
    private BitmapFont font;
    //Atributos generales.
    private int etiqueta;
    //Algortimo de Prim.
    private boolean marcado;
    //Algoritmo de Dijkstra.
    private int costo;
    private Lado referencia;


    /*<--------------------Constructor-------------------->
    * Recibe posición en x,y y la etiqueta*/

    public Vertice(float x,float y,int numero)
    {
        //Atributos gráficos.
        shape=new ShapeRenderer();
        font = new BitmapFont();
        this.setHeight(50);
        this.setWidth(50);
        this.setX(x);
        this.setY(y);
        setDrag();
        //Atributos generales.
        this.etiqueta=numero;
        this.costo=-1;
        marcado=false;
        this.referencia=null;
        //Colores de fuente y vértice.
        font.setColor(Config.color(133, 193, 233,1));
        shape.setColor(Config.color(52, 152, 219,1));

    }

    /*<--------------------REPRESENTACIÓN GRÁFICA-------------------->*/

    /*<--------------------1. Dibujador de actor-------------------->
    * Cibuja los vértices con su etiqueta*/

    @Override
    public void draw (Batch batch, float parentAlpha)
    {
        super.draw(batch,parentAlpha);
        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(this.getX()+25, this.getY()+25, 25);
        shape.end();
        batch.begin();
        font.draw(batch,Integer.toString(etiqueta),this.getX(),this.getY()+getHeight()/2+font.getXHeight()/2,getWidth(),1,true);

    }

    /*<--------------------2. Acciones del actor-------------------->
    * Evita que los actores salgan de la pantalla*/

    @Override
    public void act (float delta)
    {
        super.act(delta);
        float dx=getX(),dy=getY();
        if(dx<0)
            setX(dx+0.5f);
        if(dx>550)
            setX(dx-0.5f);
        if(dy<0)
            setY(dy+0.5f);
        if(dy>470)
            setY(dy-0.5f);

    }

    /*<--------------------3. Hacer los nodos dragables-------------------->
    * Implementa un oyente al objeto*/

    private void setDrag()
    {
        this.addListener(new DragListener()
        {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer)
            {
                moveBy(x - getWidth()/2, y - getHeight()/2);
            }
        });
    }

    /*<--------------------GETERS-------------------->*/

    /*<--------------------4. Número de la etiqueta-------------------->*/

    public int getEtiqueta() {return this.etiqueta;}

    /*<--------------------5. Nodo marcado(PRIM)-------------------->*/

    public boolean getMarcado() {return this.marcado;}

    /*<--------------------6. Costo parcial del nodo(DIJKSTRA)-------------------->*/

    public int getCosto()
    {
        return costo;
    }

    /*<--------------------7. Obtener referencia (DIJKSTRA)-------------------->*/

    public Lado getReferencia()
    {
        return referencia;
    }

    /*<--------------------SETERS-------------------->*/


    /*<--------------------8. Número de la etiqueta-------------------->*/

    public void setEtiqueta(int etiqueta) {this.etiqueta=etiqueta;}

    /*<--------------------9. Nodo marcado(PRIM)-------------------->*/

    public void setMarcado(boolean boo) {this.marcado=boo;}

    /*<--------------------10. Costo parcial del nodo(DIJKSTRA)-------------------->*/

    public void setCosto(int costo)
    {
        this.costo=costo;
    }

    /*<--------------------11. Obtener referencia (DIJKSTRA)-------------------->*/

    public void asociarReferencia(Lado m)
    {
        referencia=m;
    }

    /*<--------------------12. Destruir-------------------->*/

    public void dispose()
    {
        shape.dispose();
        font.dispose();
    }






}
