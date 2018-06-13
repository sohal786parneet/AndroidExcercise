package com.college.lasalle.excercise2;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  SeekBar seekBar;
  TextView textView;
  Switch repeatSwitch;
  Button buttonConfirm;

  int hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textViewTimer);
        textView.setText(""+ hour);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(23);

        repeatSwitch = findViewById(R.id.switchRepeat);

        buttonConfirm = findViewById(R.id.btnConfirm);
        buttonConfirm.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //(n/100)* 23
                hour =  progress  ;
                textView.setText(progress+ ".00");




            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        createAlarm("Morning", hour, 0);
    }

    public void createAlarm(String message, int hour, int minutes) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);


        if( repeatSwitch.isChecked()){

            ArrayList<Integer> days = new ArrayList<Integer>();

            days.add(Calendar.MONDAY);
            days.add(Calendar.TUESDAY);
            days.add(Calendar.WEDNESDAY);
            days.add(Calendar.THURSDAY);
            days.add(Calendar.FRIDAY);
            days.add(Calendar.SATURDAY);
            days.add(Calendar.SUNDAY);

            intent.putExtra(AlarmClock.EXTRA_DAYS, days);

        }


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}//end of class
