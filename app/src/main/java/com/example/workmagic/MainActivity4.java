package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
    ImageView im;
    ViewFlipper viewFlipper;
    TextView tv1;
    Button next;
    Button previous;
    Animation scaleAnim;
    Animation anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        im = findViewById(R.id.imgeview);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        scaleAnim= AnimationUtils.loadAnimation(this,R.anim.anim1);
        anim2= AnimationUtils.loadAnimation(this,R.anim.anim2);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        tv1 = (TextView) findViewById(R.id.tv1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },900000000);

        tv1.startAnimation(anim2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if(id==R.id.rash) {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == next) {
            viewFlipper.startAnimation(scaleAnim);
            viewFlipper.showNext();
            viewFlipper.startAnimation(anim2);
        }
        else if (v == previous) {
            viewFlipper.startAnimation(scaleAnim);
            viewFlipper.showPrevious();

        }
    }
}