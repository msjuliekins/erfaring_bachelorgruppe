package com.example.rickandmortyapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//https://www.baeldung.com/kotlin/data-class-optional-fields

@Entity
data class Character (
    @PrimaryKey(autoGenerate = true)
    // Kun navn og id er obligatorisk informasjon
    val id: Int = 0,
    val name: String,
    val image: String? = null,
    val species: String? = null,
    val gender: String? = null,
    val status: String? = null
)