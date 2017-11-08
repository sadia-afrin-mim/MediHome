package com.example.esha.medihome.Yoga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;
import android.os.Vibrator;

import static android.widget.Toast.makeText;


/**
 * Created by fatema on 11/8/17.
 */

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        makeText(context,"Times up!!!..",Toast.LENGTH_LONG).show();
        Vibrator v= (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        v.vibrate(10000);
    }
}
