package dev.garousi.numeric_input

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dev.garousi.numeric_input.NumericInputTestTagConstants.OUTLINE_TEXT_FIELD
import dev.garousi.numeric_input.NumericInputTestTagConstants.PLUS_BUTTON
import dev.garousi.numeric_input.NumericInputTestTagConstants.MINUS_BUTTON
import dev.garousi.numeric_input.ui.theme.NumericInputTheme
import org.junit.Rule
import org.junit.Test


class NumericInputTest {
    @get:Rule
    var composeTesRule = createComposeRule()

    @Test
    fun when_clickOnPlusButton_then_ValueShouldDisplayed() {
        var value = 10
        var priceTick = 100
        with(composeTesRule) {
            setContent {
                NumericInputTheme {
                    NumericInput()
                }
            }
            onNodeWithTag(OUTLINE_TEXT_FIELD).assertIsDisplayed()

            onNodeWithTag(PLUS_BUTTON).assertIsDisplayed()
                .assertHasClickAction()

            onNodeWithTag(PLUS_BUTTON).performClick()

            onNodeWithTag(OUTLINE_TEXT_FIELD)
                .assertTextEquals("110")
        }

        @Test
        fun when_clickOnMinusButton_then_ValueShouldDisplayed() {
            var value = 1000
            var priceTick = 100
            with(composeTesRule) {
                setContent {
                    NumericInputTheme {
                        NumericInput()
                    }
                }
                onNodeWithTag(OUTLINE_TEXT_FIELD).assertIsDisplayed()

                onNodeWithTag(MINUS_BUTTON).assertIsDisplayed()
                    .assertHasClickAction()

                onNodeWithTag(MINUS_BUTTON).performClick()

                onNodeWithTag(OUTLINE_TEXT_FIELD)
                    .assertTextEquals("900")
            }
        }
    }
}