package com.example.calculobesta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var textVariavelX:TextView
    lateinit var textVariavelY:TextView
    lateinit var textViewResultado:TextView

    lateinit var buttonSetVariavelX:Button
    lateinit var buttonSetVariavelY:Button
    lateinit var buttonCalcular:Button

    var variavelX:Int = 0
    var variavelY:Int = 0
    var resultado:Int = 0

    val setVariavelXlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
            if(result.resultCode == RESULT_OK){
                variavelX = result.data!!.getIntExtra("VALOR", 0)
                textVariavelX.text = "${variavelX}"
            }else{
                Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show()
            }
    }
    val setVariavelYlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            variavelY = result.data!!.getIntExtra("VALOR", 0)
            textVariavelY.text = "${variavelY}"
        }else{
            Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textVariavelX = findViewById(R.id.TextViewVariavelX)
        textVariavelY = findViewById(R.id.TextViewVariavelY)
        textViewResultado = findViewById(R.id.TextviewVariavelResultado)

        textVariavelX.text = "${variavelX}"
        textVariavelY.text = "${variavelY}"
        textViewResultado.text = "${resultado}"

        buttonSetVariavelX = findViewById(R.id.buttonSetVariavelX)
        buttonSetVariavelY = findViewById(R.id.buttonSetVariavelY)
        buttonCalcular = findViewById(R.id.buttonCalcular)

        buttonSetVariavelX.setOnClickListener {
            val intent = Intent(this, Recebe::class.java)

            val bundle = Bundle()

            bundle.putString("VARIAVEL", "Variavel X")
            bundle.putInt("VALOR", variavelX)
            intent.putExtras(bundle)

            setVariavelXlauncher.launch(intent)

        }
        buttonSetVariavelY.setOnClickListener {
            val intent = Intent(this, Recebe::class.java)

            val bundle =Bundle()
            bundle.putString("VARIAVEL", "Variavel Y")
            bundle.putInt("VALOR", variavelY)
            intent.putExtras(bundle)

            setVariavelYlauncher.launch(intent)
        }
        buttonCalcular.setOnClickListener {
            Toast.makeText(this, getString(R.string.realizando_calculo), Toast.LENGTH_SHORT).show()

            var resultado = variavelX + variavelY
            textViewResultado.text = resultado.toString()
        }

    }
}