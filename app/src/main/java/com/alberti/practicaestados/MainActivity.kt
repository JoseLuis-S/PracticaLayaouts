package com.alberti.practicaestados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.alberti.practicaestados.ui.theme.PracticaEstadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaEstadosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        EventCard(
                            titulo = "Texto",
                            subtitulo = "TextoTextoTextoTexto",
                            descripcion = "TextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTexto",
                            descripcionSecundaria = "TextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTexto",
                        )
                    }
                }
            }
        }
    }
}
