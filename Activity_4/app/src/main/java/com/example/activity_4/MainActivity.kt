package com.example.activity_4
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 宣告 ActivityResultLauncher，負責處理從 SecActivity 回傳的結果
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { intent ->
                // 取得回傳的飲料名稱、甜度、冰塊的值
                val drink = intent.getStringExtra("drink")
                val sugar = intent.getStringExtra("sugar")
                val ice = intent.getStringExtra("ice")
                // 設定 tvMeal 的文字
                findViewById<TextView>(R.id.tvMeal).text = "飲料：$drink\n\n甜度：$sugar\n\n冰塊：$ice"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupWindowInsets()
        setupButton()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupButton() {
        val btnChoice = findViewById<Button>(R.id.btnChoice)
        btnChoice.setOnClickListener {
            // 使用 Intent 從 MainActivity 切換到 SecActivity
            val intent = Intent(this, SecActivity::class.java)
            startForResult.launch(intent)
        }
    }
}
