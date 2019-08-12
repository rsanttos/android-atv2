package mobile.engsoft.ufrn.com.br.calculadoraimc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var peso: Float = 0.0F
    var altura: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAltura.setOnClickListener{
            var newIntent = Intent(this, AlterarDadosActivity::class.java)
            newIntent.putExtra("VARIAVEL", "ALTURA")
            startActivityForResult(newIntent, 1)
        }

        btnPeso.setOnClickListener {
            var newIntent = Intent(this, AlterarDadosActivity::class.java)
            newIntent.putExtra("VARIAVEL", "PESO")
            startActivityForResult(newIntent, 1)
        }

        btnCalcular.setOnClickListener {
            calculaImc()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var alturaTmp = data?.getStringExtra("VALOR_ALTURA")
        var pesoTmp = data?.getStringExtra("VALOR_PESO")

        if(alturaTmp != null) {
            tvAltura.text = "Altura: $alturaTmp m"
            altura = alturaTmp.toFloat()
        }

        if(pesoTmp != null) {
            tvPeso.text = "Peso: $pesoTmp kg"
            peso = pesoTmp.toFloat()
        }

        Log.v("imc-ex-peso", peso.toString())
        Log.v("imc-ex-altura", altura.toString())
    }

    fun calculaImc(){
        var imc = peso / (altura * altura)
        var texto = ""
        if(imc < 16){
            texto = "Magreza leve"
        } else if (imc >= 16 && imc < 17){
            texto = "Magreza moderada"
        } else if (imc >= 17 && imc < 18.5) {
            texto = "Magreza leve"
        } else if (imc >= 18.5 && imc < 25) {
            texto = "Saudável"
        } else if (imc >= 25 && imc < 30) {
            texto = "Sobrepeso"
        } else if (imc >= 30 && imc < 35) {
            texto = "Obesidade Grau I"
        } else if (imc >= 35 && imc < 40) {
            texto = "Obesidade Grau II (severa)"
        } else {
            texto = "Obseidade Grau III (mórbida)"
        }

        tvResultadoImc.text = "IMC: $imc"
        tvResultadoImcTexto.text = texto

    }
}
