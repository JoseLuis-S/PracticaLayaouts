package com.alberti.practicaestados

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.alberti.practicaestados.ui.theme.PracticaEstadosTheme

@Composable
fun EventCard(
    titulo: String,
    subtitulo: String,
    descripcion: String,
    descripcionSecundaria: String,
    modifier: Modifier = Modifier
) {
    var contador by rememberSaveable { mutableIntStateOf(120) }
    var estaExpandido by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val (
                image, headerTexts, descriptionText,
                actionsRow, footer
            ) = createRefs()

            Box(
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.evento_sevilla),
                    contentDescription = "Imagen del evento",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = titulo,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = subtitulo,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Text(
                text = descripcion,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.constrainAs(descriptionText) {
                    top.linkTo(image.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )

            EventActions(
                modifier = Modifier.constrainAs(actionsRow) {
                    top.linkTo(descriptionText.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )

            EventFooter(
                contador = contador,
                descripcionSecundaria = descripcionSecundaria,
                estaExpandido = estaExpandido,
                expandir = { estaExpandido = !estaExpandido },
                incrementar = { contador++ },
                decrementar = { if (contador > 0) contador-- },
                modifier = Modifier.constrainAs(footer) {
                    top.linkTo(actionsRow.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }
    }
}

@Preview(
    name = "Tarjeta con corto",
    showBackground = true,
    backgroundColor = 0xFFF0F0F0,
    widthDp = 360
)
@Composable
fun EventCardPreview_TextoCorto() {
    PracticaEstadosTheme {
        EventCard(
            titulo = "Texto",
            subtitulo = "Texto Texto",
            descripcion = "Texto Texto Texto Texto Texto Texto Texto Texto",
            descripcionSecundaria = "Texto"
        )
    }
}

@Preview(
    name = "Tarjeta texto largo muy largo super largo mega largo",
    showBackground = true,
    backgroundColor = 0xFFF0F0F0,
    widthDp = 480
)
@Composable
fun EventCardPreview_TextoLargo() {
    PracticaEstadosTheme {
        EventCard(
            titulo = "Texto Texto Texto Texto Texto Texto Texto Texto",
            subtitulo = " Texto Texto Texto Texto Texto Texto Texto",
            descripcion = "Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto" +
                    " Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto " +
                    " Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto",
            descripcionSecundaria = "Texto"
        )
    }
}