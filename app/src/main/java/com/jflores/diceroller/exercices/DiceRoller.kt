package com.jflores.diceroller.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jflores.diceroller.R


@Composable
fun MyHoistingDiceRoller() {

    var result by remember {
        mutableStateOf(1)
    }

    DiceRoller(
        result = result,
        onResult = {
        result = (1..6).random()
    }
        )


}

@Composable
fun DiceRoller(
    result: Int,
    onResult: () -> Unit
) {

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6

    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
            )
            Button(
                onClick = { onResult() }
            ) {
                Text(text = "Roll")
            }

        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun DiceRollerPreview() {
    MyHoistingDiceRoller()
}