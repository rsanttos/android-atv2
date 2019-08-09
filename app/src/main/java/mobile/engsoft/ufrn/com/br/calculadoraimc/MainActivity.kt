package mobile.engsoft.ufrn.com.br.calculadoraimc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAltura.setOnClickListener{
            var newIntent = Intent(this, AlterarDadosActivity::class.java)
            newIntent.putExtra("VARIAVEL", "ALTURA")
            startActivity(newIntent)
        }

        btnPeso.setOnClickListener {
            var newIntent = Intent(this, AlterarDadosActivity::class.java)
            newIntent.putExtra("VARIAVEL", "PESO")
            //startActivityForResult(newIntent, 1)
            startActivity(newIntent)
        }

        btnCalcular.setOnClickListener {

        }

        //initialize()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Log.v("exercicio-ac1-valor", "chamou aqui")

        super.onActivityResult(requestCode, resultCode, data)
    }

    fun initialize(){

        var pesoStr: String?
        var alturaStr: String?

        pesoStr = this.intent.getStringExtra("VALOR_PESO")
        alturaStr = intent.getStringExtra("VALOR_ALTURA")
        if(pesoStr != null) {
            Log.v("exercicio-ac1-valor", pesoStr)
        }
        if(alturaStr != null) {
            Log.v("exercicio-ac1-valor", alturaStr)
        }

        var peso = intent.getIntExtra("VALOR_PESO", 0)
        var altura = intent.getFloatExtra("VALOR_ALTURA", 0.0F)

        var pesoTxt = "Peso: $peso kg"
        var alturaTxt = "Altura: $altura m"

        tvPeso.text = pesoTxt
        tvAltura.text = alturaTxt

    }

    override fun onStart() {
        initialize()

        super.onStart()
    }
}
