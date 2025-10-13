package com.example.rickandmortyapp.data.services


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//filen hvor kallet foregår - gethttp-kall
interface CharacterService {
    @GET("character")
    //asynkront kall
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("character")
    suspend fun getCharacterByName(
        @Query("name") name: String
    ): Response<CharacterList>
}