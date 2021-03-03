package com.example.wallpaperchangingserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonStartService, buttonStopService;
    EditText editTextHrs, editTextMinutes, editTextSeconds;
    int changeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartService = findViewById(R.id.buttonStart);
        buttonStopService = findViewById(R.id.buttonStop);

        editTextHrs = findViewById(R.id.editTextHrs);
        editTextMinutes = findViewById(R.id.editTextMinutes);
        editTextSeconds = findViewById(R.id.editTextSeconds);

        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* GET DATA FROM ALL 3 EDIT TEXTS*/
                String hrs = editTextHrs.getText().toString();
                String mins = editTextMinutes.getText().toString();
                String seconds = editTextSeconds.getText().toString();

                /* CHECK IF ANY EDIT TEXT HAS BEEN LEFT BLANK*/
                if (hrs.equals("") && mins.equals("") && seconds.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Time", Toast.LENGTH_SHORT).show();
                } else {
                    if (hrs.equals("")) {
                        hrs = "0";
                    }
                    if (mins.equals("")) {
                        mins = "0";
                    }
                    if (seconds.equals("")) {
                        seconds = "0";
                    }

                    /* CONVERT STRING DATA INTO INT */
                    int hrsInt = Integer.parseInt(hrs);
                    int minsInt = Integer.parseInt(mins);
                    int secondsInt = Integer.parseInt(seconds);

                    /* CONVERT ALL DATA INTO SECONDS*/
                    changeTime = (hrsInt * 60 * 60) + (minsInt * 60) + (secondsInt);

                    Bundle bundle = new Bundle();
                    bundle.putInt("ChangeTime", changeTime);
                    Intent intent = new Intent(MainActivity.this, WallpaperChangingService.class);
                    intent.putExtras(bundle);

                    startService(intent);

                    finish();

                }
            }
        });

        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, WallpaperChangingService.class));
                Toast.makeText(MainActivity.this, "Service has been Stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}