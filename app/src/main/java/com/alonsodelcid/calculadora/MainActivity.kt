package com.alonsodelcid.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtCatetoC : EditText
    lateinit var txtCatetoB : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCatetoC = findViewById(R.id.txtCatetoC)
        txtCatetoB = findViewById(R.id.txtCatetoB)
        btnLimpiar.setOnClickListener { limpiarCampos() }
        btnCalcular.setOnClickListener { calcularHipotenusa() }
    }

    private fun calcularHipotenusa(){
            if(validarCampos()) {
                var catetoB : Double = txtCatetoB.text.toString().toDouble()
                var catetoC : Double = txtCatetoC.text.toString().toDouble()
                var result : Double
                var bPow2 : Double = catetoB.pow(2)
                var cPow2 : Double = catetoC.pow(2)
                result = (bPow2 + cPow2).pow(.5)
                var mensaje = "El resultado es ${result}."
                mostrarMensaje(mensaje)
            } else {
                mostrarMensaje("Campos vacios")
            }
        }

    private fun validarCampos(): Boolean {
        return !txtCatetoB.text.toString().equals("") &&
                !txtCatetoC.text.toString().equals("")
    }

    private fun limpiarCampos() {
        txtCatetoB.setText("")
        txtCatetoC.setText("")
    }

    private fun mostrarMensaje(mensaje :String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

}