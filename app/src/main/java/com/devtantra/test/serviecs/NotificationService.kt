package com.devtantra.test.serviecs

import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.devtantra.test.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * A service class for FireBase notifications
 *
 * @author Ranosys Technologies
 */
class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d("notifications",remoteMessage.toString())

        var i: Intent = Intent(this, MainActivity::class.java)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)

        //showNotification(remoteMessage.getData());
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private fun showNotification(messageBody: Map<String, String>) {

    }

    /* private NotificationCompat.Builder getNotificationBuilder() {
        NotificationCompat.Builder notificationBuilder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationBuilder = new NotificationCompat.Builder(this, notificationChannel());
        } else {
            notificationBuilder = new NotificationCompat.Builder(this,"some_channel_id");
        }
        return notificationBuilder;
    }*/

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun notificationChannel() {

    }

    private fun showNotificationWithId(
        messageBody: Map<String, String>,
        notificationBuilder: NotificationCompat.Builder
    ) {
        val intent: Intent
        var pendingIntent: PendingIntent? = null
        val bundle = Bundle()
        if (null != messageBody["type"]) {


        }
        if (null != pendingIntent) {
            notificationBuilder.setContentIntent(pendingIntent)
        }
    }
}