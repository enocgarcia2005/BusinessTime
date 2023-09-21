package com.example.composeloginscreeninit.screens.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeloginscreeninit.R
import com.example.composeloginscreeninit.components.SocialMediaSection
import com.example.composeloginscreeninit.ui.theme.Black

@Composable
fun LoginScreen(navController: NavController) {
    Surface {
        val uiColor = if (isSystemInDarkTheme()) Color.White else Black

            Column(modifier = Modifier.fillMaxSize()) {
                TopSection(uiColor)
                Spacer(modifier = Modifier.height(36.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    LoginSection(uiColor)
                    Spacer(modifier = Modifier.height(30.dp))
                    SocialMediaSection(stringResource(id = R.string.or_continue))
                    BottomSection(
                        uiColor = uiColor,
                        navController = navController,
                    )

            }
        }
    }
}