package com.example.tutorial1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Preview( showBackground = true)
@Composable
fun DiceRollerPage() {
    Page {
        DiceRoller()
    }
}

@Composable
fun Page(content: @Composable () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = 10.dp),
        content = content
    )
}

@Composable
fun DiceRoller(luckyNumber: Int = 4) {
    var rollValue by remember { mutableStateOf(1) }
    val handleRollClick = { rollValue = rollDice(sides = 6) }

    Column(
        modifier = Modifier.padding(all = 4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.roll_page_title),
            fontSize = MaterialTheme.typography.h3.fontSize
        )
        DiceImage(rollValue = rollValue)
        RollButton(clickHandler = handleRollClick)
        RollOutput(rollValue = rollValue, luckyNumber = luckyNumber)
    }
}

@Composable
fun RollButton(clickHandler: () -> Unit) {
    Button(
        onClick = clickHandler,
        modifier = Modifier.padding(2.dp)
    ) {
        Text(
            text = stringResource(R.string.roll_button_text),
            fontSize = MaterialTheme.typography.button.fontSize
        )
    }
}

@Composable
fun RollOutput(rollValue: Int, luckyNumber: Int) {
    if(rollValue == luckyNumber) {
        Text(
            text = "Lucky number 4!",
            fontSize = MaterialTheme.typography.h3.fontSize
        )
    } else {
        Text(
            text = "You rolled a $rollValue",
            fontSize = MaterialTheme.typography.h3.fontSize
        )
    }
}

fun rollDice(sides: Int): Int = Random.nextInt(1, sides + 1)

@Composable
fun DiceImage(rollValue: Int) {
    val image = painterResource(id = diceImageId(rollValue))
    MediumImage(image = image)
}

fun diceImageId(rollValue: Int): Int {
    return when(rollValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

@Composable
fun MediumImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = "Dice roll",
        modifier = Modifier.size(80.dp)
    )
}

@Composable
fun CreateCircle() {
    Card(modifier = Modifier
        .padding(3.dp)
        .size(10.dp),
        shape = CircleShape
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)
        }
    }
}