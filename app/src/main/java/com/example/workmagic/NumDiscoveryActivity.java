package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class NumDiscoveryActivity extends AppCompatActivity {

    TextView numOfUse;
    ImageView imGifFirework;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_discovery);
        numOfUse = (TextView) findViewById(R.id.numOfUse);
        imGifFirework = findViewById(R.id.imGifFirework);

//        Intent intent = getIntent();
//        String strNumOfUse = intent.getExtras().getString("selectNum");
//        Toast.makeText(this, " yff " + strNumOfUse, Toast.LENGTH_SHORT).show();
//        numOfUse.setText("welcone " + strNumOfUse);



        Glide.with(getApplicationContext()).load(R.drawable.fireworks).into(imGifFirework);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 900000000);
    }
}