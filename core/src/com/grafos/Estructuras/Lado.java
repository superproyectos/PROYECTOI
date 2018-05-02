package com.grafos.Estructuras;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grafos.Config;
import com.grafos.Estructuras.Vertice;

/**
 * <--------------------CLASE LADO-------------------->
 *     0. ATRIBUTOS.
 *     0.0 CONSTRUCTOR
 *     REPRESENTACIÓN GRÁFICA DE NODOS.
 *      1. Dibujador.
 *     GETTERS
 *      2. Vértice de entrada.
 *      3. Vértice de salida.
 *      4. Costo.
 *     SETTERS
 *      5. Vértice de entrada.
 *      6. Vértice de salida.
 *      7. Costo.
 *      8. Color.
 *     DESTRUCTORES
 *      9. Destruir.
 *      */


public class Lado
{
    //Atributos gráficos.
    private ShapeRenderer shape;
    private SpriteBatch batch;
    private BitmapFont font;
    //Atributos generales.
    private Vertice entrada, salida;
    private int peso;

    /*<--------------------Constructor-------------------->
     * Recibe vértice de entrada,vértice de salida y el peso*/

    public Lado(Vertice entrada,Vertice salida,int peso)
    {
        //Atributos generales
        this.entrada=entrada;
        this.salida =salida;
        this.peso=peso;
        //Atributos gráficos
        shape=new ShapeRenderer();
        batch=new SpriteBatch();
        font = new BitmapFont();
        font.setColor(133/255f, 193/255f, 233/255f,1);
        shape.setColor(Config.AZUL);
    }

    /*<--------------------REPRESENTACIÓN GRÁFICA-------------------->*/

    /*<--------------------1. Dibujador-------------------->*/

    public void dibujaLado()
    {

        if(salida !=entrada)
        {//Si va de un vértice a otro
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.line(entrada.getX()+entrada.getWidth()/2, entrada.getY()+entrada.getWidth()/2, salida.getX()+entrada.getWidth()/2, salida.getY()+entrada.getWidth()/2);
            shape.end();
            batch.begin();
            font.draw(batch," "+peso,(entrada.getX()+ salida.getX()+entrada.getWidth())/2+1,(entrada.getY()+ salida.getY()+entrada.getHeight())/2+1);
            batch.end();
        }
        else
        {//Si es un bucle
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.circle(entrada.getX()+entrada.getWidth()/2, entrada.getY(),entrada.getWidth()/3);
            shape.end();
            batch.begin();
            font.draw(batch," "+peso,entrada.getX()+entrada.getWidth()/2,entrada.getY()-entrada.getHeight()/2);
            batch.end();
        }
    }

    /*<--------------------GETTERS-------------------->*/

    /*<--------------------2. Obtener vértice de entrada-------------------->*/

    public Vertice getVerticeEntrada() {return this.entrada;}

    /*<--------------------3. Obtener vértice de salida-------------------->*/

    public Vertice getVerticeSalida() {return this.salida;}

    /*<--------------------4. Costo del lado-------------------->*/

    public int getPeso() {return this.peso;}

    /*<--------------------SETTERS-------------------->*/

    /*<--------------------5. Establecer vértice de entrada-------------------->*/

    public void setVerticeEntada(Vertice vert) {this.entrada=vert;}

    /*<--------------------6. Establecer vértice de salida-------------------->*/

    public void setVerticeSalida(Vertice vert) {this.salida=vert;}

    /*<--------------------7. Establecer costo-------------------->*/

    public void setPeso(int peso) {this.peso=peso;}

    /*<--------------------8. Establecer color del lado-------------------->*/

    public void setColor(Color a)
    {
        shape.setColor(a);
    }

    /*<--------------------Destructor-------------------->*/

    public void dispose()
    {
        batch.dispose();
        font.dispose();
        shape.dispose();
    }
}
