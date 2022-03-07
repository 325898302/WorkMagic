package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageFire;
    Button b1, b2, b3;
    Animation anim2;
    int bodekworkmusic;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageFire = findViewById(R.id.imageFire);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(this);



        Glide.with(getApplicationContext()).load(R.drawable.fire2).into(imageFire);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 900000000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        player = MediaPlayer.create(MainActivity.this, R.raw.dramamusic);
        player.setLooping(true);
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.release();
        player = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.phone) {
            Intent intent = new Intent(this, AboutShowActivity.class);
            intent.putExtra("menu", true);
            startActivity(intent);
        }

        if (id == R.id.music) {
            if (player == null) {
                player = MediaPlayer.create(MainActivity.this, R.raw.dramamusic);
                player.setLooping(true);
                player.start();
                item.setIcon(R.drawable.musicyes);
            }
            else {
                player.release();
                player = null;
                item.setIcon(R.drawable.musicno);
            }

        }

        return true;
    }


    @Override
    public void onClick(View v) {
        if (v == b1) {

            Intent intent = new Intent(this, MakeMagicActivity.class);
//            intent.putExtra("bodekmusicwork", bodekworkmusic);
            startActivity(intent);
        }
        if (v == b2) {
            Intent intent = new Intent(MainActivity.this, LearnMagicActivity.class);
            startActivity(intent);
        }
        if (v == b3) {
            Intent intent = new Intent(MainActivity.this, AboutShowActivity.class);
            intent.putExtra("menu", false);//
            startActivity(intent);
        }
    }

}