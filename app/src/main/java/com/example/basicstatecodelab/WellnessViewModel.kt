package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val mutableTasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = mutableTasks

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

    fun removeTask(task: WellnessTask) {
        mutableTasks.remove(task)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        mutableTasks.find { it.id == item.id }?.let { task -> task.checked = checked }
    }
}