package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmortyapp.data.room.CharacterRepository
import com.example.rickandmortyapp.navigation.AppNavigation
import com.example.rickandmortyapp.screens.characters.CharacterListViewModel
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterViewModel
import com.example.rickandmortyapp.screens.searchcharacter.SearchCharacterViewModel
import com.example.rickandmortyapp.screens.showuserscharacters.ShowUsersCharactersViewModel
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {

    private val _characterListViewModel : CharacterListViewModel by viewModels()
    private val _createCharacterViewModel : CreateCharacterViewModel by viewModels()
    private val _searchCharacterViewModel : SearchCharacterViewModel by viewModels()
    private val _showUsersCharactersViewModel : ShowUsersCharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CharacterRepository.initializeDatabase(applicationContext)
        enableEdgeToEdge()
        setContent {
            RickAndMortyAppTheme {
                        AppNavigation(
                            _characterListViewModel,
                            _createCharacterViewModel,
                            _searchCharacterViewModel,
                            _showUsersCharactersViewModel
                        )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyAppTheme {
        Greeting("Android")
    }
}