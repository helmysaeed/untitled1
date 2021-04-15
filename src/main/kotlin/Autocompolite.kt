import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp





@Composable
fun autocompolit()
{



Column( Modifier.fillMaxWidth().wrapContentSize().border(BorderStroke(3.dp, Color.Blue)), Arrangement.Center, Alignment.CenterHorizontally) {
    val itemName = remember { mutableStateOf(TextFieldValue("")) }
    val items = remember { mutableStateOf(mutableListOf(
        "Paulo Pereiraddddddddddddddddddddddddddddddddddddddd",
        "Daenerys Targaryen",
        "Jon Snow",
        "Sansa Stark",
    )) }
    val items2 = remember { mutableStateOf(mutableListOf(""))}

    OutlinedTextField(
        value = itemName.value,
        onValueChange = { itemName.value = it
          items2.value.addAll(items.value)

        },
        leadingIcon = { },
        trailingIcon = {

            Icon(imageVector = Icons.Outlined.AddCircle, Modifier.clickable {
                //  colItem.insertOne(Item(itemName.value.text))
                //  itemtList.value.add(0,Item(itemName.value.text))
                // itemUnitList.value=colItemUnit.find().into(mutableListOf())
                itemName.value = TextFieldValue("")

            }.wrapContentWidth().padding(4.dp))

        },
        modifier = Modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "item name") },
        placeholder = { Text(text = "choes item name") },

        )
    LazyColumnForIndexed( items2.value)
    {
        index, item ->
           Box()
           {
               Text(item.toString())
           }


    }



}

}