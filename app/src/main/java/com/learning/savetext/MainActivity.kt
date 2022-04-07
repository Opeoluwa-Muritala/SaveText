package com.learning.savetext

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Declaring EditText, Buttons and TextViews from the layout file

        val mEditText = findViewById<EditText>(R.id.edit_text)
        val mButtonSave = findViewById<Button>(R.id.button1)
        val mButtonShow = findViewById<Button>(R.id.button2)
        val mTextView = findViewById<TextView>(R.id.text_view)



        // What happens when Save Button is pressed

        mButtonSave.setOnClickListener {

            if(mEditText.text.toString().isNotEmpty()){



                // For First time: Creates a text file and writes string into it

                // Else: Opens the text file and writes the string

                try {
                    val fileOutputStream = openFileOutput("TextFile.txt", Context.MODE_PRIVATE)
                    val outputWriter = OutputStreamWriter(fileOutputStream)
                    outputWriter.write(mEditText.text.toString())
                    outputWriter.close()
                    Toast.makeText(baseContext, "Text saved successfully!", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else {
                Toast.makeText(applicationContext, "No input?", Toast.LENGTH_SHORT).show()
            }
        }



        // What happens when show button is pressed

        mButtonShow.setOnClickListener {



              // Tries to fetch data from the text file

            try {

                val fileInputStream = openFileInput("TextFile.txt")

                val inputReader = InputStreamReader(fileInputStream)

                val output = inputReader.readText()



                // Data is displayed in the TextView

                mTextView.text = output

            } catch (e: Exception) {

                e.printStackTrace()

            }

        }

    }
}