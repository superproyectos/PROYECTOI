package com.grafos.menu;

import com.grafos.Estructuras.Grafo;
import com.grafos.Grafos;
import com.sun.deploy.uitoolkit.impl.fx.ui.ErrorPane;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectorDeArchivo
{
    private static String direccion=null;
    public SelectorDeArchivo()
    {
        //El hilo permite que podamos mover la ventana por la pantalla.
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                JFileChooser chooser = new JFileChooser();
                JFrame f = new JFrame();
                f.setVisible(true);
                f.toFront();
                f.setVisible(false);
                int res = chooser.showSaveDialog(f);
                f.dispose();
                if (res == JFileChooser.APPROVE_OPTION)
                {
                    direccion=chooser.getSelectedFile().toString();
                    Thread.currentThread().stop();

                }

            }
        }).start();

        /*System.out.print(direccion);
        if (direccion!=null)*/

    }
    public static void compruebaArchivo()
    {
        if(direccion!=null)
        {
            leerArchivo(direccion);
            direccion=null;
        }

    }
    public static void leerArchivo(String s)
    {
        int text=0;
        int num_vertices;
        try
        {
            Scanner sc= new Scanner(new FileReader(s));
            num_vertices=sc.nextInt();
            sc.nextLine();
            Grafos.grafo.clear();
            Grafos.grafo.crearVertices(num_vertices);
            ++text;

            while(sc.hasNextLine())
            {
                Scanner sc1= new Scanner(sc.nextLine());
                sc1.useDelimiter(",");


                int etiqueta=sc1.nextInt();
                int etiqueta2=sc1.nextInt();
                int peso=sc1.nextInt();

                System.out.println(etiqueta);
                System.out.println(etiqueta2);
                System.out.println(peso);

                Grafos.grafo.addLado(etiqueta,etiqueta2,peso);
            /*Lados lado=new Lados(all_vertices.get(etiqueta2-1),all_vertices.get(etiqueta-1),peso);
            all_lados.add(lado);
            all_vertices.get(etiqueta-1).addLado(lado);
            all_vertices.get(etiqueta2-1).addLado(lado);
*/

                sc1.close();
                System.out.println("linea: "+(++text));
            }

            sc.close();
        }
        catch(final Exception FNF)
        {

            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    JOptionPane.showMessageDialog(new JPanel(), "No entiendo lo que dice el archivo :(",
                            "Vaya, ha ocurrido un error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }).start();

        }

    }

}
