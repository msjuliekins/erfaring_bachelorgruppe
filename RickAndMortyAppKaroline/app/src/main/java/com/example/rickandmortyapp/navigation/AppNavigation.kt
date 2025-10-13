package com.example.rickandmortyapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.screens.characters.CharacterListScreen
import com.example.rickandmortyapp.screens.characters.CharacterListViewModel
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterScreen
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterViewModel
import com.example.rickandmortyapp.screens.searchcharacter.SearchCharacterScreen
import com.example.rickandmortyapp.screens.searchcharacter.SearchCharacterViewModel
import com.example.rickandmortyapp.screens.showuserscharacters.ShowUsersCharactersScreen
import com.example.rickandmortyapp.screens.showuserscharacters.ShowUsersCharactersViewModel
import kotlinx.serialization.Serializable

//Fire skjermer
@Serializable
object Home

@Serializable
object UsersCharacters

@Serializable
object CreateCharacter

@Serializable
object SearchCharacter

@Composable
fun AppNavigation(
    // Henter inn viewModel-instansene som parametere
    characterListViewModel: CharacterListViewModel,
    createCharacterViewModel: CreateCharacterViewModel,
    searchCharacterViewModel: SearchCharacterViewModel,
    showUsersCharactersViewModel: ShowUsersCharactersViewModel
) {

    val navController = rememberNavController()

    var currentScreen by remember {
        mutableStateOf(0)
    }

    // Variabel for fargene på valgt og uvalgt knapp https://developer.android.com/reference/kotlin/androidx/compose/material3/NavigationBarItemDefaults
    val colorScheme = NavigationBarItemDefaults.colors(
        indicatorColor = Color.Transparent,
        selectedIconColor = Color(0,100,0),
        selectedTextColor = Color(0,100,0),
        unselectedIconColor = Color(0,128,0),
        unselectedTextColor = Color(0,128,0)
    )

    //Navigasjonsbar
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color(255,255,255)
            ) {
                // 1. knapp - Hjem
                NavigationBarItem(
                    selected = currentScreen == 0, // == sammenligner
                    onClick = {
                        currentScreen = 0 // = er lik
                        navController.navigate(Home)
                    },
                    icon = {
                        if (currentScreen == 0) {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Home,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Hjem")
                    },
                    colors = colorScheme
                )
                // 2. knapp - Dine karakterer
                NavigationBarItem(
                    selected = currentScreen == 1, // == sammenligner
                    onClick = {
                        currentScreen = 1 // = er lik
                        navController.navigate(UsersCharacters)
                    },
                    icon = {
                        if (currentScreen == 1) {
                            Icon(
                                painterResource(id = R.drawable.baseline_groups_2_24),
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                painterResource(id = R.drawable.outline_groups_2_24),
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Dine karakterer")
                    },
                    colors = colorScheme
                )
                // 3. knapp - lag karakterer
                NavigationBarItem(
                    selected = currentScreen == 2, // == sammenligner
                    onClick = {
                        currentScreen = 2 // = er lik
                        navController.navigate(CreateCharacter)
                    },
                    icon = {
                        if (currentScreen == 2) {
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Create,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Lag karakter")
                    },
                    colors = colorScheme
                )
                // 4. knapp - Søk i karakterer
                NavigationBarItem(
                    selected = currentScreen == 3, // == sammenligner
                    onClick = {
                        currentScreen = 3 // = er lik
                        navController.navigate(SearchCharacter)
                    },
                    icon = {
                        if (currentScreen == 3) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Søk")
                    },
                    colors = colorScheme
                )
            }
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier.padding(innerpadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Home
            ) {
                composable<Home> {
                    CharacterListScreen(characterListViewModel)
                }
                composable<UsersCharacters> {
                    ShowUsersCharactersScreen(showUsersCharactersViewModel)
                }
                composable<CreateCharacter> {
                    CreateCharacterScreen(createCharacterViewModel)
                }
                composable<SearchCharacter> {
                    SearchCharacterScreen(searchCharacterViewModel)
                }
            }
        }
    }
}
