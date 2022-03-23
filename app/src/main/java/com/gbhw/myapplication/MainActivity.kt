package com.gbhw.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.click_text_view)
        val textview2 = findViewById<TextView>(R.id.data_textview)
        val textview3 = findViewById<TextView>(R.id.data2_textview)
        val textview4 = findViewById<TextView>(R.id.data3_textview)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            textView1.text = (textView1.text.toString().toInt() + 1).toString()

            if (textView1.text.toString().toInt() == 1 || textView1.text.toString().toInt() == 2 || textView1.text.toString().toInt() == 3) {
                textview4.text = doSomethingElse(textView1.text.toString().toInt())
            } else if (textView1.text.toString().toInt() == 4) {
                textview4.text = "no data"
            } else {
                textView1.text = "0"
            }
        }

        val data = doSomething(textview2)
        textview3.text = data.copy(valueB = "pears").toString()
    }

    private fun doSomething(textview: TextView): SomeDataClass {
        val data = SomeDataClass(3, "apples")
        textview.text = String.format("%d %S", data.valueA, data.valueB)
        return data
    }

    private fun doSomethingElse(cycle: Int): String {
        val txt: StringBuilder = StringBuilder()
        when (cycle) {
            1 -> {
                for (i in 1..10) {
                    txt.append("$i apple(s); \n")
                }
            }
            2 -> {
                for (i in 12 downTo 1 step 3) {
                    txt.append("$i pear(s); \n")
                }
            }
            3 -> {
                for (i in 0 until 5) {
                    txt.append("$i banana(s); \n")
                }
            }
        }
        return txt.toString()
    }
}