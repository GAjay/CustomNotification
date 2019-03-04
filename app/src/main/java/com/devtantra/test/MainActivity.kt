package com.devtantra.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.devtantra.test.serviecs.SavedPreferences
import android.content.Intent
import android.net.Uri
import android.net.Uri.fromParts
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_email->{
                if(!TextUtils.isEmpty(SavedPreferences.getInstance(applicationContext).deviceToken)) {
                    val emailIntent = Intent(
                        Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "devakm95@gmail.com", null
                        )
                    )
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Device Token")
                    emailIntent.putExtra(Intent.EXTRA_TEXT, SavedPreferences.getInstance(applicationContext).deviceToken)
                    startActivity(Intent.createChooser(emailIntent, "Send email..."))
                }
                else{
                    Toast.makeText(this,"Token not generated. plz wait for while.",Toast.LENGTH_LONG)
                }
            }
            else->{
                Toast.makeText(this,"Token not created",Toast.LENGTH_LONG)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_email).setOnClickListener(this)


    }


}
