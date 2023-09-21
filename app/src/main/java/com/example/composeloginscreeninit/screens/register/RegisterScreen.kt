package com.example.composeloginscreeninit.screens.register

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeloginscreeninit.R
import com.example.composeloginscreeninit.components.SocialMediaSection
import com.example.composeloginscreeninit.ui.theme.Black

@Composable
fun RegisterScreen(navController: NavController) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    var isRegisterVisible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = isRegisterVisible,
        enter = slideInHorizontally(),
        exit = slideOutHorizontally()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSectionRegister(
                uiColor = uiColor,
                navController = navController,
                isRegisterVisible = isRegisterVisible
                ){isRegisterVisible = it}
            Spacer(modifier = Modifier.height(36.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                RegisterSection(uiColor = uiColor)
                Spacer(modifier = Modifier.height(20.dp))
                SocialMediaSection(text = stringResource(id = R.string.or_continue_register))
            }
        }
    }
}