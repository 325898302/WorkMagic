package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakeMagicActivity extends AppCompatActivity implements View.OnClickListener {

    Button think;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makemagic);
        think= findViewById(R.id.think);
        think.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==think){
            Intent intent= new Intent(MakeMagicActivity. this, MagicCard.class);
            startActivity(intent);
        }
    }

}