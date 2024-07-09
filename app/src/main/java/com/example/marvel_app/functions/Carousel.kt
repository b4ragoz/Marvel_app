@file:OptIn(ExperimentalFoundationApi::class)

package com.example.marvel_app.functions

import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import coil.compose.rememberAsyncImagePainter
import com.example.marvel_app.data.HeroCard

import com.example.marvel_app.ui.theme.Typography

@Composable
fun Carousel(heroCard: List<HeroCard>, navController: NavController, initialItemIndex: Int){

    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = initialItemIndex)
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(horizontal = 32.dp),
        state = lazyListState,
        flingBehavior = snapBehavior
    ) {
        items(heroCard){
                heroCard -> Box(
            modifier = Modifier
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable { navController.navigate(heroCard.name) }
        ) {
            Image(
                painter = rememberAsyncImagePainter(heroCard.url),
                contentDescription = heroCard.name,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(300.dp)
                    .background(color = Color.hsv(0F, 0F,0.05F))
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                Brush.verticalGradient(
                                    0.25f to Color.Black.copy(alpha=0F),
                                    1F to Color.Black.copy(alpha=0.8f)
                                ))
                        }
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = heroCard.name,
                style = Typography.titleLarge,
                lineHeight = 28.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(32.dp)
            )
        }
        }
    }
}