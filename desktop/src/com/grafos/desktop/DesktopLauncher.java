package com.grafos.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grafos.Grafos;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Grafos";
		config.width=600;
		config.height=600;
		config.resizable=false;
		try {
			config.addIcon("LAUN.png", Files.FileType.Internal);
		}catch (Exception e)
		{
			//No puede cargar el icono
		}
		new LwjglApplication(new Grafos(), config);
	}
}
