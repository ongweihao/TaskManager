package com.example.a15039840.taskmanager;

/**
 * Created by 15039840 on 25/5/2017.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TaskBroadcastReceiver extends BroadcastReceiver {

    int reqCode = 9;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent p = PendingIntent.getActivity(context, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(intent.getSerializableExtra("name").toString());
        builder.setContentText("Task");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(p);
        builder.setAutoCancel(true);
        Notification n = builder.build();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(9, n);
    }
}