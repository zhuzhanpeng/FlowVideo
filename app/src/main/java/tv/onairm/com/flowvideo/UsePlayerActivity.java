package tv.onairm.com.flowvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class UsePlayerActivity extends Activity implements SurfaceHolder.Callback {
    IjkMediaPlayer player;
    SurfaceView surface;
    SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_player);
        surface = (SurfaceView) findViewById(R.id.surface);
        player = MainApplication.getMediaPlayer();
        surfaceHolder = surface.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity 可见时尝试继续播放
        if (player != null) {
            player.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        player.setDisplay(surfaceHolder);
        player.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
