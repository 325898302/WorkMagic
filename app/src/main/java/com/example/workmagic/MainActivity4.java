package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

    ViewFlipper viewFlipper;
    TextView tv1;
    Button left;
    Button right;
    Animation anim2;

    Dialog d;
    Button bt1;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initViews();
        ballonAnim();
        tv1.startAnimation(anim2);


    }



    private void initViews() {

        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);


        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);

        anim2= AnimationUtils.loadAnimation(this,R.anim.anim2);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        tv1 = (TextView) findViewById(R.id.tv1);
    }


    private void ballonAnim() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },999999999);
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
        Animation in, out;
        if (v == left) {
            out = AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
            viewFlipper.setOutAnimation(out);
            in = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
            viewFlipper.setInAnimation(in);

            viewFlipper.showNext();

        }
        else if (v == right){
            out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
            viewFlipper.setOutAnimation(out);
            in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
            viewFlipper.setInAnimation(in);

            viewFlipper.showPrevious();

        }
    }
}