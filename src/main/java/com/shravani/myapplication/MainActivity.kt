package com.shravani.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ImageView

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var btn_calculator: Button
    lateinit var entered_height: EditText
    lateinit var entered_weight: EditText
    lateinit var bmi:TextView
    lateinit var logo:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "BMI Calculator"
        btn_calculator = findViewById(R.id.btn_calculator)
        bmi=findViewById(R.id.bmi)
        entered_height = findViewById(R.id.entered_height)
        entered_weight = findViewById(R.id.entered_weight)
        logo=findViewById(R.id.logo)







        btn_calculator.setOnClickListener() {

        val height=entered_height.text.toString().toInt()
        val weight=entered_weight.text.toString().toInt()

        val bmi_bmi=bmicalculator(height,weight)
            bmi.text=bmi_bmi.toString()
            bmi.visibility= View.VISIBLE
            if (bmi_bmi<18.5)
                Toast.makeText(applicationContext,"Oh no,you're underweight!",Toast.LENGTH_SHORT).show()
            if ((bmi_bmi>18.5)&&(bmi_bmi<24.9))
                Toast.makeText(applicationContext,"Oh yes,you're at normal weight!",Toast.LENGTH_SHORT).show()
            if ((bmi_bmi>25)&&(bmi_bmi<29.9))
                Toast.makeText(applicationContext,"Oops,you're overweight!",Toast.LENGTH_SHORT).show()
            if ((bmi_bmi>30)&&(bmi_bmi<39.9))
                Toast.makeText(applicationContext,"Red alert you're obese!",Toast.LENGTH_SHORT).show()

        }

    }




}

        private fun bmicalculator(height:Int,weight:Int):Float{
            var height2=height.toFloat()
            var BMI=(weight.toFloat()*10000)/(height*height)
            return BMI

        }