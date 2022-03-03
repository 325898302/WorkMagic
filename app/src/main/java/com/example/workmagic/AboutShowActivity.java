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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class AboutShowActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    TextView tv1;
    Button left;
    Button right;
    Button btPhone;
    ImageView imAnim;
    Button btWhatsApp;
    Dialog dialog1;
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    ScrollView sv;

    Button btSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutshow);
        initViews();
        ballonAnim();
        phone();


        if(((Boolean) getIntent().getExtras().get("menu"))){
            sv.post(new Runnable() {
                public void run() {
                    sv.fullScroll(View.FOCUS_DOWN);
                }
            });
        }

    }

    private void initViews() {
        imAnim = findViewById(R.id.imageFire);
        sv = findViewById(R.id.sv);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        left = (Button) findViewById(R.id.left);
        left.setOnClickListener(this);
        btWhatsApp = (Button) findViewById(R.id.btWhatsApp);
        btWhatsApp.setOnClickListener(this);
        right = (Button) findViewById(R.id.right);
        right.setOnClickListener(this);
        btPhone = (Button) findViewById(R.id.btPhone);
        btPhone.setOnClickListener(this);
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
        getMenuInflater().inflate(R.menu.menu_nomain, menu);
        return true;
    }

    public void createLoginDialog1(){
        dialog1= new Dialog(this);
        dialog1.setContentView(R.layout.dialogwhatsapp);
        dialog1.setCancelable(true);
        btSMS = (Button)dialog1. findViewById(R.id.btSMS);
        btSMS.setOnClickListener(this);
        ed1 = (EditText)dialog1.findViewById(R.id.name);
        ed2 = (EditText)dialog1.findViewById(R.id.why);
        ed3 = (EditText)dialog1.findViewById(R.id.sum);
        ed4 = (EditText)dialog1.findViewById(R.id.age);
        ed5 = (EditText)dialog1.findViewById(R.id.city);
        ed6 = (EditText)dialog1.findViewById(R.id.phone);

        dialog1.show();
    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, packageManager.GET_ACTIVITIES);
            is_installed= true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed= false;
            e.printStackTrace();
        }
        return is_installed;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.rash) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(id==R.id.phone) {
            Intent intent=new Intent(this, AboutShowActivity.class);
            intent.putExtra("menu", true);//
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        Animation in, out;
        final String numPhone= "+972503407888";

        String st1="";
        String st2="";
        String st3="";
        String st4="";
        String st5="";
        String st6="";
        String text="";

        if (v== btSMS){
            
            st1= ed1.getText().toString();
            st2= ed2.getText().toString();
            st3= ed3.getText().toString();
            st4= ed4.getText().toString();
            st5= ed5.getText().toString();
            st6= ed6.getText().toString();

            text= String.format("שלום, קוראים לי %1$s, אני אשמח לקבל פרטים לגבי הופעת קסמים ב%5$s לכבוד %2$s. כמות המשתתפים היא %3$s, הגיל המרכזי של ההופעה הוא %4$s. תודה, %6$s", st1, st2, st3, st4, st5, st6);

            boolean installed= isAppInstalled ("com.whatsapp");
            if (installed){
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ numPhone +"&text="+ text));
                startActivity(intent);
            }
            else
            {
                Toast.makeText(AboutShowActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
            }
        }

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

        if (v == btWhatsApp) {
            createLoginDialog1();
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