package com.example.rickandmortyapp.screens.createcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.room.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.rickandmortyapp.data.Character

class CreateCharacterViewModel : ViewModel(){
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters = _characters.asStateFlow()

    // Sende den nye karakteren til databasen for lagring

    fun insertCharacter(character: Character){
        viewModelScope.launch(Dispatchers.IO) {
            val newCharacterId = CharacterRepository.insertCharacter(character)

            if (newCharacterId != -1L){
                val newCharacter = character.copy(id = newCharacterId.toInt())
                _characters.value += newCharacter
            }
        }
    }
}
