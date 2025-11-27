package com.example.realtimetitle

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.sp
import com.example.realtimetitle.ui.theme.RealTimeTitleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealTimeTitleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (modifier = Modifier.padding(innerPadding))
                    {
                        ManyText()
                    }
                }
            }
        }
    }
}


@Composable
fun ManyText() {
    var text: String by remember { mutableStateOf("") }
    TextField(
        text,
        onValueChange = {text = it},
        Modifier.fillMaxWidth(),
        label = {Text("Enter text here")}
    )
    val result = text.split(" ").joinToString(" ") { word ->
        if (word.isNotEmpty()) {
            word.lowercase().replaceFirstChar { c ->
                if (c.isLetter()) c.uppercaseChar() else c
            }
        } else {
            word
        }
    }

    Text(text = result, fontSize = 30.sp, color = Color.Blue)
}


