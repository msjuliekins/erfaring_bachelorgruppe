package com.example.rickandmortyapp.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.Character
import com.example.rickandmortyapp.data.services.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel : ViewModel(){

    private val _characterRepository : CharacterRepository = CharacterRepository

    private val _showCharacters = MutableStateFlow<List<Character>>(emptyList())
    val showCharacters = _showCharacters.asStateFlow()

    fun loadCharacters(){
        //etter endring blir det "emitet" til composable screen
        viewModelScope.launch {
            _showCharacters.value = _characterRepository.getAllCharacters()
    }
  }
}