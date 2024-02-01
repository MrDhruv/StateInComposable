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

class StatefulAndStateless : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateInComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //WaterCount1(Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun StatelessCounter(count:Int,onIncrement:()->Unit,modifier: Modifier = Modifier) {
    Column {
        if(count>0){
            Text(
                text = "you had a $count glasses",
                modifier = modifier.padding(16.dp)
            )
        }

        Row (modifier = modifier.padding(top=8.dp)){
            Button(
                onClick = { onIncrement },modifier=modifier.padding(8.dp) , enabled = count<10
            ) {
                Text(text = "Add one")
            }

           /* Button(onClick = { onIncrement},modifier=modifier.padding(start=8.dp)) {
             Text(text = "Clear Water count")
            }*/
        }

    }

}

@Composable
fun StaetefulCounter(modifier: Modifier=Modifier){
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(count =count , onIncrement = {count++ },modifier)

}

// You hoisted count from StatelessCounter to StatefulCounter.

@Preview(showBackground = true)
@Composable
fun StatefulAndStatelessPreview() {
    StateInComposableTheme {
WaterCount(Modifier.padding(8.dp))
    }
}