package com.harun.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException
import java.lang.reflect.Array


class MainActivity : AppCompatActivity() {
    private var screen:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screen=findViewById(R.id.screen)


    }


    fun onDigit(view: View){
       screen!!.append((view as Button).text.toString())
    }
    fun onClear(view: View){
        screen!!.text=""
    }
    fun calculate(view: View) {
        var result=0
        if (screen!!.text.contains("+")) {
            val separate = screen!!.text.split("+")
            try {
                 for(i in separate){
                     result+=i.toInt()
                 }
                screen!!.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "You don't have valid numbers added", Toast.LENGTH_SHORT).show()
            }
        } else if (screen!!.text.contains("-")) {
            val separate = screen!!.text.split("-")
            try {
                for(i in separate){
                    result-=i.toInt()
                }
                screen!!.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "You don't have valid numbers added", Toast.LENGTH_SHORT).show()
            }
        } else if (screen!!.text.contains("/")) {
            val separate = screen!!.text.split("/")
            try {
                result=1
                for(i in separate){
                    result/=i.toInt()
                }
                screen!!.text = result.toString()
                screen!!.text=""
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "You don't have valid numbers added", Toast.LENGTH_SHORT).show()
            }
        } else if (screen!!.text.contains("*")) {
            val separate = screen!!.text.split("*")
            try {
                result=1
                for(i in separate){
                    result*=i.toInt()
                }
                screen!!.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "You don't have valid numbers added", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "You didn't choose an operator", Toast.LENGTH_SHORT).show()
        }
    }
}