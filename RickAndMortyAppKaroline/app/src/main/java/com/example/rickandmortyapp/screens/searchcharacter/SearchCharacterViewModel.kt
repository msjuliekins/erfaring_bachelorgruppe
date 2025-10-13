package com.example.rickandmortyapp.screens.searchcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.Character
import com.example.rickandmortyapp.data.services.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchCharacterViewModel : ViewModel() {
    private val _searchedCharacters = MutableStateFlow<Character?>(null)
    val searchedCharacters = _searchedCharacters.asStateFlow()

    //endre state
    fun setSearchedCharacter(name : String){
        viewModelScope.launch {
            val foundCharacter = CharacterRepository.getCharacterByName(name)
            _searchedCharacters.value = foundCharacter
        }
    }
}

