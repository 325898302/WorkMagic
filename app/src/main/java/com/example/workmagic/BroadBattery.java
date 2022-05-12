package com.example.workmagic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadBattery extends BroadcastReceiver {
    int time=0;
    int firPer=0;
    BroadBattery() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int percentage;

        percentage = intent.getIntExtra("level", 0);
        if (time == 0 && percentage < 11) {
            firPer = percentage;
            Toast.makeText(context, "החושים שלי קולטים שהבטריה שלך נחלשת!", Toast.LENGTH_SHORT).show();
            time++;

        }
        if (time == 1 && percentage < firPer) {
            Toast.makeText(context, "מהר לשלוח אלי את הפרטים על המופע שלך!", Toast.LENGTH_SHORT).show();
            time++;
        }
    }
}

