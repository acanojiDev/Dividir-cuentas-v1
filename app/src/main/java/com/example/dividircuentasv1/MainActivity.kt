package com.example.dividircuentasv1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            var cantidad by remember { mutableStateOf("") }
            var comensales by remember {mutableStateOf("")}
            var propinaVerificado by remember { mutableStateOf(false) }
            var propinaSlider by remember {mutableIntStateOf(0)}

            var totalConPropina by remember { mutableFloatStateOf(0f) }
            var cadaUno by remember { mutableFloatStateOf(0f) }
            Column {
                CantidadTextField(
                    cantidad,
                    onCantidadChange = {nuevaCantidad -> cantidad = nuevaCantidad}
                )
                ComensalesTextField(
                    comensales,
                    onNumeroComensalesChange = {nuevoComensales -> comensales = nuevoComensales}
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Redondear Propina")
                    RedondearPropinaSwitch(
                        propinaVerificado,
                        onPropinaChange = {nuevoEstadoPropina -> propinaVerificado = nuevoEstadoPropina}
                    )
                }
                Text(text = "Valoración")
                if(!propinaVerificado)
                    SliderPropina(
                        propinaSlider,
                        onSliderChange = {nuevaPropina -> propinaSlider = nuevaPropina},
                        enabled = false
                    )
                else
                    SliderPropina(
                        propinaSlider,
                        onSliderChange = {nuevaPropina -> propinaSlider = nuevaPropina},
                        enabled = true
                    )
                Calcular{
                    val (total, cadaUnoCalculo) = pagarTotal(cantidad,comensales,propinaSlider)
                    totalConPropina = total
                    cadaUno = cadaUnoCalculo
                }
                if(cantidad.isNotEmpty() && comensales.isNotEmpty()){
                    Text(text="Cantidad total: ${"%.2f".format(totalConPropina)}", fontSize = 25.sp)
                    Text(text="Cada uno: ${"%.2f".format(cadaUno)}", fontSize = 25.sp)
                }
            }
        }
    }
}


@Composable
fun CantidadTextField(
    cantidad:String,
    onCantidadChange: (String) -> Unit
) {

    OutlinedTextField(
        value = cantidad,
        onValueChange = {onCantidadChange(it)},
        placeholder = { Text("Cantidad")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ComensalesTextField(
    numeroComensales:String,
    onNumeroComensalesChange: (String) -> Unit
){
    OutlinedTextField(
        value = numeroComensales,
        onValueChange = {onNumeroComensalesChange(it)},
        placeholder = { Text("Comensales")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun RedondearPropinaSwitch(
    checked: Boolean,
    onPropinaChange : (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = {
            onPropinaChange(it)
        }
    )
}


@Composable
fun SliderPropina(
    sliderPosition: Int,
    onSliderChange: (Int) -> Unit,
    enabled: Boolean = true
) {
        Slider(
            value = sliderPosition.toFloat(),
            onValueChange = { onSliderChange(it.toInt())},
            valueRange = 0f..5f,
            steps = 4,
            enabled = enabled
        )
        Text(text = sliderPosition.toString())
}


@Composable
fun Calcular(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Calcular")
    }
}

fun pagarTotal(cantidad: String, comensales: String, propina: Int): Pair<Float, Float>{
    val resultado = cantidad.toFloat() / comensales.toInt();
    var totalCadaUno = 0f
    var cantidadConPropina = 0f
    if(propina>=0){
        totalCadaUno = resultado + resultado*((propina*5)/100f)
        cantidadConPropina = cantidad.toFloat() + cantidad.toFloat() * ((propina*5)/100f)
    }else{
        totalCadaUno
        cantidadConPropina = cantidad.toFloat()
    }
    return Pair(cantidadConPropina,totalCadaUno)
}

@Composable
fun Resultado(){
    var cantidad by remember { mutableStateOf("") }
    var comensales by remember {mutableStateOf("")}
    var propinaVerificado by remember { mutableStateOf(false) }
    var propinaSlider by remember {mutableIntStateOf(0)}

    CantidadTextField(
        cantidad = cantidad,
        onCantidadChange = {nuevaCantidad -> cantidad = nuevaCantidad}
    )

    ComensalesTextField(
        numeroComensales = comensales,
        onNumeroComensalesChange =  {nuevoComensales -> comensales = nuevoComensales}
    )

    RedondearPropinaSwitch(
        checked = propinaVerificado,
        onPropinaChange = {nuevoEstado -> propinaVerificado = nuevoEstado}
    )

    SliderPropina(
        sliderPosition = propinaSlider,
        onSliderChange = {nuevaPropina -> propinaSlider = nuevaPropina}
    )

    pagarTotal(cantidad,comensales,propinaSlider)
}