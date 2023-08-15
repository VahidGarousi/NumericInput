package dev.garousi.numeric_input

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dev.garousi.numeric_input.NumericInputTestTagConstants.MINUS_BUTTON
import dev.garousi.numeric_input.NumericInputTestTagConstants.OUTLINE_TEXT_FIELD
import dev.garousi.numeric_input.NumericInputTestTagConstants.PLUS_BUTTON
import dev.garousi.numeric_input.ui.theme.NumericInputTheme
import java.math.BigDecimal
import org.junit.Rule
import org.junit.Test


class NumericInputTest {
    @get:Rule
    var composeTesRule = createComposeRule()
    private val minMessage = "Minimum is "
    private val maxMessage = "Maximum is "

    private lateinit var numericInputState: NumericInputState

    @Test
    fun when_clickOnPlusButton_then_ValueShouldDisplayed() {
        with(composeTesRule) {
            setContent {
                numericInputState = rememberNumericInputState(
                    defaultValue = BigDecimal(500),
                    defaultTick = BigDecimal(100),
                    min = BigDecimal(50),
                    max = BigDecimal(2000),
                    minMessage = minMessage,
                    maxMessage = maxMessage
                )
                NumericInputTheme {
                    NumericInput(numericInputState)
                }
            }
            onNodeWithTag(OUTLINE_TEXT_FIELD)
                .assertIsDisplayed()
                .assertTextContains(numericInputState.value.toString())

            onNodeWithTag(PLUS_BUTTON).assertIsDisplayed()
                .assertHasClickAction()

            onNodeWithTag(PLUS_BUTTON).performClick()

            onNodeWithTag(OUTLINE_TEXT_FIELD)
                .assertTextEquals(numericInputState.value.toString())
        }
    }

    @Test
    fun when_clickOnMinusButton_then_ValueShouldDisplayed() {
        with(composeTesRule) {
            setContent {
                NumericInputTheme {
                    numericInputState = rememberNumericInputState(
                        defaultValue = BigDecimal(100),
                        defaultTick = BigDecimal(100),
                        min = BigDecimal(500),
                        max = BigDecimal(2000),
                        minMessage = minMessage,
                        maxMessage = maxMessage
                    )
                    NumericInput(numericInputState)
                }
            }
            onNodeWithTag(OUTLINE_TEXT_FIELD)
                .assertIsDisplayed()
                .assertTextContains(numericInputState.value.toString())

            onNodeWithTag(MINUS_BUTTON).assertIsDisplayed()
                .assertHasClickAction()

            onNodeWithTag(MINUS_BUTTON).performClick()

            onNodeWithTag(OUTLINE_TEXT_FIELD)
                .assertTextEquals(numericInputState.value.toString())
        }
    }

}