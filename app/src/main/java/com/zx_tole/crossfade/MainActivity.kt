package com.zx_tole.crossfade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zx_tole.crossfade.ui.theme.CrossfadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrossfadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CrossfadeDemo()
                }
            }
        }
    }
}

@Composable
fun CrossfadeDemo() {
    var currentColor by remember { mutableStateOf(Colors.Red) }
    Column {
        Row {
            Colors.values().forEach { myColors ->
                Button(
                    onClick = { currentColor = myColors },
                    Modifier
                        .weight(1f, true)
                        .height(48.dp)
                        .background(myColors.color),
                    colors = ButtonDefaults.buttonColors(backgroundColor = myColors.color)
                ) {
                    Text(myColors.name)
                }
            }
        }
        Crossfade(
            targetState = currentColor,
            animationSpec = tween(3000)
        ) { selectedColor ->
            Box(modifier = Modifier
                .fillMaxSize()
                .background(selectedColor.color))
        }
    }
}
