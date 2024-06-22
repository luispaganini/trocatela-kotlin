package com.trocatelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LancamentoActivity : AppCompatActivity() {
    private lateinit var etCodigo : EditText
    private lateinit var etQtd : EditText
    private lateinit var etValor : EditText

    private lateinit var btConfirmar : Button
    private lateinit var btListar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)

        etValor = findViewById(R.id.etValor)
        etQtd = findViewById(R.id.etQtd)
        etCodigo = findViewById(R.id.etCodigo)

        btListar = findViewById(R.id.btListar)
        btConfirmar = findViewById(R.id.btConfirmar)

        btConfirmar.setOnClickListener{
            btConfirmarOnClick()
        }

        btListar.setOnClickListener{
            btListarOnClick()
        }
    }

    private fun btListarOnClick() {
        val intent  = Intent(this, ListarActivity::class.java)

        getResult.launch(intent)
//        startActivity(intent)
    }

    private val getResult = registerForActivityResult( ActivityResultContracts.StartActivityForResult()) {
        if ( it.resultCode == RESULT_OK) {
            if ( it.data != null) {
                val retorno = it.data?.getIntExtra("codRetorno", 0)
                etCodigo.setText(retorno.toString())
            }
        }
    }

    private fun btConfirmarOnClick() {
        val intent = Intent(this, ConfirmarActivity::class.java)
        intent.putExtra("cod", etCodigo.text.toString())
        intent.putExtra("qtd", etQtd.text.toString())
        intent.putExtra("valor", etValor.text.toString())
        startActivity(intent)
    }
}