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
                // Scaffold provides a basic structure for the screen,
                // and innerPadding ensures content isn't obscured by system bars.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // WeightSplitLayout is the main content of our screen.
                    WeightSplitLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Composable
fun WeightSplitLayout(modifier: Modifier = Modifier) {
    // Row is used to arrange children horizontally.
    // fillMaxSize ensures the Row takes up all available screen space provided by its parent.
    Row(modifier = modifier.fillMaxSize()) {
        // This Box represents the first section, taking 25% of the available width.
        // The weight modifier distributes space proportionally among siblings.
        Box(
            modifier = Modifier
                .weight(0.25f) // Allocates 25% of the Row's width to this Box
                .fillMaxHeight()
                .background(Color.Red)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "25% Width")
        }

        // second section, taking the remaining 75% of the width.
        Box(
            modifier = Modifier
                .weight(0.75f) // Allocates 75% of the Row's width.
                .fillMaxHeight()

        ) {
            // Column is used to arrange children vertically within the 75% section.
            // fillMaxSize ensures the Column uses all space within its parent Box.
            Column(modifier = Modifier.fillMaxSize()) {
                // This Box is the first child of the Column.
                // It's given a weight of 2f, meaning it will take 2 parts of the total (2+3+5=10) vertical space.
                Box(
                    modifier = Modifier
                        .weight(2f) // Takes 20% of the Column's height.
                        .fillMaxWidth()
                        .background(Color.Green)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Child 1 (20%)")
                }
                // Second child of the Column, weighted to be proportionally larger than the first.
                Box(
                    modifier = Modifier
                        .weight(3f) // Takes 3/10 30% of the Column's height.
                        .fillMaxWidth()
                        .background(Color.Blue)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Child 2 (30%)", color = Color.White)
                }
                // Third child of the Column, weighted to be the largest.
                Box(
                    modifier = Modifier
                        .weight(5f) // Takes 50% of the Column's height.
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
fun WeightSplitLayoutPreview() { // Renamed from WeightSplitLayoutPreview_Step1
    IndivAssignment3Q1Theme {
        WeightSplitLayout()
    }
}
