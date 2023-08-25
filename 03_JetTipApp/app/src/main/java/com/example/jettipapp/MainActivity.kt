package com.example.jettipapp

import android.health.connect.datatypes.units.Percentage
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableDoubleState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettipapp.components.InputField
import com.example.jettipapp.ui.theme.JetTipAppTheme
import com.example.jettipapp.util.calculateTotalPerPerson
import com.example.jettipapp.util.calculateTotalTip
import com.example.jettipapp.widgets.RoundIconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTipAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                content()
            }
        }
    }
}

@Composable
fun TopHeader(totalPerPerson: Double = 123.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(150.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color = Color(0xFFE9D7F7)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total Per Person",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "$$total",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainContent() {
    val splitByState = remember {
        mutableIntStateOf(1)
    }
    val range = IntRange(start = 1, endInclusive = 10)

    val tipAmountState = remember {
        mutableDoubleStateOf(0.0)
    }
    val totalPerPersonState = remember {
        mutableDoubleStateOf(0.0)
    }


    BillForm(
        modifier = Modifier,
        range,
        splitByState,
        tipAmountState,
        totalPerPersonState,
    ) { billAmt ->
        Log.d("AMT", "MainContent: $billAmt")
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    range: IntRange = 1..100,
    splitByState: MutableIntState,
    tipAmountState: MutableDoubleState,
    totalPerPersonState: MutableDoubleState,
    onValueChange: (String) -> Unit = {},
) {
    val totalBillState = remember {
        mutableStateOf("0")
    }
    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val sliderPositionState = remember {
        mutableFloatStateOf(0f)
    }
    val tipPercentage = remember {
        derivedStateOf { (sliderPositionState.floatValue * 100).toInt() }
    }


    TopHeader(totalPerPerson = totalPerPersonState.doubleValue)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(color = Color.LightGray, width = 1.dp)
    ) {
        Column(
            modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
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
                    totalPerPersonState.doubleValue = calculateTotalPerPerson(
                        totalBill = totalBillState.value.toDouble(),
                        splitBy = splitByState.intValue,
                        tipPercentage = tipPercentage.value
                    )
                }
            )

            if (validState) {
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
                        modifier = Modifier
                            .padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundIconButton(
                            imageVector = Icons.Rounded.Remove,
                            onClick = {
                                if (splitByState.intValue <= 1) return@RoundIconButton
                                splitByState.intValue--
                                totalPerPersonState.doubleValue = calculateTotalPerPerson(
                                    totalBill = totalBillState.value.toDouble(),
                                    splitBy = splitByState.intValue,
                                    tipPercentage = tipPercentage.value
                                )
                            }
                        )
                        Text(
                            text = splitByState.intValue.toString(),
                            modifier = Modifier
                                .padding(start = 9.dp, end = 9.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        RoundIconButton(
                            imageVector = Icons.Rounded.Add,
                            onClick = {
                                if (splitByState.intValue >= range.last) return@RoundIconButton
                                splitByState.intValue++
                                totalPerPersonState.doubleValue = calculateTotalPerPerson(
                                    totalBill = totalBillState.value.toDouble(),
                                    splitBy = splitByState.intValue,
                                    tipPercentage = tipPercentage.value
                                )
                            }
                        )
                    }
                }

                Row(
                    modifier = Modifier.padding(
                        horizontal = 3.dp,
                        vertical = 12.dp
                    )
                ) {
                    Text(
                        text = "Tip",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(
                        text = "$ ${tipAmountState.doubleValue}",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "${tipPercentage.value} %")
                    Spacer(modifier = Modifier.height(14.dp))
                    Slider(
                        value = sliderPositionState.floatValue,
                        onValueChange = { newVal ->
                            sliderPositionState.floatValue = newVal
                            tipAmountState.doubleValue =
                                calculateTotalTip(
                                    totalBill = totalBillState.value.toDouble(),
                                    tipPercentage = tipPercentage.value
                                )
                            totalPerPersonState.doubleValue = calculateTotalPerPerson(
                                totalBill = totalBillState.value.toDouble(),
                                splitBy = splitByState.intValue,
                                tipPercentage = tipPercentage.value
                            )
                            Log.d("3333", "BillForm: ${tipPercentage.value}")
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        steps = 5,
                        onValueChangeFinished = {
                            Log.d("3333", "BillForm: finished")
                        }

                    )
                }
            } else {
                Box {}
            }
        }
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
    JetTipAppTheme {
        Greeting("Android")
    }
}