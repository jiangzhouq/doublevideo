package com.qjizho.doublevideo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SurfaceView mSurfaceView;
    private SurfaceView mSurfaceView2;
    private Button mButtonStart;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);
        mSurfaceView2 = (SurfaceView) findViewById(R.id.surface_view2);
        mButtonStart = (Button) findViewById(R.id.button_start_surfaceView);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer==null){
                    mediaPlayer = new MediaPlayer();
                }
                if(mediaPlayer2==null){
                    mediaPlayer2 = new MediaPlayer();
                }
                mediaPlayer.reset();
                mediaPlayer2.reset();
                try {
                    //Sets the data source (file-path or http/rtsp URL) to use,设置播放文件的路径
                    mediaPlayer.setDataSource(Environment.getExternalStorageDirectory() + "/123.mp4");
                    mediaPlayer2.setDataSource(Environment.getExternalStorageDirectory() + "/123.mp4");
                    //Sets the audio stream type for this MediaPlayer，设置流的类型，此为音乐流
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    //Sets the SurfaceHolder to use for displaying the video portion of the media，设置播放的容器
                    mediaPlayer.setDisplay(mSurfaceView.getHolder());
                    mediaPlayer2.setDisplay(mSurfaceView2.getHolder());
                    mediaPlayer.prepare();
                    mediaPlayer2.prepare();
                    //Interface definition for a callback to be invoked when the media source is ready for playback
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}