package com.example.androidfinalproject2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyJobService extends JobService {
    public static final String CHANNEL_ID="channel1";
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        getNotiefiicaion();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }


    void getNotiefiicaion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel name",
                    NotificationManager.IMPORTANCE_DEFAULT);//حسب اهمية لشعار للمستخدم
            NotificationManager manager = getSystemService(NotificationManager.class);//عليك انتا تظهر لشعار للمستخدم
            // Notification هان بنقول للسستم انا عملت ال
            manager.createNotificationChannel(channel);
        }
        //انتقال لما اضغط ع الاشعار ينقلني ع التطبيق او اي مكان داخل التطبيق
        Intent intent = new Intent(getBaseContext(),ActivityLevels.class);
        PendingIntent pi = PendingIntent.getActivity(MyJobService.this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MyJobService.this, CHANNEL_ID);//هان انتشأ اشعار فاضي
        builder.setSmallIcon(R.drawable.idea);
        builder.setContentTitle("Puzzle game");
        builder.setContentText("العب وحرك مخك الان");
        //اهمية الشعار
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.addAction(R.drawable.idea,"Action",pi);//بحط هان انو فيه انتقال
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MyJobService.this);
        managerCompat.notify(1, builder.build());
    }
}

