package neiz.fz.storeapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import neiz.fz.storeapp.presentation.ui.theme.Green700

@Composable
fun TextFieldComponent(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    iconDescription: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    imeAction: ImeAction = ImeAction.Next,
    hideText: Boolean = false
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { text->
            onValueChange(text)
        },
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            capitalization = capitalization,
            imeAction = imeAction,
        ),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription,
                tint = Green700
            )
        },
        textStyle = TextStyle(
            color = Color.Black
        ),
        singleLine = true,
        visualTransformation = if(hideText) PasswordVisualTransformation() else VisualTransformation.None
    )

}