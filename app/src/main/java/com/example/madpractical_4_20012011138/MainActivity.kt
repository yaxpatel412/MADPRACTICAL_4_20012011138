package com.example.madpractical_4_20012011138

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    internal var number: String = ""
    private val pickImage = 100
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonBrowse = findViewById<Button>(R.id.button_browse)
        buttonBrowse.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com")).apply { startActivity(this) }

        }

        var buttonCall = findViewById<Button>(R.id.button_call)
        buttonCall.setOnClickListener(View.OnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(number)))
            startActivity(intent)
        })

        var buttoncontact = findViewById<Button>(R.id.button_contact)
        buttoncontact.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply { startActivity(this) }
        }

        var buttoncalllog = findViewById<Button>(R.id.button_calllog)
        buttoncalllog.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply { startActivity(this) }
        }

        var buttongallary = findViewById<Button>(R.id.button_gallary)
        buttongallary.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").apply { startActivity(this) }
        }

        var buttoncamera = findViewById<Button>(R.id.button_camera)
        buttoncamera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply { startActivity(this) }
        }

        var buttonalarm = findViewById<Button>(R.id.button_alarm)
        buttonalarm.setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).apply { startActivity(this) }
        }
    }
}