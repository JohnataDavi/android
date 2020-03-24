package com.johnatadavi.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.app.Activity;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        // Manipulando componentes de tela com decorView,
        // no caso escondendo os componentes
        View decorView = getWindow().getDecorView();
        int upOp = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(upOp);

        getSupportActionBar().hide();

        // Controlador de vídeo padrão do android
        videoView.setMediaController(new MediaController(this));
        //videoView.setVideoURI("url");
        // getPackageName() -> nome do pacote a ser utilizado, no caso raw
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();
    }
}
