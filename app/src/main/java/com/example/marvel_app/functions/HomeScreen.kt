package com.example.marvel_app.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marvel_app.R
import com.example.marvel_app.data.HeroCard
import com.example.marvel_app.ui.theme.Typography

@Composable
fun HomeScreen(heroList: List<HeroCard>, navController: NavController, initialItemIndex: Int) {
    Box(Modifier.background(Color.Black))
    {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 28.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .width(120.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Choose your hero",
                style = Typography.titleLarge
            )
            Spacer(modifier = Modifier.height(64.dp))
            Carousel(heroList, navController, initialItemIndex)
        }
    }
}