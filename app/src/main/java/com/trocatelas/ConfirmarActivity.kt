package com.trocatelas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmarActivity : AppCompatActivity() {
    private lateinit var tvQtd : TextView
    private lateinit var tvValor : TextView
    private lateinit var tvCodigo : TextView

    private lateinit var btEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        tvCodigo = findViewById(R.id.tvCodigo)
        tvValor = findViewById(R.id.tvValor)
        tvQtd = findViewById(R.id.tvQtd)

        btEnviar = findViewById(R.id.btEnviar)

        btEnviar.setOnClickListener{
            btEnviarOnClick()
        }

        val cod = intent.getStringExtra("cod")
        val qtd = intent.getStringExtra("qtd")
        val valor = intent.getStringExtra("valor")

        tvCodigo.setText(cod)
        tvValor.setText(valor)
        tvQtd.setText(qtd)
    }

    private fun btEnviarOnClick() {
        val smsBody = "Cod: ${tvCodigo.text} Qtd: ${tvQtd.text} Valor: ${tvValor.text}"
        val phoneNumber = "smsto:+5542999999999"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(phoneNumber)
            putExtra("sms_body", smsBody)
        }

//        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
//        } else {
//            Toast.makeText(this, "Não há aplicativo de SMS disponível.", Toast.LENGTH_SHORT).show()
//        }
    }

}