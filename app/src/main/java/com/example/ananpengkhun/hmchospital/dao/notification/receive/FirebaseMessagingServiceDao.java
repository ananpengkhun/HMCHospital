package com.example.ananpengkhun.hmchospital.dao.notification.receive;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.example.ananpengkhun.hmchospital.module.doctor.DoctorActivity;
import com.example.ananpengkhun.hmchospital.module.main.MainActivity;
import com.example.ananpengkhun.hmchospital.module.nurse.NurseActivity;
import com.example.ananpengkhun.hmchospital.module.patient.PatientActivity;
import com.example.ananpengkhun.hmchospital.module.reception.ReceptionActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class FirebaseMessagingServiceDao extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        Map<String, String> data = remoteMessage.getData();

        sendNotification(notification, data);
    }

    private void sendNotification(RemoteMessage.Notification notification, Map<String, String> data) {
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        for (Map.Entry entry : data.entrySet()) {
            Log.d("data", entry.getKey() + ", " + entry.getValue());
        }

        Intent intent = new Intent();
        int user_type = Integer.parseInt(data.get("user_type"));
        if(1 == user_type){
            intent.setClass(this,PatientActivity.class);
        }else if(2 == user_type){
            intent.setClass(this,DoctorActivity.class);
        }else if(3 == user_type){
            intent.setClass(this,NurseActivity.class);
        }else if(4 == user_type){
            intent.setClass(this,ReceptionActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .setContentInfo(notification.getTitle())
                .setLargeIcon(icon)
                .setColor(Color.RED)
                .setSmallIcon(R.mipmap.ic_launcher);

        try {
            String picture_url = data.get("picture_url");
            if (picture_url != null && !"".equals(picture_url)) {
                URL url = new URL(picture_url);
                Bitmap bigPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                notificationBuilder.setStyle(
                        new NotificationCompat.BigPictureStyle().bigPicture(bigPicture).setSummaryText(notification.getBody())
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        notificationBuilder.setLights(Color.YELLOW, 1000, 300);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
