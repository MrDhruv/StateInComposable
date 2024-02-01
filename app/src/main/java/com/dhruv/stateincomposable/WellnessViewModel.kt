package com.dhruv.stateincomposable

import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

private val _tasks=getWellnessTask().toMutableList()
    val tasks:List<WellnessTask> get() = _tasks

    fun remove(item:WellnessTask){
        _tasks.remove(item)
    }
    fun changeTaskChecked(item: WellnessTask,checked:Boolean){
        _tasks.find { it.Id==item.Id }?.let {
            task ->task.checked = checked
        }
    }
    fun getWellnessTask()=List(30){i->WellnessTask(i,"Task $i")}
}