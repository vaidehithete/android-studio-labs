package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=null;
    }

    public void music(View view) {
        switch (view.getId()) {
            case(R.id.button): {
                if (mediaPlayer == null) {
                    mediaPlayer = mediaPlayer.create(this, R.raw.music);
                    mediaPlayer = mediaPlayer.create(this, R.raw.kk);


                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopMusic();
                    }
                });
                mediaPlayer.start();
                break;
            }
            case(R.id.button2): {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
                break;
            }
            case (R.id.button3): {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    stopMusic();
                }
                break;
            }
        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer=null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}