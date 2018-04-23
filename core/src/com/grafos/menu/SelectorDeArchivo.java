package com.grafos.menu;

import javax.swing.*;

public class SelectorDeArchivo
{
    public SelectorDeArchivo()
    {
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

    }
}
