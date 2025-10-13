package com.example.rickandmortyapp.screens.createcharacter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults.ContainerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.Character

@Composable
fun CreateCharacterScreen(createCharacterViewModel: CreateCharacterViewModel) {

    // State
    val characters = createCharacterViewModel.characters.collectAsState()

    var name by remember {
        mutableStateOf("")
    }
    var species by remember {
        mutableStateOf("")
    }
    var gender by remember {
        mutableStateOf("")
    }

    var status by remember {
        mutableStateOf("")
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .background(Color(154, 205, 50)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Opprett egen karakter!",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(12,96,13),
                    modifier = Modifier.padding(20.dp)
                )

                TextField(
                    value = name,
                    onValueChange = {name = it},
                    label = { Text(text = "Navn på karakter")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(245,245,220),
                        unfocusedContainerColor = Color(250,255,255)
                    ),
                    modifier = Modifier
                        .padding(12.dp)
                        .border(
                            BorderStroke(
                                2.dp,
                                color = Color(46, 137, 53)
                            )
                        )
                )
                TextField(
                    value = species,
                    onValueChange = {species = it},
                    label = { Text(text = "Art")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(245,245,220),
                        unfocusedContainerColor = Color(250,255,255)
                    ),
                    modifier = Modifier
                        .padding(20.dp)
                        .border(
                            BorderStroke(
                                2.dp,
                                color = Color(46, 137, 53)
                            )
                        )
                )
                TextField(
                    value = gender,
                    onValueChange = {gender = it},
                    label = { Text(text = "Kjønn")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(245,245,220),
                        unfocusedContainerColor = Color(250,255,255)
                    ),
                    modifier = Modifier
                        .padding(20.dp)
                        .border(
                            BorderStroke(
                                2.dp,
                                color = Color(46, 137, 53)
                            )
                        )
                )
                TextField(
                    value = status,
                    onValueChange = {status = it},
                    label = { Text(text = "Død eller i live?")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(245,245,220),
                        unfocusedContainerColor = Color(250,255,255)
                    ),
                    modifier = Modifier
                        .padding(20.dp)
                        .border(
                            BorderStroke(
                                2.dp,
                                color = Color(46, 137, 53)
                            )
                        )
                )
                Button(
                    onClick = {
                        val newCharacter = Character(
                            name = name,
                            image = R.drawable.dancing_rabbit.toString(),
                            species = species,
                            gender = gender,
                            status = status
                        )
                        createCharacterViewModel.insertCharacter(newCharacter)
                        name = ""
                        species = ""
                        gender = ""
                        status = ""
                    },
                    modifier = Modifier.padding(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(12,96,13))
                ) {
                    Text(text = "Legg til")
                }
                Box(
                    modifier = Modifier.padding(40.dp)
                ) {
                    LazyColumn {
                        items(characters.value){ character ->
                            Text(
                                text = "${character.name} ble lagt til!",
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .border(
                                        BorderStroke(
                                            2.dp,
                                            color = Color(46, 137, 53)
                                        )
                                    )
                                    .padding(2.dp)
                                    .background(
                                        Color(
                                            245, 245, 220
                                        ),
                                        RoundedCornerShape(4.dp)
                                    )
                                    .fillMaxWidth()
                            )
                        }
                    }
            }
        }
    }
}