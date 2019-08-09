package mobile.engsoft.ufrn.com.br.calculadoraimc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_alterar_dados.*

class AlterarDadosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_dados)

        btnAlterar.setOnClickListener {
            var valor = etValor.text
            Log.v("exercicio-valor", valor.toString())

            var variavel = intent.getStringExtra("VARIAVEL")
            Log.v("exercicio-variavel", variavel.toString())

            var newIntent = Intent(this, MainActivity::class.java)

            if(variavel == "PESO"){
                intent.putExtra("VALOR_PESO", valor)
                newIntent.putExtra("VALOR_PESO", valor)
            } else if (variavel == "ALTURA"){
                intent.putExtra("VALOR_ALTURA", valor)
                newIntent.putExtra("VALOR_ALTURA", valor)
            }

            //startActivity(newIntent)
            startActivityForResult(newIntent, 1)
        }
    }
}
