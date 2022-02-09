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
import android.widget.TableRow;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageview;
    Button b1, b2, b3;
    Animation anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = findViewById(R.id.imageview);
        anim2= AnimationUtils.loadAnimation(this,R.anim.anim2);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);



        Glide.with(getApplicationContext()).load(R.drawable.fire2).into(imageview);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        },900000000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if(id==R.id.phone) {
            Intent intent=new Intent(this,MainActivity4.class);
            intent.putExtra("menu", true);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if (v==b1){
            Intent intent= new Intent(MainActivity. this, MainActivity2.class);
            startActivity(intent);
        }
        if (v==b2){
            Intent intent= new Intent(MainActivity. this, MainActivity3.class);
            startActivity(intent);
        }
        if (v==b3){
            Intent intent= new Intent(MainActivity. this, MainActivity4.class);
            intent.putExtra("menu", false);//
            startActivity(intent);
        }
    }

}