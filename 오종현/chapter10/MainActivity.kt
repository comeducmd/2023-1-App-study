package com.dreamfilm.kotlintester

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
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
import com.dreamfilm.kotlintester.databinding.ActivityMainBinding
import androidx.core.app.RemoteInput
import androidx.core.content.ContextCompat

//checkbutton의 이벤트를 수신하려면 AppCompatActivity() 뒤에 CompoundButton.OnCheckedChangeListener를 붙이고
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if(it.all { permission -> permission.value == true}) {
                noti()
            } else {
                Toast.makeText(this, "권한이 거부됨", Toast.LENGTH_SHORT).show()
            }
        }

        binding.notificationBtn.setOnClickListener {
            if(Build.VERSION.SDK_INT >= 33) {
                if(ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
                == PackageManager.PERMISSION_GRANTED) {
                    noti()
                } else {
                    permissionLauncher.launch(arrayOf("android.permission.POST_NOTIFICATIONS"))
                }
            } else {
                noti()
            }
        }
    }

    fun noti(){
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        if(Build.VERSION.SDK_INT >= 26) {
            val channelId = "first channel"
            val channelName = "첫번째 채널 알림"
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "이곳에는 알림의 세부사항이 들어갑니다."
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            
            //채널을 notificationmanager에 등록
            manager.createNotificationChannel(channel)
            //채널을 이용하여 builder생성
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        
        builder.run { 
            setSmallIcon(R.drawable.round_button)
            setWhen(System.currentTimeMillis())
            setContentTitle("37.2도")
            setContentText("안녕하세요 이것은 알림이예요")
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.round_button))
        }
        
        val KEY_TEXT_REPLY = "key_text_reply"
        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run { 
            setLabel("답장")
            build()
        }
        val replyIntent = Intent(this, ReplyReceiver::class.java)
        val replyRendingIntent = PendingIntent.getBroadcast(this, 372, replyIntent, PendingIntent.FLAG_MUTABLE)
        
        builder.addAction(
            NotificationCompat.Action.Builder(R.drawable.round_button, "답장", replyRendingIntent).addRemoteInput(remoteInput).build()
        )
        manager.notify(372, builder.build())
    }
}
