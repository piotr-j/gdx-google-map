package io.piotrjastrzebski.gdxmaps;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	public final static float SCALE = 32;
	public final static float INV_SCALE = 1f/SCALE;
	public final static int TARGET_WIDTH = 1280;
	public final static int TARGET_HEIGHT = 720;
	public final static float WIDTH = TARGET_WIDTH * INV_SCALE;
	public final static float HEIGHT = TARGET_HEIGHT * INV_SCALE;
	SpriteBatch batch;
	ShapeRenderer shapes;
	ExtendViewport gameViewport;
	ScreenViewport guiViewport;
	Texture img;

	@Override
	public void create () {
		img = new Texture("badlogic.jpg");

		gameViewport = new ExtendViewport(WIDTH, HEIGHT);
		guiViewport = new ScreenViewport();
		batch = new SpriteBatch();
		shapes = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		batch.setProjectionMatrix(gameViewport.getCamera().combined);
		batch.begin();
		batch.draw(img, -3, -3, 6, 6);
		batch.end();

        shapes.setProjectionMatrix(gameViewport.getCamera().combined);
        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(Color.CLEAR);
        shapes.rect(0, 0, 6, 6);
        shapes.end();
	}

	@Override public void resize (int width, int height) {
		gameViewport.update(width, height, false);
		guiViewport.update(width, height, true);
		super.resize(width, height);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
