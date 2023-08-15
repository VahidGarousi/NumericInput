package dev.garousi.numeric_input

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import java.math.BigDecimal
import org.junit.Test


class NumericInputStateTest {
    private lateinit var sut: NumericInputState
    private val value: BigDecimal = mockk() // dummy
    private val minMessage = "Minimum is "
    private val maxMessage = "Maximum is "

    @Test
    fun increase_should_appendTickToCurrentValue() {
        // Arrange
        sut = NumericInputState(
            defaultValue = BigDecimal(500),
            defaultTick = BigDecimal(100),
            min = BigDecimal(50),
            max = BigDecimal(2000),
            minMessage = minMessage,
            maxMessage = maxMessage
        )
        // Act
        sut.increase()
        // Assert
        assertThat(sut.value).isEqualTo(BigDecimal.valueOf(600))
    }

    @Test
    fun decrease_should_reduceTickToCurrentValue() {
        // Arrange
        sut = NumericInputState(
            defaultValue = BigDecimal(500),
            defaultTick = BigDecimal(100),
            min = BigDecimal(50),
            max = BigDecimal(2000),
            minMessage = minMessage,
            maxMessage = maxMessage
        )
        // Act
        sut.decrease()

        // Assert
        assertThat(sut.value).isEqualTo(BigDecimal.valueOf(400))
    }

    @Test
    fun when_increaseCalledAndItIsBiggerThanMaximumValue_then_errorMessageShouldNotBeEmpty() {
        // Arrange
        sut = NumericInputState(
            defaultValue = BigDecimal(2001),
            defaultTick = BigDecimal(100),
            min = BigDecimal(50),
            max = BigDecimal(2000),
            minMessage = minMessage,
            maxMessage = maxMessage
        )
        // Act
        sut.increase()

        // Assert
        assertThat(sut.errorMessage).isNotEmpty()
    }

    @Test
    fun when_decreaseCalledAndItIsLowerThanMinimumValue_then_errorMessageShouldNotBeEmpty() {
        // Arrange
        sut = NumericInputState(
            defaultValue = BigDecimal(2001),
            defaultTick = BigDecimal(100),
            min = BigDecimal(50),
            max = BigDecimal(2000),
            minMessage = minMessage,
            maxMessage = maxMessage
        )
        // Act
        sut.decrease()

        // Assert
        assertThat(sut.errorMessage).isNotEmpty()
    }

    @Test
    fun when_decreaseCalledButValueIsBiggerThanMaximumValue_then_errorMessageShouldNotBeEmpty() {
        val max = BigDecimal(300)
        // Arrange
        sut = NumericInputState(
            defaultValue = BigDecimal(0),
            defaultTick = BigDecimal(100),
            min = BigDecimal(0),
            max = max,
            minMessage = minMessage,
            maxMessage = maxMessage
        )
        // Act
        sut.increase() // 100
        sut.increase() // 200
        sut.increase() // 300
        sut.increase() // 400
        sut.increase() // 500
        sut.increase() // 600
        sut.decrease() // 500
        // Assert
        assertThat(sut.errorMessage).isNotEmpty()
        assertThat(sut.errorMessage).isEqualTo(maxMessage + max)
    }
}