package com.example.thmanya.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.thmanya.ui.theme.plexsansArabicBold

/**
 * Created by AsmaaHassan on 22,August,2025
 * Cairo, Egypt.
 */

@Composable
fun sectionView(title:String, content: @Composable () -> Unit){
    Column {
        sectionHeader(title = title, onClick = Unit)
        content()
    }
}

@Composable
fun sectionHeader(title: String, onClick: Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 8.dp, vertical = 12.dp)   ,
        horizontalArrangement = Arrangement.SpaceBetween // Distribute space evenly, placing first and last items at the edges
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            fontFamily = plexsansArabicBold
        )

        Icon(
            painter = painterResource(id = R.drawable.material_ic_keyboard_arrow_right_black_24dp),
            contentDescription = "رجوع",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onClick
                }
        )
    }
}
