package com.alberti.practicaestados

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun EventActions(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (interestAction, shareAction, saveAction) = createRefs()

        createHorizontalChain(
            interestAction, shareAction, saveAction,
            chainStyle = ChainStyle.Spread)

        Text(
            text = "Interesa",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(interestAction) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .clickable {  }
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Compartir",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(shareAction) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    horizontalBias = 0.45f
                }
                .clickable {  }
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Guardar",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(saveAction) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .clickable {  }
                .padding(8.dp)
        )
    }
}
