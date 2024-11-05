package com.example.lab6

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupWindowInsets()
        initializeButtons()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom)
            insets
        }
    }

    private fun initializeButtons() {
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnSnackBar = findViewById<Button>(R.id.btnSnackBar)
        val btnDialog1 = findViewById<Button>(R.id.btnDialog1)
        val btnDialog2 = findViewById<Button>(R.id.btnDialog2)
        val btnDialog3 = findViewById<Button>(R.id.btnDialog3)

        btnToast.setOnClickListener {
            showToast("預設 Toast")
        }

        btnSnackBar.setOnClickListener {
            showSnackbar(it)
        }

        btnDialog1.setOnClickListener {
            showDialogWithButtons()
        }

        btnDialog2.setOnClickListener {
            showDialogWithList()
        }

        btnDialog3.setOnClickListener {
            showDialogWithSingleChoice()
        }
    }

    private fun showSnackbar(view: View) {
        Snackbar.make(view, "按鈕式 Snackbar", Snackbar.LENGTH_SHORT)
            .setAction("按鈕") { showToast("已回應") }
            .show()
    }

    private fun showDialogWithButtons() {
        AlertDialog.Builder(this)
            .setTitle("按鈕式 AlertDialog")
            .setMessage("AlertDialog 內容")
            .setNeutralButton("左按鈕") { _, _ -> showToast("左按鈕") }
            .setNegativeButton("中按鈕") { _, _ -> showToast("中按鈕") }
            .setPositiveButton("右按鈕") { _, _ -> showToast("右按鈕") }
            .show()
    }

    private fun showDialogWithList() {
        val options = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")
        AlertDialog.Builder(this)
            .setTitle("列表式 AlertDialog")
            .setItems(options) { _, index -> showToast("你選的是${options[index]}") }
            .show()
    }

    private fun showDialogWithSingleChoice() {
        val options = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")
        var selectedPosition = 0
        AlertDialog.Builder(this)
            .setTitle("單選式 AlertDialog")
            .setSingleChoiceItems(options, selectedPosition) { _, index ->
                selectedPosition = index
            }
            .setPositiveButton("確定") { _, _ -> showToast("你選的是${options[selectedPosition]}") }
            .show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
