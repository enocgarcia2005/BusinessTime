package com.example.composeloginscreeninit.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeloginscreeninit.R
import com.example.composeloginscreeninit.navigation.AppScreens
import com.example.composeloginscreeninit.ui.theme.Roboto

@Composable
internal fun BottomSection(uiColor: Color,navController:NavController) {

    Box(
        modifier = Modifier
            .fillMaxHeight(0.8F)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF94A3B8),
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append(stringResource(id = R.string.dont_have))
                }
                withStyle(
                    style = SpanStyle(
                        color = uiColor,
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append(" ")
                    append(stringResource(id = R.string.register))
                }

            },
            modifier = Modifier.clickable {
                navController.navigate(AppScreens.RegisterScreen.route)
            }
        )
    }
}