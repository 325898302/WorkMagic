package com.example.workmagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.workmagic.other.BroadBattery;
import com.example.workmagic.R;
import com.example.workmagic.other.ServiceMusic;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageFire;
    Button btDoMeMagic, btCardMagic, btAboutShow;
    Animation anim2;
    BroadBattery battery;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageFire = findViewById(R.id.imageFire);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        btDoMeMagic = findViewById(R.id.bDoMeMagic);
        btDoMeMagic.setOnClickListener(this);
        btCardMagic = findViewById(R.id.bCardMagic);
        btCardMagic.setOnClickListener(this);
        btAboutShow = findViewById(R.id.bAboutShow);
        btAboutShow.setOnClickListener(this);
        intentFilter= new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        battery= new BroadBattery();


        Glide.with(getApplicationContext()).load(R.drawable.fire2).into(imageFire);

        if(getIntent().getExtras() == null || !getIntent().getExtras().getBoolean("app")) {
            SharedPreferences sp;
            sp = getSharedPreferences("sound", 0);
            SharedPreferences.Editor editor = sp.edit();
            startService(new Intent(this, ServiceMusic.class));
            editor.putBoolean("music", true);
            editor.apply();
        }
    }

    @Override  // בטריה
    protected void onStart() {
        super.onStart();
        registerReceiver(battery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(battery);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SharedPreferences sp;
        MenuItem i = menu.findItem(R.id.music);
        sp = getSharedPreferences("sound", 0);
        if(sp.getBoolean("music", true)) {
            i.setIcon(R.drawable.musicyes);
        } else {
            i.setIcon(R.drawable.musicno);
        }
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
            SharedPreferences sp;
            sp = getSharedPreferences("sound", 0);
            SharedPreferences.Editor editor = sp.edit();
            if (sp.getBoolean("music", true)) {
                item.setIcon(R.drawable.musicno);
                stopService(new Intent(this, ServiceMusic.class));
                editor.putBoolean("music", false);
            } else {
                item.setIcon(R.drawable.musicyes);
                startService(new Intent(this, ServiceMusic.class));
                editor.putBoolean("music", true);
            }
            editor.apply();

        }

        return true;
    }


    @Override
    public void onClick(View v) {
        if (v == btDoMeMagic) {
            Intent intent = new Intent(this, MakeMagicActivity.class);
            startActivity(intent);
        }
        if (v == btCardMagic) {
            Intent intent = new Intent(MainActivity.this, LearnMagicActivity.class);
            startActivity(intent);
        }
        if (v == btAboutShow) {
            Intent intent = new Intent(MainActivity.this, AboutShowActivity.class);
            intent.putExtra("menu", false);
            startActivity(intent);
        }
    }

}