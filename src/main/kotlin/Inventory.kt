import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import org.litote.kmongo.text


@Composable
fun inventoryForm()
{
    val itemName  = remember { mutableStateOf(TextFieldValue("")) }


    Column {
        TextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },


            label = { Text("itemName") },
            placeholder = { Text("enter name") }
        )

        
    }

}












