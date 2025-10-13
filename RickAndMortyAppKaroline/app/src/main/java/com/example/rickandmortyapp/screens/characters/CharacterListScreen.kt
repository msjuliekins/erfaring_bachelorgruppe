package com.example.rickandmortyapp.screens.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.components.CharacterItem



@Composable
fun CharacterListScreen(characterListViewModel: CharacterListViewModel) { // Koble opp til viewModel

    // State
    val characters = characterListViewModel.showCharacters.collectAsState()

    // Koden som henter info - asynkront/coroutine
    LaunchedEffect(Unit) {
            characterListViewModel.loadCharacters()
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .background(Color(154,205,50)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rick & Morty Characters",
            fontSize = 30.sp,
            color = Color(12,96,13),
            fontWeight = FontWeight.Bold
        )
            LazyColumn {
                items(characters.value) { character ->
                    CharacterItem(character)
                }
            }
    }
}