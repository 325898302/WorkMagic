package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LearnMagicActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6;

    Dialog d2;
    Button btExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnmagic);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(this);

        createLoginDialog2();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nomain, menu);
        return true;
    }


    public void createLoginDialog2() {
        d2 = new Dialog(this);
        d2.setContentView(R.layout.dialog_custom);
        d2.setCancelable(true);
        btExp = (Button) d2.findViewById(R.id.btExp);
        btExp.setOnClickListener(this);
        d2.show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.rash) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.phone) {
            Intent intent = new Intent(this, AboutShowActivity.class);
            intent.putExtra("menu", true);//
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == b1) {
            String videoId = "rIMWKc-MVkI";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);

        }
        if (v == b2) {
            String videoId = "wc0HuAzgPmY";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == b3) {
            String videoId = "U20JMr3BLXQ";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == b4) {
            String videoId = "bOgzdG6PEeQ";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == b5) {
            String videoId = "mWhKjVMlIl4";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v == b6) {
            String videoId = "2tjBPfBbCeo";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }

        if (v == btExp) {
            d2.dismiss();
        }
    }
}