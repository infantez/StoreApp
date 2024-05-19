package neiz.fz.storeapp.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import neiz.fz.storeapp.presentation.ui.theme.Green400

@Composable
fun ButtonComponent(
    modifier: Modifier,
    text: String,
    onClick:() -> Unit,
    color: Color = Green400,
    icon: ImageVector = Icons.Default.ArrowForward,
    iconDescription: String,
    style: TextStyle
) {
    Button(
        modifier = modifier,
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(
           10.dp
        ),
    ) {

        Text(
            text = text,
            style = style
        )

        Spacer(modifier = Modifier.padding(horizontal = 5.dp))

        Icon(
            imageVector = icon,
            contentDescription = iconDescription
        )
    }
}