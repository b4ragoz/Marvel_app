package com.example.marvel_app.functions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import coil.compose.rememberAsyncImagePainter
import com.example.marvel_app.data.HeroCard
import com.example.marvel_app.ui.theme.Typography

@Composable
fun HeroScreen(heroCard: HeroCard, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = rememberAsyncImagePainter(heroCard.url),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                0f to Color.Black.copy(alpha=0.8f),
                                0.25f to Color.Black.copy(alpha=0F),
                                1F to Color.Black.copy(alpha=0.8f)
                            ))
                    }
                },
            contentScale = ContentScale.Crop
        )

        IconButton(
            onClick = { navController.navigate("Home screen") },
            modifier = Modifier
                .padding(32.dp)
                .size(32.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription ="Back",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxSize()
            )
        }

        Column (
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = heroCard.name,
                style = Typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = heroCard.info,
                style = Typography.bodyMedium
            )
        }
    }
}