package com.example.composeloginscreeninit.screens.register

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
fun RegisterSection(uiColor: Color) {
    Column (verticalArrangement = Arrangement.spacedBy(15.dp)){
        LoginTextField(
            label = stringResource(id = R.string.email) ,
            trailing = " ",
            uiColor = uiColor,
            modifier = Modifier.fillMaxWidth()
        )
        LoginTextField(
            label = stringResource(id = R.string.password) ,
            trailing = " ",
            uiColor = uiColor,
            modifier = Modifier.fillMaxWidth()
        )
        LoginTextField(
            label = stringResource(id = R.string.repeat_password) ,
            trailing = " ",
            uiColor = uiColor,
            modifier = Modifier.fillMaxWidth()
        )
        ActionButton(text = stringResource(id = R.string.register))
    }
}