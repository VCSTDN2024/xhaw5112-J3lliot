package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FeeCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fee_calculator)

        val checkBoxLandscaping = findViewById<CheckBox>(R.id.checkBoxLandscaping)
        val checkBoxChildMinding = findViewById<CheckBox>(R.id.checkBoxChildMinding)
        val checkBoxGardenMaintenance = findViewById<CheckBox>(R.id.checkBoxGardenMaintenance)
        val checkBoxFirstAid = findViewById<CheckBox>(R.id.checkBoxFirstAid)
        val checkBoxSewing = findViewById<CheckBox>(R.id.checkBoxSewing)
        val checkBoxLifeSkills = findViewById<CheckBox>(R.id.checkBoxLifeSkills)
        val checkBoxCooking = findViewById<CheckBox>(R.id.checkBoxCooking)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val totalFeesText = findViewById<TextView>(R.id.textTotalFees)
        val priceBeforeDiscountText = findViewById<TextView>(R.id.textPriceBeforeDiscount)
        val discountAmountText = findViewById<TextView>(R.id.textDiscountAmount)

        btnCalculate.setOnClickListener {
            var totalFees = 0
            var selectedCourses = 0

            if (checkBoxLandscaping.isChecked) {
                totalFees += 1500
                selectedCourses++
            }
            if (checkBoxChildMinding.isChecked) {
                totalFees += 750
                selectedCourses++
            }
            if (checkBoxGardenMaintenance.isChecked) {
                totalFees += 750
                selectedCourses++
            }
            if (checkBoxCooking.isChecked) {
                totalFees += 750
                selectedCourses++
            }
            if (checkBoxFirstAid.isChecked) {
                totalFees += 1500
                selectedCourses++
            }
            if (checkBoxLifeSkills.isChecked) {
                totalFees += 1500
                selectedCourses++
            }
            if (checkBoxSewing.isChecked) {
                totalFees += 1500
                selectedCourses++
            }

            val discount = when (selectedCourses) {
                2 -> 0.05
                3 -> 0.10
                in 4..Int.MAX_VALUE -> 0.15
                else -> 0.0
            }

            val discountAmount = (totalFees * discount).toInt()
            val finalFees = totalFees - discountAmount


            totalFeesText.text = "Total Fees: R$finalFees"
            priceBeforeDiscountText.text = "Price Before Discount: R$totalFees"
            discountAmountText.text = "Discount Amount (${(discount * 100).toInt()}%): R$discountAmount"
        }

        val btnBackToHome = findViewById<Button>(R.id.btnBackToHome)

        btnBackToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}