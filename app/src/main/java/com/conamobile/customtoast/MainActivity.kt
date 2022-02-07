package com.conamobile.customtoast

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showToastBtn = findViewById<Button>(R.id.show_toast)
        showToastBtn.setOnClickListener {
            Toast(this).showCustomToast("Hello", this)
        }
    }
}

fun Toast.showCustomToast(message: String, activity: Activity) {
    val layout = activity.layoutInflater.inflate(
        R.layout.custom_toast,
        activity.findViewById(R.id.toast_layout_container)
    )

    val toastMessage = layout.findViewById<TextView>(R.id.toast_message)
    toastMessage.text = message

    this.apply {
        setGravity(Gravity.BOTTOM, 0, 200)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}