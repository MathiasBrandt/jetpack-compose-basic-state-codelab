package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var count by rememberSaveable { mutableStateOf(0) }

    Column {
        WaterCounter(
            modifier,
            count
        ) {
            count++
        }

        WellnessTasksList(
            tasks = wellnessViewModel.tasks,
            onCheckedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) },
            onCloseTask = { task -> wellnessViewModel.removeTask(task) }
        )
    }
}