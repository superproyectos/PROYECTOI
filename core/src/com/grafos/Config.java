package com.grafos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Config
{
    public static final int W= Gdx.graphics.getWidth();
    public static final int H=Gdx.graphics.getHeight();
    public static final Stage STAGE=new Stage(new ScreenViewport());
    public static final int MenuH=50;

    public static final Color color(float r, float g, float b, float a)
    {
        return new Color(r/255f,g/255f,b/255f,a);
    }
}