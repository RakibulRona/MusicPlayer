package com.example.dolphin.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Play;
    Button Pause;
    Button Stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play=(Button)findViewById(R.id.btnPlay);
        Pause=(Button)findViewById(R.id.btnPause);
        Stop=(Button)findViewById(R.id.btnStop);

        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnPlay:
                if(mediaPlayer==null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }
            break;

            case  R.id.btnPause:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                    pauseCurrentPosition=mediaPlayer.getCurrentPosition();
                }
            break;

            case R.id.btnStop:
                if(mediaPlayer!=null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
            break;
        }

    }
}
