package com.sample.jetpackcompose.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.jetpackcompose.R

@Composable
fun PasswordField (){
    var password by rememberSaveable{mutableStateOf("")}
    var passwordVisibility by rememberSaveable{mutableStateOf(false)}

    var icon = if(passwordVisibility){
        painterResource(id = R.drawable.visibility)
    }else{
        painterResource(id = R.drawable.visible)
    }
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Enter your Password here ...") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }){
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon",
                    modifier = Modifier.width(30.dp)
                )
            }

        },
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }
    )
}

@Preview
@Composable
fun PasswordFieldPreview(){
    PasswordField()
}