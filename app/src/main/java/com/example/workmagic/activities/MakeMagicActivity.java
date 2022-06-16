package com.example.workmagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.workmagic.R;
import com.example.workmagic.other.ServiceMusic;

public class MakeMagicActivity extends AppCompatActivity implements View.OnClickListener {

    Button think;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makemagic);
        think = findViewById(R.id.think);
        think.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_keher_music, menu);
        SharedPreferences sp;
        MenuItem i = menu.findItem(R.id.music);
        sp = getSharedPreferences("sound", 0);
        if(sp.getBoolean("music", true)) {
            i.setIcon(R.drawable.musicyes);
        } else {
            i.setIcon(R.drawable.musicno);
        }
        i = menu.findItem(R.id.phone);  // מעלים את הכפתור של phone
        i.setVisible(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == R.id.rash) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("app", true);
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
        if (v == think) {
            Intent intent = new Intent(MakeMagicActivity.this, MagicCardActivity.class);
            startActivity(intent);
        }
    }
}