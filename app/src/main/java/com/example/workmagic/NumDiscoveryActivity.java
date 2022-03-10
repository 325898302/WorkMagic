package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class NumDiscoveryActivity extends AppCompatActivity {

    TextView numOfUse;
    ImageView imGifzikok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_discovery);
        numOfUse = findViewById(R.id.numOfUse);
        imGifzikok = findViewById(R.id.imGifzikok);

        Intent intent = getIntent();
        int selectNum = intent.getExtras().getInt("selectNum", 0);
        numOfUse.setText("" + selectNum);

        Glide.with(getApplicationContext()).load(R.drawable.zikok).into(imGifzikok);

        Thread closeActivity = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    // Do some stuff
                } catch (Exception e) {
                    e.getLocalizedMessage();
                }
                Intent intent = new Intent(NumDiscoveryActivity.this, MainActivity.class);
                intent.putExtra("app", true);
                startActivity(intent);
            }
        });
        closeActivity.start();

    }
}
