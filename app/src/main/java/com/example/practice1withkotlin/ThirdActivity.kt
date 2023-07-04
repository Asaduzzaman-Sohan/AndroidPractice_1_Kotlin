package com.example.practice1withkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.practice1withkotlin.databinding.ActivityThirdBinding
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {


    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.showBtn.setOnClickListener(View.OnClickListener {
            binding.displayView.visibility = View.VISIBLE
            val snackBar = Snackbar.make(binding.constraintBinding, "Image's show (Binding)", Snackbar.LENGTH_SHORT)
            snackBar.setAction("Undo"){
                binding.displayView.visibility = View.GONE
                val redo = Snackbar.make(binding.constraintBinding, "Image Gone (Binding)", Snackbar.LENGTH_SHORT)
                redo.setAction("Redo"){
                    binding.displayView.visibility = View.VISIBLE
                    Snackbar.make(binding.constraintBinding, "Action redo", Snackbar.LENGTH_SHORT).show()
                }
                redo.show()
            }
            snackBar.show()
        })

        binding.hideBtn.setOnClickListener(View.OnClickListener {
            binding.displayView.visibility = View.INVISIBLE
            Toast.makeText(this@ThirdActivity, "Image has been hidden (Biding)", Toast.LENGTH_SHORT).show()
        })

        binding.displayView.setOnClickListener(View.OnClickListener {

            val currentImg = binding.displayView.drawable
            val tree = resources.getDrawable(R.drawable.tree)
            val mountain = resources.getDrawable(R.drawable.mountain)

            if (currentImg.constantState == tree.constantState){
                binding.displayView.setImageDrawable(mountain)
            }
            else{
                binding.displayView.setImageDrawable(tree)
            }

        })

        binding.nextPage.setOnClickListener(View.OnClickListener {
            val next = Intent(this@ThirdActivity, FourthActivity::class.java)
            startActivity(next)
        })

        binding.noBinding.setOnClickListener(View.OnClickListener {
            val noBinding = Intent(this@ThirdActivity, MainActivity::class.java)
            startActivity(noBinding)
        })

    }
}