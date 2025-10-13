package com.example.rickandmortyapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButtonDefaults.iconButtonColors
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Delete
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.Character

@Composable
fun CharacterItem(character: Character, onDelete: (() -> Unit)? = null) {

    Column(modifier = Modifier
        .shadow(
            shape = RoundedCornerShape(12.dp),
            elevation = 20.dp,
            spotColor = Color(40, 131, 62)
        )
        .padding(20.dp)
        .width(260.dp)
        .border(
            BorderStroke(
                2.dp,
                color = Color(46, 137, 53)
            )
        )
        .background(Color(245, 245, 220)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = character.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(40,131,62),
            modifier = Modifier
                .padding(8.dp)
        )

        //Logging
        //https://stackoverflow.com/questions/7959263/android-log-v-log-d-log-i-log-w-log-e-when-to-use-each-one
        Log.d("CharacterItem", "URL: ${character.image}")

        //Error - legge inn et bilde fra drawable i tilfellet bildene ikke lastes
        //https://www.delasign.com/blog/android-studio-jetpack-compose-kotlin-image-from-url/
        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            modifier = Modifier
                .size(200.dp)
                .shadow(shape = RoundedCornerShape(12.dp), elevation = 20.dp),
            placeholder = painterResource(id = R.drawable.loading),
            error = painterResource(id = R.drawable.dancing_rabbit)
        )
        Text(
            text = "Species: ${character.species}",
            fontSize = 20.sp,
            color = Color(40,131,62),
            modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Gender: ${character.gender}",
            fontSize = 20.sp,
            color = Color(40,131,62),
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = "Status: ${character.status}",
            fontSize = 18.sp,
            color = Color(40,131,62),
            modifier = Modifier
                .padding(4.dp)
        )
        if (onDelete != null){ // gjør sånn at kun kortene som har onDelete-funksjonen, altså ShowUsers-filene, får slette-knappen
            IconButton(
                onClick = {
                    onDelete() // bruker funksjonen i screen
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    tint = Color(12,96,13), // https://stackoverflow.com/questions/64424206/how-to-custom-the-color-of-iconbutton
                    contentDescription = null,
                )
            }
        }
    }
}