package com.example.helloapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mes: Array<String> =
            arrayOf("$ - tips\nWe are waiting for your return", "You entered an invalid value")
        val cost = findViewById<TextView>(R.id.totalCost)
        val button0 = findViewById<Button>(R.id.bad00)
        val button10 = findViewById<Button>(R.id.normal10)
        val button20 = findViewById<Button>(R.id.awesome20)
        val buttonZero = findViewById<Button>(R.id.onlyTips0)

        button0.setOnClickListener {
            val amount = findViewById<EditText>(R.id.amount).text.toString().replace(",", ".")
                .toDoubleOrNull()
            if (checker(amount)) {
                var amo = amount!! * 0.02
                amo = (amo * 100.0).roundToInt().toDouble() / 100
                cost.text = "${amount + amo}$\n$amo${mes[0]}"
            } else {
                cost.text = mes[1]
            }

        }
        button10.setOnClickListener {
            val amount = findViewById<EditText>(R.id.amount).text.toString().replace(",", ".")
                .toDoubleOrNull()
            if (checker(amount)) {
                var amo = amount!! * 0.1
                amo = (amo * 100.0).roundToInt().toDouble() / 100
                cost.text = "${amount + amo}$\n$amo${mes[0]}"
            } else {
                cost.text = mes[1]
            }
        }
        button20.setOnClickListener {
            val amount = findViewById<EditText>(R.id.amount).text.toString().replace(",", ".")
                .toDoubleOrNull()
            if (checker(amount)) {
                var amo = amount!! * 0.12
                amo = (amo * 100.0).roundToInt().toDouble() / 100
                cost.text = "${amount + amo}$\n$amo${mes[0]}"
            } else {
                cost.text = mes[1]
            }
        }
        buttonZero.setOnClickListener {
            val amount = findViewById<EditText>(R.id.amount).text.toString().replace(",", ".")
                .toDoubleOrNull()
            if (checker(amount)) {
                val amo = 0.0
                cost.text = "${amount!! + amo}$\n$amo${mes[0]}"
            } else {
                cost.text = mes[1]
            }
        }
    }
}

fun checker(amo: Double?): Boolean {
    return !((amo == null) || (amo < 0.0))
}