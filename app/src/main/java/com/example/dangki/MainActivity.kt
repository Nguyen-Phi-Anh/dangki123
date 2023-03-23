package com.example.dangki

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.dangki.Database.dkroomDatabase
import com.example.dangki.model.dangki


@Suppress("UNREACHABLE_CODE")

class MainActivity : AppCompatActivity() {
    private lateinit var db: dkroomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            dkroomDatabase::class.java, "my-db"
        ).build()

        val btdangki = findViewById<Button>(R.id.btdangki)
        btdangki.setOnClickListener{
            val Email= findViewById<TextView>(R.id.btemail).text.toString()
            val User = findViewById<TextView>(R.id.btname).text.toString()
            val Pass = findViewById<TextView>(R.id.btpass).text.toString()
            val repass = findViewById<TextView>(R.id.btrepass).text.toString()
            if (Pass == repass) {
                val dk = dangki(
                    userId = 0,
                    email = Email,
                    name =User,
                    pass = Pass
                )
                Thread {
                    db.dkDAO().insert(dk)
                }.start()
                Toast.makeText(
                    this@MainActivity,
                    "Đăng ký thành công!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Mật khẩu không Đúng!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}


