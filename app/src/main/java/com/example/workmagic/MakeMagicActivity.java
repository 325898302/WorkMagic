package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MakeMagicActivity extends AppCompatActivity implements View.OnClickListener {

    Button think;
    int bodekmusic;
    MediaPlayer player;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makemagic);
        think = findViewById(R.id.think);
        think.setOnClickListener(this);

        Intent intent = getIntent();
        bodekmusic = intent.getExtras().getInt("bodekmusicwork", 0);


    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        player = MediaPlayer.create(MakeMagicActivity.this, R.raw.dramamusic);
//        player.setLooping(true);
//        player.start();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        player.release();
//        player = null;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        super.onOptionsItemSelected(item);
//        int id = item.getItemId();
//        x=0;
//
//        if (id == R.id.music) {
//            if (player == null) {
//                player = MediaPlayer.create(MakeMagicActivity.this, R.raw.dramamusic);
//                player.setLooping(true);
//                player.start();
//                x=1;
//                item.setIcon(R.drawable.musicyes);
//            }
//            else {
//                player.release();
//                player = null;
//                item.setIcon(R.drawable.musicno);
//            }
//
//        }
//
//        return true;
//    }

    @Override
    public void onClick(View v) {
        if (v == think) {
            Intent intent = new Intent(MakeMagicActivity.this, MagicCardActivity.class);
            startActivity(intent);
        }
    }

}