package com.example.rickandmortyapp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapp.data.Character

@Dao
interface CharacterDao {

    // Leser
    @Query("SELECT * FROM Character")
    suspend fun getCharacters(): List<Character>

    // Legger til
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: Character): Long

    // Sletter fra databasen/room
    @Delete()
    suspend fun deleteCharacter(character: Character): Int

}