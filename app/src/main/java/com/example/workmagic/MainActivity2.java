package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button think;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        think=(Button) findViewById(R.id.think);
        think.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==think){
            Intent intent= new Intent(MainActivity2. this, MagicCard.class);
            startActivity(intent);
        }
    }

}