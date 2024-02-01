package com.dhruv.stateincomposable

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhruv.stateincomposable.ui.theme.StateInComposableTheme

class WellnessTaskItem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateInComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun WellnessTaskItem(taskName:String,onClose: ()->Unit,modifier: Modifier = Modifier) {
    Row(modifier=modifier, verticalAlignment = Alignment.CenterVertically) {
       Text(modifier= modifier
           .weight(1f)
           .padding(start = 16.dp), text = taskName)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close,contentDescription = "Close")
            
        }
    }

}

@Composable
fun WellnessTaskItemStateFull(taskName:String,onClose:()->Unit,modifier: Modifier=Modifier){
    var checkedState by rememberSaveable {
        mutableStateOf(false)
    }
   // WellnessTaskItemD(taskName = taskName, checked = checkedState, onCheckedChange = {newValue->checkedState=newValue}, onClose = {onClose },modifier)
}
@Composable
fun WellnessTaskItemD(taskName:String,
                      checked:Boolean,
                      onCheckedChanged:(Boolean)->Unit,
                      onClose:()->Unit,
                      modifier: Modifier = Modifier) {
    Row(modifier=modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(modifier= modifier
            .weight(1f)
            .padding(start = 16.dp), text = taskName)
        Checkbox(checked=checked,onCheckedChange=onCheckedChanged)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close,contentDescription = "Close")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    StateInComposableTheme {
       WellnessTaskItem(taskName = "This is Task", onClose = { /*TODO*/ })
    }
}