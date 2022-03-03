package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NumDiscoveryActivity extends AppCompatActivity {

    TextView numOfUse;
    ImageView imGifFirework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_discovery);
        numOfUse = findViewById(R.id.numOfUse);
        imGifFirework = findViewById(R.id.imGifFirework);

        Intent intent=new
        numOfUse.setText();
        Glide.with(getApplicationContext()).load(R.drawable.fireworks).into(imGifFirework);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 900000000);
    }
}