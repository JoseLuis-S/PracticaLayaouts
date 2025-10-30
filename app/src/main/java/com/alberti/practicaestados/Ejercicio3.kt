package com.alberti.practicaestados

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun PantallaColores() {
    val listaColor = listOf(
        ColoresNombrados("Rojo", Color.Red),
        ColoresNombrados("Verde", Color.Green),
        ColoresNombrados("Azul", Color.Blue),
        ColoresNombrados("Amarillo", Color.Yellow),
        ColoresNombrados("Cian", Color.Cyan),
        ColoresNombrados("Magenta", Color.Magenta)
    )

    var color by remember { mutableStateOf(listaColor.first()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(color.color)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Color actual: ${color.nombre}")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            color = listaColor[Random.nextInt(listaColor.size)]
        }) {
            Text("Cambiar Color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaColoresPreview() {
    PantallaColores()
}
