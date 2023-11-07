package com.example.di_ejerciciocard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.di_ejerciciocard.ui.theme.Di_ejerciciocardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Di_ejerciciocardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EjercicioCard() {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {

        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {


                Box(modifier = Modifier.weight(1f)) {
                    Text(text = "Tarea 1")
                }
                Box(modifier = Modifier.weight(1f)) {
                    var prioridad by rememberSaveable {
                        mutableStateOf("baja")
                    }
                    @OptIn(ExperimentalMaterial3Api::class)
                    BadgedBox(badge = { Badge { Text(prioridad) } }) {
                        Icon(
                            imageVector = Icons.Default.Build, contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "prioridad")
                }
                var expandedEstado by rememberSaveable {
                    mutableStateOf(false)
                }
                val estado = listOf("Completada", "No completada")
                Box(modifier = Modifier.weight(1f)) {
                    DropdownMenu(
                        expanded = expandedEstado, onDismissRequest = { expandedEstado = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                    }
                }

                var expandedPrioridad by rememberSaveable {
                    mutableStateOf(false)
                }
                val prioridad = listOf("Completada", "No completada")
                Box(modifier = Modifier.weight(1f)) {
                    DropdownMenu(
                        expanded = expandedPrioridad,
                        onDismissRequest = { expandedPrioridad = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                    }
                }
            }
        }
    }
}