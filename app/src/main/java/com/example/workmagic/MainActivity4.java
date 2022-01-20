package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    TextView tv1;
    Button left;
    Button right;
    Button btPhone;
    Animation anim2;
    ImageView imAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        imAnim = findViewById(R.id.imageview);
        initViews();
        ballonAnim();
        phone();
        tv1.startAnimation(anim2);

    }


    private void initViews() {

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        left = (Button) findViewById(R.id.left);
        left.setOnClickListener(this);
        right = (Button) findViewById(R.id.right);
        right.setOnClickListener(this);
        btPhone = (Button) findViewById(R.id.btPhone);
        btPhone.setOnClickListener(this);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }


    private void ballonAnim() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 999999999);
    }
    private void phone() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 999999999);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.rash) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        Animation in, out;

        if (v == btPhone) {

            Intent intent = new Intent();
            Uri data = Uri.parse("tel:" + "0503407888");
            intent.setData(data);
            intent.setAction(Intent.ACTION_DIAL);
            startActivity(intent);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }

        if (v == left) {
            out = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
            viewFlipper.setOutAnimation(out);
            in = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
            viewFlipper.setInAnimation(in);
            viewFlipper.showNext();

        } else if (v == right) {
            out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
            viewFlipper.setOutAnimation(out);
            in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
            viewFlipper.setInAnimation(in);

            viewFlipper.showPrevious();

        }
    }
}