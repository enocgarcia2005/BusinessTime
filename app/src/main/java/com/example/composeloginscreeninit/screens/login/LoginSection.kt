package com.example.composeloginscreeninit.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composeloginscreeninit.R
import com.example.composeloginscreeninit.components.ActionButton
import com.example.composeloginscreeninit.components.LoginTextField
@Composable
internal fun LoginSection(uiColor: Color){
    Column (verticalArrangement = Arrangement.spacedBy(15.dp)){
        LoginTextField(
            label = "Correo",
            trailing = "",
            uiColor = uiColor,
            modifier = Modifier.fillMaxWidth()
        )
        LoginTextField(
            label = "Contraseña",
            trailing = "Forgot?",
            uiColor = uiColor,
            modifier = Modifier.fillMaxWidth()
        )
       ActionButton(text = stringResource(id = R.string.login))
    }
}
