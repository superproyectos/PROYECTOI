package com.grafos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Lado
{
    private Vertice entrada, salida;
    private int peso;
    private ShapeRenderer shape;
    private SpriteBatch batch;
    private BitmapFont font;
    public Lado(Vertice entrada,Vertice salida,int peso)
    {
        this.entrada=entrada;
        this.salida =salida;
        this.peso=peso;
        shape=new ShapeRenderer();
        batch=new SpriteBatch();
        font = new BitmapFont();
        font.setColor(133/255f, 193/255f, 233/255f,1);
        shape.setColor(44/255f, 62/255f, 80/255f,1);
    }
    public Lado()
    {
        this.entrada=null;
        this.salida=null;
        this.peso=-1;
    }
    public void dibujaLado()
    {

        if(salida !=entrada)
        {
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.line(entrada.getX()+entrada.getWidth()/2, entrada.getY()+entrada.getWidth()/2, salida.getX()+entrada.getWidth()/2, salida.getY()+entrada.getWidth()/2);
            shape.end();
            batch.begin();
            font.draw(batch," "+peso,(entrada.getX()+ salida.getX()+entrada.getWidth())/2+1,(entrada.getY()+ salida.getY()+entrada.getHeight())/2+1);
            batch.end();
        }
        else
        {
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.circle(entrada.getX()+entrada.getWidth()/2, entrada.getY(),entrada.getWidth()/3);
            shape.end();
            batch.begin();
            font.draw(batch," "+peso,entrada.getX()+entrada.getWidth()/2,entrada.getY()-entrada.getHeight()/2);
            batch.end();
        }
    }
    public Vertice getVerticeEntrada() {return this.entrada;}
    public void setVerticeEntada(Vertice vert) {this.entrada=vert;}
    public Vertice getVerticeSalida() {return this.salida;}
    public void setVerticeSalida(Vertice vert) {this.salida=vert;}
    public int getPeso() {return this.peso;}
    public void setPeso(int peso) {this.peso=peso;}
    public void setColor()
    {
        shape.setColor(Color.PINK);
    }
}
