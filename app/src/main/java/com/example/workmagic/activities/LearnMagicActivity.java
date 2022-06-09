package com.example.workmagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.workmagic.R;
import com.example.workmagic.other.ServiceMusic;

public class LearnMagicActivity extends AppCompatActivity implements View.OnClickListener {
    Button bFanCard, bEightRed, bKingQuin, bFourCard, bRedBlack, bForeTold;
    Dialog dialogExp;
    Button btExp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnmagic);
        bFanCard = findViewById(R.id.bFanCard);
        bFanCard.setOnClickListener(this);
        bEightRed = findViewById(R.id.bEightRed);
        bEightRed.setOnClickListener(this);
        bKingQuin = findViewById(R.id.bKingQuin);
        bKingQuin.setOnClickListener(this);
        bFourCard = findViewById(R.id.bFourCard);
        bFourCard.setOnClickListener(this);
        bRedBlack = findViewById(R.id.bRedBlack);
        bRedBlack.setOnClickListener(this);
        bForeTold = findViewById(R.id.bForeTold);
        bForeTold.setOnClickListener(this);
        createLoginDialog2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nomain, menu);
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


    public void createLoginDialog2() {
        dialogExp = new Dialog(this);
        dialogExp.setContentView(R.layout.dialog_exp);
        dialogExp.setCancelable(true);
        btExp = dialogExp.findViewById(R.id.btExp);
        btExp.setOnClickListener(this);
        dialogExp.show();

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
        if (id == R.id.phone) {
            Intent intent = new Intent(this, AboutShowActivity.class);
            intent.putExtra("menu", true);
            startActivity(intent);
        }
        if (id == R.id.music) {
            SharedPreferences sp;
            sp = getSharedPreferences("sound", 0);
            SharedPreferences.Editor editor = sp.edit();
            if (sp.getBoolean("music", true))
            {
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
        if (v == bFanCard) {
            String videoId = "rIMWKc-MVkI";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == bEightRed) {
            String videoId = "wc0HuAzgPmY";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == bKingQuin) {
            String videoId = "U20JMr3BLXQ";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == bFourCard) {
            String videoId = "bOgzdG6PEeQ";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == bRedBlack) {
            String videoId = "mWhKjVMlIl4";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == bForeTold) {
            String videoId = "2tjBPfBbCeo";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }

        if (v == btExp) {
            dialogExp.dismiss();
        }
    }
}