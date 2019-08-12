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

        var variavel = intent.getStringExtra("VARIAVEL")
        if(variavel == "PESO"){
            tvLabel.text = "Peso: "
        } else if (variavel == "ALTURA"){
            tvLabel.text = "Altura: "
        }

        btnAlterar.setOnClickListener {
            var valor = etValor.text.toString()

            var newIntent = Intent(this, MainActivity::class.java)

            if(variavel == "PESO"){
                newIntent.putExtra("VALOR_PESO", valor)
            } else if (variavel == "ALTURA"){
                newIntent.putExtra("VALOR_ALTURA", valor)
            }

            setResult(1, newIntent)
            finish()
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }

}
