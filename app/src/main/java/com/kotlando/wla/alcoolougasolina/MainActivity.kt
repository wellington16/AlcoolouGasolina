
package com.kotlando.wla.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun botaoCalcular(view: View){

        //recuperar valores digitados
        val precoAlcool =  editText_preco_alcool.text.toString()
        val precoGasolina =  editText_preco_gasolina.text.toString()

        //validação
        val validaCampos = validarCampos(precoAlcool,precoGasolina)
        if(validaCampos) {
           calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            textView_resultado.setText("Preencha os preços com valores válidos!")
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean
    {
        var camposValidos: Boolean = true
        if (precoAlcool.isNullOrEmpty()){
            camposValidos = false
        }else if(precoGasolina.isNullOrEmpty()){
            camposValidos = false
        }else if(precoAlcool.toDouble() < 1 || precoGasolina.toDouble() < 1){
            camposValidos = false
        }
        return camposValidos
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        //converter os valores strings para double
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        //fórmula
        val resultadoPreco =  valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7){
            textView_resultado.setText("Melhor utilizar gasolina!")
        }else {
            textView_resultado.setText("Melhor utilizar álcool!")
        }
    }
}
