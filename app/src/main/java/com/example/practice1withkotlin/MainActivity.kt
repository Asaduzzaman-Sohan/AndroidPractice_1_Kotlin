package com.example.practice1withkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var showBtn: Button
    private lateinit var hideBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var displayImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBtn = findViewById(R.id.showImg)
        hideBtn = findViewById(R.id.hideImg)
        nextBtn = findViewById(R.id.nextBtn)
        displayImg = findViewById(R.id.displayImg)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        showBtn.setOnClickListener(View.OnClickListener {

            displayImg.visibility = View.VISIBLE
            val snackBar = Snackbar.make(constraintLayout, "Image Visible", Snackbar.LENGTH_SHORT)
            snackBar.setAction("Undo"){
                displayImg.visibility = View.GONE
                val redo = Snackbar.make(constraintLayout, "Image gone", Snackbar.LENGTH_SHORT)
                redo.setAction("Redo"){
                    displayImg.visibility = View.VISIBLE
                    Snackbar.make(constraintLayout, "Action redone", Snackbar.LENGTH_SHORT).show()
                }
                redo.show()
            }
            snackBar.show()
        })

        hideBtn.setOnClickListener(View.OnClickListener {
            displayImg.visibility = View.INVISIBLE
            Toast.makeText(this@MainActivity, "Image has been hidden", Toast.LENGTH_SHORT).show()
        })

        displayImg.setOnClickListener(View.OnClickListener {

            val current = displayImg.drawable
            val savana = resources.getDrawable(R.drawable.savana)

            if (current.constantState == savana.constantState){
                displayImg.setImageDrawable(resources.getDrawable(R.drawable.waterfall))
            }
            else{
                displayImg.setImageDrawable(savana)
            }

        })

        nextBtn.setOnClickListener(View.OnClickListener {
            val nextPage = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(nextPage)
        })

    }
}