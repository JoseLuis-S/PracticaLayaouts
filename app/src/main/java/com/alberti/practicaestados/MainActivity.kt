package com.alberti.practicaestados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alberti.practicaestados.ui.theme.PracticaEstadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaEstadosTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestinations.PRODUCT_CARD_ROUTE,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Cada composable de destino ahora es una pantalla completa
            composable(AppDestinations.PRODUCT_CARD_ROUTE) {
                ProductCardScreen()
            }
            composable(AppDestinations.EVENT_CARD_ROUTE) {
                EventCardScreen()
            }
            composable(AppDestinations.BARRA_ESTILOS_ROUTE) { BarraEstilos() }
            composable(AppDestinations.PANTALLA_COLORES_ROUTE) { PantallaColores() }
            composable(AppDestinations.PANTALLA_CONTADOR_ROUTE) {
                PantallaContador()
            }
            composable(AppDestinations.PANTALLA_TEXTO_VISIBLE_ROUTE) { PantallaTextoVisible() }
        }
    }
}

@Composable
fun ProductCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pantalla del Producto", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        ProductCard(title = "Bambitas flamas")
    }
}

@Composable
fun EventCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pantalla del Evento", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        EventCard(
            titulo = "Texto",
            subtitulo = "TextoTextoTextoTexto",
            descripcion = "TextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTexto",
            descripcionSecundaria = "TextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTextoTexto",
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(AppDestinations.PRODUCT_CARD_ROUTE to "Producto",
        AppDestinations.EVENT_CARD_ROUTE to "Evento",
        AppDestinations.BARRA_ESTILOS_ROUTE to "Estilos",
        AppDestinations.PANTALLA_COLORES_ROUTE to "Colores",
        AppDestinations.PANTALLA_CONTADOR_ROUTE to "Contador",
        AppDestinations.PANTALLA_TEXTO_VISIBLE_ROUTE to "Visible"
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { (route, label) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = {
                    Text(
                        text = label,
                        fontWeight = if (currentRoute == route) FontWeight.Bold else FontWeight.Normal
                    )
                },
                alwaysShowLabel = true,
                icon = { }
            )
        }
    }
}
