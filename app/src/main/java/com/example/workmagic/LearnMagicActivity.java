package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LearnMagicActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6;

    Dialog d1;
    Dialog d2;
    Button bt1;
    Button bt2;
    Button btn1;
    int battery=0;

    BroadCastBattery broadCastBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnmagic);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4=(Button) findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5=(Button) findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6=(Button) findViewById(R.id.b6);
        b6.setOnClickListener(this);

        broadCastBattery=new BroadCastBattery();

        createLoginDialog1();
    }


    private class BroadCastBattery extends BroadcastReceiver
    {
        public void onReceive(Context context, Intent intent) {
            battery = intent.getIntExtra("level", 0);
            if (battery<10) {
                Toast.makeText(context, String.valueOf(battery) + " סוללה חלשה", Toast.LENGTH_SHORT).show();
                battery=100;
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadCastBattery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadCastBattery);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nomain, menu);
        return  true;
    }


    public void createLoginDialog1(){
        d1= new Dialog(this);
        d1.setContentView(R.layout.custom_layout);
        d1.setCancelable(true);
        bt1=(Button)d1.findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2=(Button)d1.findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        d1.show();

    }


    public void createLoginDialog2(){
        d2= new Dialog(this);
        d2.setContentView(R.layout.custom2);
        d2.setCancelable(true);
        btn1=(Button)d2.findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        d2.show();

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
        if(id==R.id.phone) {
            Intent intent=new Intent(this, AboutShowActivity.class);
            intent.putExtra("menu", true);//
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if (v==b1){
            String videoId = "rIMWKc-MVkI";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);

        }
        if (v==b2){
            String videoId = "wc0HuAzgPmY";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v==b3){
            String videoId = "U20JMr3BLXQ";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v==b4){
            String videoId = "bOgzdG6PEeQ";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v==b5){
            String videoId = "mWhKjVMlIl4";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }
        if (v==b6){
            String videoId = "2tjBPfBbCeo";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startActivity(intent);
        }

        if(v==bt1){
            Toast.makeText(this, "יופי!", Toast.LENGTH_SHORT).show();
            d1.dismiss();
        }
        if(v==bt2){
            Toast.makeText(this, "נסביר שוב", Toast.LENGTH_SHORT).show();
            d1.dismiss();
            createLoginDialog2();
        }
        if(v==btn1){
            d2.dismiss();
        }
    }
}