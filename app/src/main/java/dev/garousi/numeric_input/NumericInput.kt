package dev.garousi.numeric_input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.garousi.numeric_input.NumericInputTestTagConstants.MINUS_BUTTON
import dev.garousi.numeric_input.NumericInputTestTagConstants.OUTLINE_TEXT_FIELD
import dev.garousi.numeric_input.NumericInputTestTagConstants.PLUS_BUTTON
import dev.garousi.numeric_input.ui.theme.NumericInputTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumericInput(

) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(OUTLINE_TEXT_FIELD),
        value = "0",
        onValueChange = {},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color(0xFF222222),
            textColor = Color(0XFFFFFFFF)
        ),
        textStyle = MaterialTheme.typography.bodySmall
            .copy(
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            ),
        trailingIcon = {
            FilledIconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFF333333),
                    contentColor = Color(0XFFFFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.testTag(PLUS_BUTTON)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }
        },
        leadingIcon = {
            FilledIconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFF333333),
                    contentColor = Color(0XFFFFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.testTag(MINUS_BUTTON)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Remove,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    )
}


@Preview
@Composable
private fun NumericInputPreview() {
    NumericInputTheme {
        NumericInput()
    }
}