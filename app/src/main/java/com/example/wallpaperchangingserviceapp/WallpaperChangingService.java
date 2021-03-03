package com.example.wallpaperchangingserviceapp;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;

import java.io.IOException;

public class WallpaperChangingService extends Service {
    Bitmap bitmap1, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, bitmap7, bitmap8, bitmap9, bitmap10;
    int changeTime;
    WallpaperManager wallpaperManager;
    Boolean flag;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Bundle bundle = intent.getExtras();
        changeTime = bundle.getInt("ChangeTime");


        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
        bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.image3);
        bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.image4);
        bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.image5);
        bitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.image6);
        bitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.image7);
        bitmap8 = BitmapFactory.decodeResource(getResources(), R.drawable.image8);
        bitmap9 = BitmapFactory.decodeResource(getResources(), R.drawable.image9);
        bitmap10 = BitmapFactory.decodeResource(getResources(), R.drawable.image10);

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                flag = true;

                while (flag) {

                    try {
                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap1);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap2);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap3);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap4);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap5);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap6);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap7);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap8);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap9);
                        sleep(changeTime * 1000);

                        if (flag == false)
                            break;

                        wallpaperManager.setBitmap(bitmap10);
                        sleep(changeTime * 1000);

                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        thread.start();

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag = false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}