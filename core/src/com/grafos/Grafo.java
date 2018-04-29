package com.grafos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.grafos.Config;
import com.grafos.Lado;
import com.grafos.Vertice;

import java.util.Random;

public class Grafo
{
    //G=(V,E)
    private Array<Vertice> vertices;
    private Array<Lado> lados;
    private int peso;
    public Grafo()
    {
        vertices=new Array<Vertice>();
        lados=new Array<Lado>();
        peso=0;
    }
    public void crearVertices(int n)
    {
        System.out.println(n);
        float x=Config.W/2,y=Config.H/2,r=150,ang;
        ang=2*3.141592f/n;
        for(int i=1;i<=n;i++)
        {
            Vertice c=new Vertice(x+r*(float)Math.cos(ang*i)-25,y+r*(float)Math.sin(ang*i)-25,i);
            addVertice(c);
            Config.STAGE.addActor(c);
        }
    }
    public void addVertice(Vertice A)
    {
        vertices.add(A);
    }
    public boolean seRepiteLado(Vertice A,Vertice B)
    {
        for(Lado t:lados)
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
        if(!seRepiteLado(A,B))
            lados.add(new Lado(A,B,peso));
        else
            return false;
        return true;
    }
    public void addLado(int a,int b,int peso)
    {
        addLado(vertices.get(a-1),vertices.get(b-1),peso);
    }
    public void dibujaLados()
    {
        for (Lado a:lados)
            a.dibujaLado();
    }
    public void grafoRandom(int ver)
    {
        crearVertices(ver);
        for(int i=0;i<10;i++)
        {

            Random aleatorio = new Random(System.currentTimeMillis());
            int a1 = aleatorio.nextInt(vertices.size), a2 = aleatorio.nextInt(vertices.size);
            if(a1!=a2&&!addLado(vertices.get(a1),vertices.get(a2),aleatorio.nextInt(100)+1)||a1==a2)
                i--;
            aleatorio.setSeed(System.currentTimeMillis());
        }
    }
    public void clear()
    {
        for (Vertice a:vertices)
            a.remove();
        vertices.clear();
        lados.clear();
    }
    public void printLados()
    {
        int num=1;

        for(Lado a : lados)
            if(a != null)
            {
                System.out.println("lado: "+(num++));
                System.out.println("Vert salida: "+(a.getVerticeEntrada()));
                System.out.println("Vert entrada: "+(a.getVerticeSalida()));
                System.out.println("Peso: "+(a.getPeso()));
            }
    }
    public void printVertices()
    {
        for(Vertice a : vertices)
            if(a != null)
                System.out.println("vertice: "+(a.getEtiqueta()));
    }

    public Array<Lado> getLadosVertice(Vertice v)
    {
        Array<Lado> ladovertice=new Array<Lado>();
        for (Lado a:lados)
            if(a.getVerticeEntrada()==v||a.getVerticeSalida()==v)
                ladovertice.add(a);
        return ladovertice;
    }

    public Lado ladoCostoMin (Array<Vertice> B)
    {
        Lado lado_min= null;
        for(Vertice a: B)
        {
            for(Lado c: this.getLadosVertice(a))
            {
                if(   (!c.getVerticeEntrada().getMarcado()) ||  (!c.getVerticeSalida().getMarcado()) )
                {

                    if(( (lado_min ==null) ||  (c.getPeso() < lado_min.getPeso())) )
                    {
                        lado_min=c;
                    }
                }
            }
        }
        return lado_min;

    }


    public void desmarcar()
    {
        for(Vertice a: vertices)
            a.setMarcado(false);
    }



    public Grafo Prim() {

        Grafo arbol_min_cobertor= new Grafo();
        Lado lado_costo_min= new Lado();

        arbol_min_cobertor.vertices.add(vertices.get(0));
        vertices.get(0).setMarcado(true);


        while  (vertices.size != arbol_min_cobertor.vertices.size)
        {

            lado_costo_min= ladoCostoMin(arbol_min_cobertor.vertices);

            if(lado_costo_min != null)
            {
                arbol_min_cobertor.lados.add(lado_costo_min);

                if(!arbol_min_cobertor.vertices.contains(lado_costo_min.getVerticeEntrada(),false)   )
                {
                    arbol_min_cobertor.vertices.add(lado_costo_min.getVerticeEntrada());
                    vertices.get(vertices.indexOf(lado_costo_min.getVerticeEntrada(),false)).setMarcado(true);

                }
                else
                {
                    arbol_min_cobertor.vertices.add(lado_costo_min.getVerticeSalida());
                    vertices.get(vertices.indexOf(lado_costo_min.getVerticeSalida(),false)).setMarcado(true);
                }

            }
            else
            {

                for (Vertice a: vertices) {

                    if(!a.getMarcado())
                    {
                        a.setMarcado(true);
                        arbol_min_cobertor.vertices.add(a);
                        break;

                    }
                }

            }

        }

        //arbol_min_cobertor=crearGrafo(arbol_min_cobertor);
        coloreaCamino(arbol_min_cobertor);
        desmarcar();
        return arbol_min_cobertor;

    }
    public void coloreaCamino(Grafo grafo)
    {
        for(Lado a:grafo.lados)
        {
            int i=lados.indexOf(a,false);
            if(i>=0)
            lados.get(lados.indexOf(a,false)).setColor();
        }
    }
    public Grafo crearGrafo(Grafo grafo)
    {
        Grafo arbol=new Grafo();
        arbol.crearVertices(vertices.size);

        for(Lado a: grafo.lados)
        {
            Lado lado= new Lado(a.getVerticeEntrada(),a.getVerticeSalida(),a.getPeso());
            arbol.peso += a.getPeso();
            arbol.lados.add(lado);
        }
        return arbol;
    }





}
