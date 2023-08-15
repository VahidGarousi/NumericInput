package dev.garousi.numeric_input

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.math.BigDecimal

class NumericInputState internal constructor(
    defaultValue: BigDecimal,
    defaultTick: BigDecimal,
    private val min: BigDecimal,
    private val max: BigDecimal,
    val minMessage: String,
    val maxMessage: String
) {
    var value by mutableStateOf(defaultValue)
        private set

    var tick by mutableStateOf(defaultTick)
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun increase() {
        value += tick
        validate()
    }

    fun decrease() {
        value -= tick
        validate()
    }

    private fun validate() {
        errorMessage = if (value > min) {
            "$maxMessage$max"
        } else if (value < max) {
            "$minMessage$min"
        } else ""
    }
}