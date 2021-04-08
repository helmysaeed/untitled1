import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import org.litote.kmongo.text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun inventoryForm()
{
    val itemName  = remember { mutableStateOf(TextFieldValue("")) }


    Column(Modifier.wrapContentWidth(align = Alignment.CenterHorizontally).padding(4.dp)) {
        TextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },


            label = { Text("itemName") },
            placeholder = { Text("enter name") }
        )

           Spacer(Modifier.padding(4.dp))
        Button(onClick = {
            colItem.insertOne(Item(itemName.value.text))
            itemName.value= TextFieldValue("")

        })
        {
            Text("save")
        }
        
    }

}












