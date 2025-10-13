package com.example.rickandmortyapp.data.room

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.rickandmortyapp.data.Character
import com.example.rickandmortyapp.data.services.CharacterService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.SQLException

object CharacterRepository {

    // AppDatabase
    // RickAndMortyDatabase
    private lateinit var _rickandmortydatabase : RickAndMortyDatabase
    private val _characterDao by lazy { _rickandmortydatabase.characterDao() }

    // 1. ferdigstille konfigurering av database
    fun initializeDatabase(context: Context){
        _rickandmortydatabase = Room.databaseBuilder(
            context = context,
            klass = RickAndMortyDatabase::class.java,
            name = "rickandmorty-database"
        ).build()
        Log.d("Databasen initialiseres her", context.toString())
    }

    // 2. Repository-metoder
    suspend fun getCharacters() : List<Character>{
        try {
            return _characterDao.getCharacters()
        } catch (e: SQLException){
            Log.d("Databasefeil", e.toString())
            return emptyList()
        } catch (e: Exception){
            Log.d("Annen feil", e.toString())
            return emptyList()
        }
    }

    suspend fun insertCharacter( character: Character) : Long {
        try {
            return _characterDao.insertCharacter(character)
        } catch (e: SQLException){
            Log.e("Databasefeil", e.toString())
            return -1L
        }
    }

    suspend fun deleteCharacter(character: Character) : Int {
        try {
            return _characterDao.deleteCharacter(character)
        } catch(e: SQLException){
            Log.e("Databasefeil", e.toString())
            return 0
        } catch (e: Exception){
            Log.e("Kritisk feil", e.toString())
            return 0
        }
    }
}