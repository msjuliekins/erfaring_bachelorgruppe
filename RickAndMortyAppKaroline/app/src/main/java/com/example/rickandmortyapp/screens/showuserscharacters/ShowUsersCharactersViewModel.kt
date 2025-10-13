package com.example.rickandmortyapp.screens.showuserscharacters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.Character
import com.example.rickandmortyapp.data.room.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShowUsersCharactersViewModel : ViewModel() {

    // Fylle databasen med karakterer som brukeren legger inn

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters = _characters.asStateFlow()

    fun setCharacters(){
        viewModelScope.launch(Dispatchers.IO) {
            _characters.value = CharacterRepository.getCharacters()
        }
    }
    fun deleteCharacters(character: Character){
        viewModelScope.launch(Dispatchers.IO) {
            val deletedCharacter = CharacterRepository.deleteCharacter(character)
            if (deletedCharacter == 1){
                val currentList = characters.value // Her er karakteren slettet fra databasen, men vises fortsatt i grensesnittet
                val updatedCharacterList = currentList.filter { it != character } // it er alle kortene uten det kortet som brukeren har bedt om å slette
                _characters.value = updatedCharacterList // Oppdaterer grensesnittet
            }
        }
    }
}
