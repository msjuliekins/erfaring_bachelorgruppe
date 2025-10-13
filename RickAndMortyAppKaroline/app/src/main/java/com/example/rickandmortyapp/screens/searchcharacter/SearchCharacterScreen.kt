package com.example.rickandmortyapp.screens.searchcharacter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.components.CharacterItem
import com.example.rickandmortyapp.navigation.SearchCharacter

@Composable
fun SearchCharacterScreen(searchCharacterViewModel: SearchCharacterViewModel){
    val searchedCharacter = searchCharacterViewModel.searchedCharacters.collectAsState()
    
    var name by remember {
        mutableStateOf<String>("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .background(Color(154, 205, 50)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Søk etter karakter",
            fontSize = 30.sp,
            color = Color(12,96,13),
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = name,
            onValueChange = {name = it},
            label = {
                Text(text = "Skriv inn navn")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done, // done-knappen på tastaturet fungerer som søk-knapp
                keyboardType = KeyboardType.Text
            ),

            // Aktiverer done-knappen på tastaturet
            //https://stackoverflow.com/questions/67432822/jetpack-compose-execute-keyboardaction

            keyboardActions = KeyboardActions(
                onDone = { searchCharacterViewModel.setSearchedCharacter(name) }
            ),
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

        Button(
            onClick = { 
                searchCharacterViewModel.setSearchedCharacter(name)
            },
            modifier = Modifier.padding(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(12,96,13)),
        ) {
            Text(text = "Søk")
        }


        // Finner karakteren
        //https://medium.com/@husayn.fakher/exploring-the-use-of-the-let-keyword-in-kotlin-10-questions-answered-efa2d6613252
        searchedCharacter.value?.let { character ->
            CharacterItem(character = character)
        }
    }
}