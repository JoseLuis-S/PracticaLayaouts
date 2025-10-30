package com.alberti.practicaestados

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.alberti.practicaestados.ui.theme.PracticaEstadosTheme

@Composable
fun ProductCard(title: String, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val (image, titleRef, priceRef, buttonRef) = createRefs()

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Gray)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.constrainAs(titleRef) {
                start.linkTo(image.end, margin = 16.dp)
                top.linkTo(parent.top)
                end.linkTo(buttonRef.start, margin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "99.99 €",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.constrainAs(priceRef) {
                start.linkTo(titleRef.start)
                top.linkTo(titleRef.bottom, margin = 4.dp)
            }
        )

        val endBarrier = createEndBarrier(titleRef, priceRef)

        Button(
            onClick = {  },
            modifier = Modifier.constrainAs(buttonRef) {
                start.linkTo(endBarrier, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        ) {
            Text("Comprar")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun ProductCardPreview() {
    PracticaEstadosTheme {
        Column {
            ProductCard(title = "Bambitas flamas")
            ProductCard(title = "Bambitas toas flamas, flamas, flamas, flamas")
        }
    }
}
