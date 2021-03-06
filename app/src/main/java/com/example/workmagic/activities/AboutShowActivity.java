package com.example.workmagic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.workmagic.R;
import com.example.workmagic.other.BroadBattery;
import com.example.workmagic.other.ServiceMusic;

public class AboutShowActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    Button left;
    Button right;
    Button btGifPhone;
    Button btPhone;
    Button btGifFace;
    Button btFace;
    ImageView imAnim;
    Button btGifWhat;
    Button btWhat;
    Dialog dialogDetails;
    EditText edName, edWhy, edSum, edAge, edCity, edPhone;
    ScrollView sv;
    final int REQUEST_CALL_PHONE_PERMISSION = 50;
    Button btSMS;
    BroadBattery battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutshow);
        initViews();


        if (((Boolean) getIntent().getExtras().get("menu"))) {
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
        viewFlipper = findViewById(R.id.viewFlipper);
        left = findViewById(R.id.left);
        left.setOnClickListener(this);
        btGifWhat = findViewById(R.id.btGifWhat);
        btGifWhat.setOnClickListener(this);
        btWhat= findViewById(R.id.btWhat);
        btWhat.setOnClickListener(this);
        btFace = findViewById(R.id.btFace);
        btFace.setOnClickListener(this);
        btGifFace = findViewById(R.id.btGifFace);
        btGifFace.setOnClickListener(this);
        right = findViewById(R.id.right);
        right.setOnClickListener(this);
        btPhone = findViewById(R.id.btPhone);
        btPhone.setOnClickListener(this);
        btGifPhone = findViewById(R.id.btGifPhone);
        btGifPhone.setOnClickListener(this);
        battery= new BroadBattery();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_keher_music, menu);
        SharedPreferences sp;
        MenuItem i = menu.findItem(R.id.music);
        sp = getSharedPreferences("sound", 0);
        if (sp.getBoolean("music", true)) {
            i.setIcon(R.drawable.musicyes);
        } else {
            i.setIcon(R.drawable.musicno);
        }
        i = menu.findItem(R.id.phone);  // ?????????? ???? ???????????? ???? phone
        i.setVisible(false);
        return true;
    }


    @Override  // ??????????
    protected void onStart() {
        super.onStart();
        registerReceiver(battery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(battery);
    }



    public void createDialogWhatsapp() {
        dialogDetails = new Dialog(this);
        dialogDetails.setContentView(R.layout.dialog_whatsapp);
        dialogDetails.setCancelable(true);
        btSMS = dialogDetails.findViewById(R.id.btSMS);
        btSMS.setOnClickListener(this);
        edName = dialogDetails.findViewById(R.id.name);
        edWhy = dialogDetails.findViewById(R.id.why);
        edSum = dialogDetails.findViewById(R.id.sum);
        edAge = dialogDetails.findViewById(R.id.age);
        edCity = dialogDetails.findViewById(R.id.city);
        edPhone = dialogDetails.findViewById(R.id.phone);

        dialogDetails.show();
    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, packageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
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
            intent.putExtra("app", true);
            startActivity(intent);
        }

        if (id == R.id.phone) {
            Intent intent = new Intent(this, AboutShowActivity.class);
            intent.putExtra("menu", true);
            startActivity(intent);
        }

        if (id == R.id.music) {
            SharedPreferences sp;
            sp = getSharedPreferences("sound", 0);
            SharedPreferences.Editor editor = sp.edit();
            if (sp.getBoolean("music", true)) {
                item.setIcon(R.drawable.musicno);
                stopService(new Intent(this, ServiceMusic.class));
                editor.putBoolean("music", false);
            } else {
                item.setIcon(R.drawable.musicyes);
                startService(new Intent(this, ServiceMusic.class));
                editor.putBoolean("music", true);
            }
            editor.apply();
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        Animation in, out;
        final String numPhone = "+972503407888";

        String st1 = "";
        String st2 = "";
        String st3 = "";
        String st4 = "";
        String st5 = "";
        String st6 = "";
        String text = "";

        if (v == btSMS) {

            st1 = edName.getText().toString();
            st2 = edWhy.getText().toString();
            st3 = edSum.getText().toString();
            st4 = edAge.getText().toString();
            st5 = edCity.getText().toString();
            st6 = edPhone.getText().toString();

            text = String.format("????????, ???????????? ???? %1$s, ?????? ???????? ???????? ?????????? ???????? ?????????? ?????????? ??%5$s ?????????? %2$s. ???????? ???????????????? ?????? %3$s, ???????? ???????????? ???? ???????????? ?????? %4$s. ????????, %6$s", st1, st2, st3, st4, st5, st6);

            boolean installed = isAppInstalled("com.whatsapp");
            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + numPhone + "&text=" + text));
                startActivity(intent);
            } else {
                Toast.makeText(AboutShowActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
            }
        }

        if (v == btPhone || v==btGifPhone) {

            Intent intent = new Intent();
            Uri data = Uri.parse("tel:" + "0503407888");
            intent.setData(data);
            intent.setAction(Intent.ACTION_DIAL);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(AboutShowActivity.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                return;
            }
            startActivity(intent);

        }

        if(v==btFace || v==btGifFace){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100080461939055"));
            startActivity(browserIntent);
        }

        if (v == btWhat || v==btGifWhat) {
            createDialogWhatsapp();
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