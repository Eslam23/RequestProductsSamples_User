package com.example.userrequestsample

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        val cancel: Button = findViewById(R.id.btn_cancelOrder)
        val edit:Button = findViewById(R.id.btn_editOrder)
        cancel.setOnClickListener {
            val alertDialog =
                AlertDialog.Builder(this@LandingActivity)
                    .setTitle("Cancel Order")
                    .setMessage(
                        "Do you want to cancel your order ?"
                    )
                    .setPositiveButton(
                        "Yes"
                    ) { dialog: DialogInterface?, which: Int ->
                        Toast.makeText(this@LandingActivity,"Canceled successfully",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LandingActivity , DrugListActivity::class.java)
                        startActivity(intent)
                    }.setNegativeButton("cancel", null).create()
            alertDialog.show()
        }
        edit.setOnClickListener {
            val intent = Intent(this@LandingActivity , DrugListActivity::class.java)
            startActivity(intent)
        }
    }
}