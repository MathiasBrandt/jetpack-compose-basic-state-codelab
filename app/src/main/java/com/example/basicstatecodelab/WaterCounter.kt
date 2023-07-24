package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
    count: Int,
    addCount: () -> Unit,
) {

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "You've had ${count} glasses."
            )
        }

        Button(
            onClick = addCount,
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}