package com.dhruv.stateincomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhruv.stateincomposable.ui.theme.StateInComposableTheme

class WaterCount : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateInComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WaterCount(Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun WaterCount(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    Column {
        if(count>0){
            var showTask by rememberSaveable { mutableStateOf(true) }
            if(showTask){
                WellnessTaskItem(taskName = "Have you walked today ?",
                    onClose = { showTask=false })
            }
            Text(
                text = "you had a $count glasses",
                modifier = modifier.padding(16.dp)
            )
        }

        Row (modifier = modifier.padding(top=8.dp)){
            Button(
                onClick = { count++ },modifier=modifier.padding(8.dp) , enabled = count<10
            ) {
                Text(text = "Add one")
            }

            Button(onClick = { count=0},modifier=modifier.padding(start=8.dp)) {
             Text(text = "Clear Water count")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun WaterCountPreview() {
    StateInComposableTheme {
WaterCount(Modifier.padding(8.dp))
    }
}