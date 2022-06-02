package com.example.workmagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.workmagic.R;

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
        Toast.makeText(this, "חכה שהמסך יעבור אוטומטית", Toast.LENGTH_SHORT).show();

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
