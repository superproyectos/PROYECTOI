package com.grafos.menu;

import javax.swing.*;

public class SelectorDeArchivo
{
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
                    leerArchivo();
                }
            }
        }).start();
    }
    public void leerArchivo()
    {
        System.out.print("Enreo");
    }
}
