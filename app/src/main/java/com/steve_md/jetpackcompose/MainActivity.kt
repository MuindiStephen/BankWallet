package com.steve_md.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import com.steve_md.jetpackcompose.screens.HomeScreen
import com.steve_md.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                val state = rememberScrollState()
                  HomeScreen()
            }
        }
    }
}
