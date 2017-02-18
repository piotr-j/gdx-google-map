package io.piotrjastrzebski.gdxmaps;

import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.badlogic.gdx.backends.android.AndroidInput;

public class GameFragment extends AndroidFragmentApplication {
    private final static String TAG = GameFragment.class.getSimpleName();
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // make view transparent
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.r = 8;
        config.g = 8;
        config.b = 8;
        config.a = 8;
        View view = initializeForView(new MyGdxGame(), config);
        if (view instanceof GLSurfaceView) {
            GLSurfaceView sv = (GLSurfaceView) view;
            sv.setZOrderOnTop(true);
            sv.getHolder().setFormat(PixelFormat.RGBA_8888);
        }

        // make sure we dont eat touch events
        final AndroidInput input = getInput();
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // AndroidInput always returns true...
                input.onTouch(v, event);
                return false;
            }
        });
        return view;
    }
}
