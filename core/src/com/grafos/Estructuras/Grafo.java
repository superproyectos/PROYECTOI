package com.grafos.Estructuras;


import com.badlogic.gdx.graphics.Color;
import com.grafos.*;

/**
 * <--------------------CLASE GRAFO-------------------->
 *
 *     ¡ATENCIÓN! Grafo tiene una instancia estática.
 *
 *     GRAFO ES UN CONJUNTO DE VÉRTICES Y DE ARISTAS
 *     G=(V,E)
 *
 *     0. ATRIBUTOS.
 *     0.0 CONSTRUCTOR
 *     CREAR GRAFO.
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

public class Grafo
{
    //Atributos generales
    private Nodos vertices;
    private Aristas lados;
    private int peso;

    /*<--------------------Constructor-------------------->*/

    public Grafo()
    {
        //G=(V,E)
        vertices=new Nodos();
        lados=new Aristas();
        //Costo de trayecto
        peso=0;
    }

    /*<--------------------1. Generar grafo aleatorio-------------------->
    * Recibe el número de vértices y de lados a generar aleatoriamente*/

    public void grafoRandom(int ver,int lad)
    {
        vertices.crearVertices(ver);
        for(int i=0;i<lad;i++)
        {
            int a1 = Config.aleatorio(vertices.size), a2 = Config.aleatorio(vertices.size);
            if(a1!=a2&&!lados.addLado(vertices.get(a1),vertices.get(a2),Config.aleatorio(100)+1)||a1==a2)
                i--;
        }
    }

    /*<--------------------2. Crear un vértice-------------------->*/

    public void crearVertices(int n)
    {
        vertices.crearVertices(n);
    }

    /*<--------------------3. Añadir un lado-------------------->*/

    public void addLado(int a,int b,int peso)
    {
        lados.addLado(vertices.get(a-1),vertices.get(b-1),peso);
    }

    /*<--------------------4. Dibujar lados-------------------->*/

    public void dibujar()
    {
        lados.dibujaLados();
    }

    /*<--------------------5. Limpiar grafo-------------------->*/

    public void clear()
    {
        for (Vertice a:vertices)
            a.remove();
        vertices.clear();
        lados.clear();
    }

    /*<--------------------6. Algortimo de Prim-------------------->*/

    public Grafo Prim()
    {
        //Valida si hay vértices
        if(vertices!=null&&vertices.size>0)
        {
            Grafo arbol_min_cobertor = new Grafo();
            Lado lado_costo_min;
            arbol_min_cobertor.vertices.add(vertices.get(0));
            //Quitar rastros de culaquier otro algoritmo
            vertices.desmarcar();
            //Tomar un vértice y marcarlo
            vertices.get(0).setMarcado(true);
            while (arbol_min_cobertor.vertices.size!= vertices.size)
            {//Mientras B sea distinto de V
                //Hallar el lado con menor costo
                lado_costo_min = lados.ladoCostoMin(arbol_min_cobertor.vertices);
                if (lado_costo_min != null)
                {//Si existe un lado con costo mínimo
                    //Añadir lado al árbol mínimo cobertor
                    arbol_min_cobertor.lados.add(lado_costo_min);
                    if (!arbol_min_cobertor.vertices.contains(lado_costo_min.getVerticeEntrada(), false))
                    {//Si el árbo
                        arbol_min_cobertor.vertices.add(lado_costo_min.getVerticeEntrada());
                        vertices.get(vertices.indexOf(lado_costo_min.getVerticeEntrada(), false)).setMarcado(true);
                    }
                    else
                    {
                        arbol_min_cobertor.vertices.add(lado_costo_min.getVerticeSalida());
                        vertices.get(vertices.indexOf(lado_costo_min.getVerticeSalida(), false)).setMarcado(true);
                    }
                }
                else {
                    for (Vertice a : vertices)
                        if (!a.getMarcado())
                        {
                            a.setMarcado(true);
                            arbol_min_cobertor.vertices.add(a);
                            break; }
                }
            }
            arbol_min_cobertor.peso=lados.coloreaCamino(arbol_min_cobertor,Color.PINK);
            arbol_min_cobertor.vertices=arbol_min_cobertor.vertices.ordenar();
            vertices.desmarcar();
            return arbol_min_cobertor;
        }
        return this;
    }

    public void Dijktra(int primero,int segundo)
    {
        /*primero=Math.abs(primero);
        segundo=Math.abs(segundo);*/
        if(vertices!=null&&vertices.esVerticeValido(primero,segundo))
        {
            vertices.desmarcar();
            Vertice w=vertices.get(primero-1);
            w.setCosto(0);
            Vertice n;
            while((n=vertices.getMenorVerticeAbierto())!=null)
            {
                n.setMarcado(true);
                Aristas sucesor=lados.getSucesores(n);
                while (sucesor.existenSucesores())
                {
                    Lado mn=sucesor.get(0);
                    Vertice m=mn.getVerticeEntrada()==n?mn.getVerticeSalida():mn.getVerticeEntrada();
                    if(n.getCosto()+mn.getPeso()<=m.getCosto()||m.getCosto()==-1)
                    {
                        m.setCosto(n.getCosto()+mn.getPeso());
                        m.asociarReferencia(mn);
                    }
                    sucesor.siguienteSucesor();
                }
            }
            lados.decolorar();
            peso=vertices.recorreReferencias(vertices.get(segundo-1));
        }

    }

    public Aristas getLados()
    {
        return lados;
    }
    public int getPeso()
    {
        return peso;
    }
    public void setPeso(int costo)
    {
        this.peso=costo;
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
    private Grafo crearGrafo(Grafo grafo)
    {
        Grafo arbol=new Grafo();
        arbol.vertices.crearVertices(vertices.size);

        for(Lado a: grafo.lados)
        {
            Lado lado= new Lado(a.getVerticeEntrada(),a.getVerticeSalida(),a.getPeso());
            arbol.peso += a.getPeso();
            arbol.lados.add(lado);
        }
        return arbol;
    }

}
