package com.example.dividircuentasv1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            Column {
                QuantityTextField()
                ComensalesTextField()
                RedondearPropina()
                SliderValoracion()
                Calcular{}
            }
        }
    }
}


@Composable
fun QuantityTextField() {
    var cantidad by remember { mutableStateOf("") }
    OutlinedTextField(
        value = cantidad,
        onValueChange = {newValue -> cantidad = newValue},
        placeholder = { Text("Cantidad")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )
}

@Composable
fun ComensalesTextField(){
    var numeroComensales by remember {mutableStateOf("")}
    OutlinedTextField(
        value = numeroComensales,
        onValueChange = {},
        placeholder = { Text("Comensales")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )
}

@Composable
fun RedondearPropina() {
    var checked by remember { mutableStateOf(false) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}


@Composable
fun SliderValoracion() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..5f,
            steps = 5
        )
        Text(text = sliderPosition.toString())
}


@Composable
fun Calcular(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Calcular")
    }
}

@Composable
fun calcularCantidadTotal(){
    var total = QuantityTextField()  ComensalesTextField()
}

@Composable
fun ApagarCadaUno(){

}

@Preview(showBackground = true)
@Composable
fun Preview(){
    QuantityTextField()
    ComensalesTextField()
    RedondearPropina()
    SliderValoracion()
    Calcular {  }
}