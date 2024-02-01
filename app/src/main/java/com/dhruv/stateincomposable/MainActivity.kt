package com.dhruv.stateincomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dhruv.stateincomposable.ui.theme.StateInComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateInComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}
fun getWellnessTask()=List(30){i->WellnessTask(i,"Task $i")}
@Composable
fun WellnessTaskListDetails(modifier: Modifier=Modifier,list: List<WellnessTask> = remember { getWellnessTask()}){
   LazyColumn(modifier = modifier){
       //items(list){task-> WellnessTaskItemStateFull(taskName = task.label)}
   }
}

@Composable
fun WellnessTaskList(modifier: Modifier=Modifier,
                     list: List<WellnessTask>,
                     onCheckedTask:(WellnessTask,Boolean)->Unit,
                     onCloseTask : (WellnessTask)->Unit){
    LazyColumn(modifier = modifier){
        items(
            items=list,
            key = { task-> task.Id}
        )
        {task->
            WellnessTaskItemD(taskName = task.label,
                checked = task.checked,
                onCheckedChanged={ checked-> onCheckedTask(task,checked)},
                onClose={onCloseTask(task)})}
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
    StateInComposableTheme {
        Greeting("Android")
    }
}