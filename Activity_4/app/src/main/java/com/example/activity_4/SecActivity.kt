package com.example.activity_4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sec)

        // 設置 Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom)
            insets
        }

        // 初始化元件
        val edDrink = findViewById<TextView>(R.id.edDrink)
        val rgSugar = findViewById<RadioGroup>(R.id.rgSugar)
        val rgIce = findViewById<RadioGroup>(R.id.rgIce)
        val btnSend = findViewById<Button>(R.id.btnSend)

        // 設定 btnSend 的點擊事件
        btnSend.setOnClickListener {
            if (edDrink.text.isEmpty()) {
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            } else {
                // 創建 Intent 並將資料放入
                val resultIntent = Intent().apply {
                    putExtras(bundleOf(
                        "drink" to edDrink.text.toString(),
                        "sugar" to rgSugar.findViewById<RadioButton>(rgSugar.checkedRadioButtonId).text.toString(),
                        "ice" to rgIce.findViewById<RadioButton>(rgIce.checkedRadioButtonId).text.toString()
                    ))
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
