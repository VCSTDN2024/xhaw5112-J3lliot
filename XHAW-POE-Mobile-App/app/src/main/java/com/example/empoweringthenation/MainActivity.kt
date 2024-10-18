package com.example.empoweringthenation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sixMonthCoursesBtn = findViewById<Button>(R.id.btnSixMonthCourses)
        val sixWeekCoursesBtn = findViewById<Button>(R.id.btnSixWeekCourses)
        val contactBtn = findViewById<Button>(R.id.btnContact)
        val calculateFeesBtn = findViewById<Button>(R.id.btnCalculateFees)

        sixMonthCoursesBtn.setOnClickListener {
            val intent = Intent(this, SixMonthCoursesActivity::class.java)
            startActivity(intent)
        }

        sixWeekCoursesBtn.setOnClickListener {
            val intent = Intent(this, SixWeekCoursesActivity::class.java)
            startActivity(intent)
        }

        contactBtn.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        calculateFeesBtn.setOnClickListener {
            val intent = Intent(this, FeeCalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}