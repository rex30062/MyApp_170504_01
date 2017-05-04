package com.cclz.myapp_170504_01;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;
    final int NOTIFICATION_ID=321;  //  通知編號
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void click1(View v){ // 通知
        Intent it = new Intent(MainActivity.this, DetailActivity.class);
        String msg="這是通知的內容....";
        it.putExtra("msg", msg);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 123, it, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder=new Notification.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("這是通知")
//                .setContentText("這是內容...")
                .setContentText(msg)
                .setContentIntent(pi)
                .setAutoCancel(true);   // 點通知後自動消失
        Notification notification = builder.build();
        manager.notify(NOTIFICATION_ID, notification);
    }

    public void click2(View v){ // 取消(關)通知
        manager.cancel(NOTIFICATION_ID);
    }

}
