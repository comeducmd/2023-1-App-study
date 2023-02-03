package com.example.ch10_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent

//import android.app.RemoteInput
import androidx.core.app.RemoteInput
/* androidx.core.app.RemoteInput를 import하기 위해서는
기본으로 있던 위 android.app.RemoteInput를 제거(주석)해야함!
 */

import android.app.RemoteInput.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import com.example.ch10_notification.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            if(it.all { permission -> permission.value ==true }){
                noti()
            }else{
                Toast.makeText(this, "permission denied...", Toast.LENGTH_SHORT).show()
            }
        }
        binding.notificationButton.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                if(ContextCompat.checkSelfPermission(
                        this,
                        "android.permission.POST_NOTIFICATIONS"
                    )== PackageManager.PERMISSION_GRANTED){
                    noti()
                }
                else{
                    permissionLauncher.launch(
                        arrayOf(
                            "android.permission.POST_NOTIFICATIONS"
                        )
                    )
                }
            }else{
                noti()
            }
        }
        //setContentView(R.layout.activity_main)
        //기본으로 나와있는 위 문장을 제거해야 제대로 작동함 -> 왜일까...?
    }

    fun noti(){
        val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channelId="one-channel"
            val channelName="My Channel One"
            val channel=NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_DEFAULT).apply{
                description="my Channel One Description"
                setShowBadge(true)
                val uri: Uri =RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes= AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri,audioAttributes)
                enableVibration(true)

            }
            manager.createNotificationChannel(channel)
            builder=NotificationCompat.Builder(this, channelId)

        }else{
            builder=NotificationCompat.Builder(this)

        }
        builder.run {
            setSmallIcon(R.drawable.small)
            setWhen(System.currentTimeMillis())
            setContentTitle("권민선")
            setContentText("알림 설정 너무 어려워잉")
            setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.big))
        }
        val KEY_TEXT_REPLY="key_text_reply"
        var replyLabel="답장"
        var remoteInput: RemoteInput=RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()
        }
        val replyIntent= Intent(this, ReplyReceiver::class.java)
        val replyPendingIntent= PendingIntent.getBroadcast(
            this, 30, replyIntent, PendingIntent.FLAG_MUTABLE
        )
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.send,
                "답장",
                replyPendingIntent
            ).addRemoteInput(remoteInput).build()
        )
        manager.notify(11,builder.build())

    }

}
