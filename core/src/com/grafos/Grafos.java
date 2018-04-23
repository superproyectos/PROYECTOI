package com.grafos;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.grafos.menu.Menu;

import java.util.Random;



public class Grafos extends ApplicationAdapter {
	Stage s;
	Array<Lado> a;
	private Menu menu;
	@Override
	public void create ()
	{
		s=new Stage(new ScreenViewport());

		Gdx.gl.glLineWidth(3);
		Gdx.input.setInputProcessor(s);
		a=new Array<Lado>();
		menu=new Menu();
		Array<Vertice> b=new Array<Vertice>();
		float x=Gdx.graphics.getWidth()/2,y=Gdx.graphics.getHeight()/2,r,ang;
		r=100;
		ang=2*3.141592f/6;
		for(int i=0;i<6;i++)
		{
			Vertice c=new Vertice(x+r*(float)Math.cos(ang*i)-25,y+r*(float)Math.sin(ang*i)-25,i);
			b.add(c);
			s.addActor(c);
		}
		for(int i=0;i<5;i++)
		{
			Random aleatorio = new Random(System.currentTimeMillis());
			int a1 = aleatorio.nextInt(b.size), a2 = aleatorio.nextInt(b.size);
			if(a1!=a2)
				a.add(new Lado(b.get(a1),b.get(a2),aleatorio.nextInt(100)+1));
			else
				i--;
			aleatorio.setSeed(System.currentTimeMillis());
		}
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(28/255f, 40/255f, 51/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		s.act(Gdx.graphics.getDeltaTime());
		for(Lado w:a)
			w.dibujaLado();
		s.draw();
		menu.dibujar();
	}

	@Override
	public void dispose () {

	}

}
