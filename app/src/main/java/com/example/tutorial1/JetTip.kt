package com.example.tutorial1

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial1.components.InputField
import com.example.tutorial1.ui.theme.Tutorial1Theme
import com.example.tutorial1.widgets.RoundIconButton

@Preview( showBackground = true)
@Composable
fun JetTipPage() {
    JetTipTemplate(
        header = { TopHeader() },
        body = { MainContent() }
    )
}

@Composable
fun JetTipTemplate(
    header: @Composable () -> Unit,
    body: @Composable () -> Unit,
) {
    Tutorial1Theme {
        Surface(color = MaterialTheme.colors.background) {
            CenteredColumn {
                header()
                Spacer(modifier = Modifier.height(4.dp))
                body()
            }
        }
    }
}

@Composable
fun TopHeader(totalPerPerson: Double = 134.0) {
    val total = "%.2f".format(totalPerPerson)
    RoundedCenteredCard(color = 0xFFE9D7F7) {
       Text("Total Per Person", style = MaterialTheme.typography.h4)
       Text("$$total",
           style = MaterialTheme.typography.h3,
           fontWeight = FontWeight.ExtraBold
       )
    }
}

@Composable
fun RoundedCenteredCard(color: Long, content: @Composable () -> Unit) {
    RoundedCard(color) {
        CenteredColumn {
            content()
        }
    }
}

@Composable
fun CenteredColumn(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}

@Composable
fun RoundedCard(color: Long, content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        color = Color(color)
    ) {
        content()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun MainContent() {
    BillForm() { billAmt ->
        Log.d("AMT", "MainContent: $billAmt")
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    val totalBillState = remember { mutableStateOf("") }
    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    var numOfPersons by remember { mutableStateOf(1) }
    var tipPercentage by remember { mutableStateOf(0.20f) }
    val handleTipSliderChange = { newValue: Float -> tipPercentage = newValue }

    Surface(
        modifier = modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            InputField(
                valueState = totalBillState,
                labelId = "Enter Bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    onValueChange(totalBillState.value.trim())
                    keyboardController?.hide()
                }
            )
            SplitRow(
                numOfPersons = numOfPersons,
                onIncrement = { numOfPersons ++ },
                onDecrement = { numOfPersons -- }
            )
            TipRow()
            TipPercentageRow(
                tipPercentage = tipPercentage,
                onValueChange = handleTipSliderChange
            )
        }
    }
}

@Composable
fun TipPercentageRow(tipPercentage: Float, onValueChange: (Float) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val tipPercent = "%.0f".format(tipPercentage * 100)

        Text(
            text = "${tipPercent}%"
        )
        Spacer(modifier = Modifier.height(14.dp))
        Slider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            value = tipPercentage,
            onValueChange = onValueChange,
            steps = 5
        )
    }
}

@Composable
fun TipRow(totalTip: Double = 33.00) {
    Row(
        modifier = Modifier.padding(horizontal = 3.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Tip",
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(200.dp))
        Text(
            text = "$$totalTip",
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun SplitRow(numOfPersons: Int, onDecrement: () -> Unit, onIncrement: () -> Unit) {
    Row(
        modifier = Modifier.padding(3.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Split",
            modifier = Modifier.align(
                alignment = Alignment.CenterVertically
            )
        )
        Spacer(modifier = Modifier.width(120.dp))
        Row(
            modifier = Modifier.padding(horizontal = 3.dp),
            horizontalArrangement = Arrangement.End
        ) {
            RoundIconButton(
                imageVector = Icons.Default.Remove,
                onClick = { onDecrement() }
            )
            Text(
                text = "$numOfPersons",
                modifier = Modifier
                    .padding(start = 9.dp, end = 9.dp)
                    .align(Alignment.CenterVertically)
            )
            RoundIconButton(
                imageVector = Icons.Default.Add,
                onClick = { onIncrement() }
            )
        }
    }
}