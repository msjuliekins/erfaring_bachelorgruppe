package com.example.rickandmortyapp.data.services

import android.util.Log
import com.example.rickandmortyapp.data.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterRepository {

    //Oppkobling til API
    // 1. HTTP-Client

    private val _okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        ).build()

    // 2. Retrofitt- objekt

    private val _retrofit = Retrofit.Builder()
        .client(_okHttpClient)
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    // 3. Service - objekt

        private val _characterService = _retrofit.create(CharacterService::class.java)

    // 4. Funksjon som gjør bruk av service

    suspend fun getAllCharacters() : List<Character> {
        try {

            val response = _characterService.getAllCharacters() //bruker get fra service

            if (response.isSuccessful) {

                //Logging
                //https://stackoverflow.com/questions/7959263/android-log-v-log-d-log-i-log-w-log-e-when-to-use-each-one
                Log.i("CharacterRepository","Oppkoblingen til API´et fungerte")

                return response.body()?.results ?: emptyList()
            } else {
                return emptyList()
            }

        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun getCharacterByName(name: String) : Character? {
        return try {
            //henter alle karakterer først
            val response = _characterService.getAllCharacters()
            //sjekker om vi fikk alle karakterene og hvis ja:
            if (response.isSuccessful) {
                //henter hele "kroppen" til responsen og sjekker om det er null, hvis results er null returneres tom liste
                //https://stackoverflow.com/questions/65612861/how-can-i-get-data-from-response-body
                val allCharacters = response.body()?.results ?: emptyList()
                // det brukeren søker etter med en slags toLowerCase() og det første treffet/elementet i arrayet
                // https://kotlinandroid.org/kotlin/kotlin-check-if-strings-are-equal-ignoring-case/
                allCharacters.first { it.name.contains(name, ignoreCase = true) }
            } else {
                null
            }
        } catch (e: Exception) {
            null //gjelder "?" i (name : String) : Character?
        }
    }
}