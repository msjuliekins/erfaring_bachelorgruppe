package com.example.rickandmortyapp.screens.showuserscharacters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun ShowUsersCharactersScreen(showUsersCharactersViewModel: ShowUsersCharactersViewModel){

    // State
    var characters = showUsersCharactersViewModel.characters.collectAsState()

    // Asynkront/coroutine - for å hente karkaterene fra databasen kun en gang
    // https://medium.com/@robindamisi/understanding-launched-effect-in-android-kotlin-jetpack-compose-94a8bf396a75
    LaunchedEffect(Unit) {
        showUsersCharactersViewModel.setCharacters()
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .background(Color(154,205,50)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dine karakterer",
            fontSize = 30.sp,
            color = Color(12,96,13),
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp)
                .weight(1f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Henter inn fra CharacterItem - basert på Character data class
                items(characters.value) { character ->
                    CharacterItem(
                        character,
                        onDelete = {showUsersCharactersViewModel.deleteCharacters(character)} // det samme kortet som blir sendt inn for å vise, blir også sendt inn som forslag til sletting
                    )
                }
            }

    }
}
