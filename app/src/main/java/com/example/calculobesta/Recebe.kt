package com.example.calculobesta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Recebe : AppCompatActivity() {

    lateinit var textViewlabelVariavel2:TextView
    lateinit var editTextResultadoNumber:EditText

    lateinit var buttonOK:Button
    lateinit var buttonCancelar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        val variavel = intent.extras?.getString("VARIAVEL")
        val valor = intent.extras?.getInt("VALOR")



        textViewlabelVariavel2 = findViewById(R.id.textViewlabelVariavel2)
        editTextResultadoNumber = findViewById(R.id.editTextResultadoNumber)

        textViewlabelVariavel2.text = variavel
        editTextResultadoNumber.setText(valor.toString())

        buttonOK = findViewById(R.id.buttonOK)
        buttonCancelar = findViewById(R.id.buttonCancelar)

        buttonOK.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            bundle.putInt("VALOR", editTextResultadoNumber.text.toString().toInt())
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            finish()
        }
        buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}