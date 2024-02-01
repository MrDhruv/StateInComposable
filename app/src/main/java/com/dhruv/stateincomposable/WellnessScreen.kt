package com.dhruv.stateincomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhruv.stateincomposable.ui.theme.StateInComposableTheme

class WellnessScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateInComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen(Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun WellnessScreen(modifier: Modifier=Modifier,wellnessViewModel: WellnessViewModel = viewModel()){
    Column(modifier=modifier) {
        WellnessScreenStatefull()
      //  val list=remember{ getWellnessTask().toMutableList() }
        WellnessTaskList(list=wellnessViewModel.tasks,
            onCheckedTask={task, checked -> wellnessViewModel.changeTaskChecked(task,checked)},
            onCloseTask= { task -> wellnessViewModel.remove(task) } )
    }
    //WaterCount(modifier)
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    StateInComposableTheme {
      WellnessScreen(Modifier.padding(8.dp))
    }
}