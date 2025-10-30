package com.alberti.practicaestados

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun BarraSinEstilos(chainStyle: ChainStyle, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val (exploreRef, favoritesRef, profileRef) = createRefs()

        createHorizontalChain(
            exploreRef,
            favoritesRef,
            profileRef,
            chainStyle = chainStyle
        )

        Text(
            text = "Explorar",
            modifier = Modifier.constrainAs(exploreRef) {}
        )
        Text(
            text = "Favoritos",
            modifier = Modifier.constrainAs(favoritesRef) {}
        )
        Text(
            text = "Perfil",
            modifier = Modifier.constrainAs(profileRef) {}
        )
    }
}

@Composable
fun BarraEstilos() {
    Column {
        Text("Spread", modifier = Modifier.padding(8.dp))
        BarraSinEstilos(chainStyle = ChainStyle.Spread)

        Text("SpreadInside", modifier = Modifier.padding(8.dp))
        BarraSinEstilos(chainStyle = ChainStyle.SpreadInside)

        Text("Packed", modifier = Modifier.padding(8.dp))
        BarraSinEstilos(chainStyle = ChainStyle.Packed)
    }
}

@Preview(showBackground = true)
@Composable
fun BarraEstilosPreview() {
    BarraEstilos()
}