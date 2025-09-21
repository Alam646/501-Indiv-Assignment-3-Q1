package com.example.indivassignment3q1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.indivassignment3q1.ui.theme.IndivAssignment3Q1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndivAssignment3Q1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndivAssignment3Q1Theme {
        Greeting("Android")
    }
}

@Composable
fun WeightSplitLayout(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
                .background(Color.Red)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "25% Width")
        }
        Box(
            modifier = Modifier
                .weight(0.75f)
                .fillMaxHeight()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .background(Color.Green)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Child 1 (20%)")
                }
                Box(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxWidth()
                        .background(Color.Blue)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Child 2 (30%)", color = Color.White)
                }
                Box(
                    modifier = Modifier
                        .weight(5f)
                        .fillMaxWidth()
                        .background(Color.Yellow)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Child 3 (50%)")
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 300)
@Composable
fun WeightSplitLayoutPreview_Step1() {
    IndivAssignment3Q1Theme {
        WeightSplitLayout()
    }
}
