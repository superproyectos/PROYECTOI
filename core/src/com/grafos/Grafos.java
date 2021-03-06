package com.grafos;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.grafos.Estructuras.Grafo;
import com.grafos.menu.Menu;


public class Grafos extends ApplicationAdapter
{
	public static Grafo grafo=new Grafo();
	private Menu menu;
	@Override
	public void create ()
	{
		Gdx.gl.glLineWidth(3);
		Gdx.input.setInputProcessor(Config.STAGE);
		menu=new Menu();
		grafo.grafoRandom(7,Config.aleatorio(21)+1);
	}
	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(28/255f, 40/255f, 51/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		menu.dibujar();
		Config.STAGE.act(Gdx.graphics.getDeltaTime());
		grafo.dibujar();
		Config.STAGE.draw();

	}

	@Override
	public void dispose ()
	{
		Config.STAGE.dispose();
	}

}
