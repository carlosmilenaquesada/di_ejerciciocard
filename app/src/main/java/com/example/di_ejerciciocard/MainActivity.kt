package com.example.di_ejerciciocard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    EjercicioCard()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
            var prioridadBadge by rememberSaveable {
                mutableStateOf("baja")
            }
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text(
                            text = "Tarea 1",
                            modifier =
                            Modifier
                                .padding(15.dp)
                                .weight(3f),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier =
                            Modifier
                                .padding(15.dp)
                                .weight(1f)
                        ) {
                            @OptIn(ExperimentalMaterial3Api::class)
                            BadgedBox(badge = { Badge { Text(prioridadBadge) } }) {
                                Icon(
                                    imageVector = Icons.Default.Build, contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }

                    Text(
                        text = "Realizar pruebas", modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Justify
                    )
                }


                Box(modifier = Modifier.weight(1f)) {
                    var selectedText by rememberSaveable {
                        mutableStateOf("..")
                    }
                    var expanded by rememberSaveable {
                        mutableStateOf(false)
                    }

                    val prioridades = listOf("Alta", "Media", "Baja")
                    Column(modifier = Modifier.padding(20.dp)) {
                        OutlinedTextField(
                            value = selectedText,
                            onValueChange = { selectedText = it },
                            enabled = false,
                            readOnly = true,
                            modifier = Modifier
                                .clickable { expanded = true }
                                .fillMaxWidth()
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            prioridades.forEach { prioridad ->
                                DropdownMenuItem(
                                    text = { Text(text = prioridad) },
                                    onClick = {
                                        expanded = false
                                        selectedText = prioridad
                                    }
                                )
                            }
                            prioridadBadge = selectedText
                        }
                    }
                }
                Box(modifier = Modifier.weight(1f)) {
                    var selectedText by rememberSaveable {
                        mutableStateOf("..")
                    }
                    var expanded by rememberSaveable {
                        mutableStateOf(false)
                    }

                    val estados = listOf("Completada", "No completada")
                    Column(modifier = Modifier.padding(20.dp)) {
                        OutlinedTextField(
                            value = selectedText,
                            onValueChange = { selectedText = it },
                            enabled = false,
                            readOnly = true,
                            modifier = Modifier
                                .clickable { expanded = true }
                                .fillMaxWidth()
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            estados.forEach { estado ->
                                DropdownMenuItem(
                                    text = { Text(text = estado) },
                                    onClick = {
                                        expanded = false
                                        selectedText = estado
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}