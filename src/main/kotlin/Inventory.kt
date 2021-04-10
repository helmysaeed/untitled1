import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import org.litote.kmongo.text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableSharedFlow


@Composable
fun inventoryForm()
{
    val itemName  = remember { mutableStateOf(TextFieldValue("")) }
    val itemType  = remember { mutableStateOf(TextFieldValue("")) }
    val itemUnit  = remember { mutableStateOf(TextFieldValue("")) }


    var item= ItemType("item",1)
    var services= ItemType("services",2)
    val expanded= mutableStateOf(false)
    val expandedItemUnit= mutableStateOf(false)

    val itemTypeList  = remember { mutableListOf<ItemType>(item,services) }

      Card(Modifier.background(color = MaterialTheme.colors.background))
      {


    Column(Modifier.wrapContentWidth(align = Alignment.CenterHorizontally).padding(4.dp)) {
        OutlinedTextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },


            label = { Text("itemName") },
            placeholder = { Text("enter name") }
        )

        Spacer(Modifier.padding(4.dp))


        OutlinedTextField(
            value = itemType.value,
            onValueChange = { itemType.value = it },

            leadingIcon = {  },
            trailingIcon = {
                if (expanded.value.equals(true))
                {
                    Icon(imageVector = Icons.Outlined.KeyboardArrowUp, Modifier.clickable {
                        expanded.value = false
                        // itemName.value = TextFieldValue("" + expanded.value)

                    }.wrapContentWidth())
                }else {
                    Icon(imageVector = Icons.Outlined.ArrowDropDown, Modifier.clickable {
                        expanded.value = true
                        // itemName.value = TextFieldValue("" + expanded.value)

                    })
                }
            },
            modifier = Modifier

                ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "item type") },
            placeholder = { Text(text = "choes item type") },

            )
        Spacer(Modifier.padding(4.dp))
        if (expanded.value==true)
        {

            Card(modifier = Modifier.wrapContentWidth().padding(4.dp).align(Alignment.CenterHorizontally).shadow(4.dp),
                shape = MaterialTheme.shapes.medium,
                elevation = 2.dp
            )
            {
                Box( Modifier.align(Alignment.CenterHorizontally).padding(4.dp))
                {
                    Column {
                        Text(itemTypeList.get(0).name.toString(),Modifier.clickable {
                            itemType.value=TextFieldValue( itemTypeList.get(0).name.toString())
                            expanded.value = false
                        })

                        Divider(Modifier.padding(1.dp).width(300.dp))

                        Text(itemTypeList.get(1).name.toString(),Modifier.clickable {
                            itemType.value=TextFieldValue( itemTypeList.get(1).name.toString())
                            expanded.value = false
                        })
                    }

                }


            }
        }


        OutlinedTextField(
            value = itemUnit.value,
            onValueChange = { itemUnit.value = it },
            leadingIcon = {  },
            trailingIcon = {
                if (expandedItemUnit.value.equals(true))
                {
                    Icon(imageVector = Icons.Outlined.KeyboardArrowUp, Modifier.clickable {
                        expandedItemUnit.value = false
                        // itemName.value = TextFieldValue("" + expanded.value)

                    }.wrapContentWidth())
                }else {
                    Icon(imageVector = Icons.Outlined.ArrowDropDown, Modifier.clickable {
                        expandedItemUnit.value = true
                        // itemName.value = TextFieldValue("" + expanded.value)

                    })
                }
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "item unit") },
            placeholder = { Text(text = "choes item unit") },

            )




        Spacer(Modifier.padding(4.dp))

        if (expandedItemUnit.value==true)
        {

                unitForm()


        }
        Spacer(Modifier.padding(4.dp))

        Button(onClick = {
            colItem.insertOne(Item(itemName.value.text))
            itemName.value = TextFieldValue("")

        },Modifier.align(Alignment.CenterHorizontally))
        {
            Text("save")
        }

    }

      }
}


@Composable
fun unitForm()
{
    Row {

        Box(Modifier.weight(1f))
        {
           unitNameListInput()
        }
        Box(Modifier.weight(1f))
        {
            unitNameGroupInput()

        }

        Box(Modifier.weight(1f))
        {

              unitInput()


        }
    }

}

@Composable
fun unitInput()
{     val itemUnitList  = remember { mutableStateOf(col) }

    Column {
        val itemUnitName  = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = itemUnitName.value,
            onValueChange = { itemUnitName.value = it },
            leadingIcon = {  },
            trailingIcon = {

                Icon(imageVector = Icons.Outlined.AddCircle, Modifier.clickable {
                    itemUnitName.value = TextFieldValue("" )

                }.wrapContentWidth())

            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "item unit") },
            placeholder = { Text(text = "choes item unit") },

            )


        LazyRowFor()
        {
            Text("f")
        }


    }


}

@Composable
fun unitNameGroupInput()
{
    val itemUnitName  = remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = itemUnitName.value,
        onValueChange = { itemUnitName.value = it },
        leadingIcon = {  },
        trailingIcon = {

            Icon(imageVector = Icons.Outlined.AddCircle, Modifier.clickable {
                itemUnitName.value = TextFieldValue("" )

            }.wrapContentWidth())

        },
        modifier = Modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "item unit") },
        placeholder = { Text(text = "choes item unit") },

        )

}

@Composable
fun unitNameListInput()
{
    val itemUnitName  = remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = itemUnitName.value,
        onValueChange = { itemUnitName.value = it },
        leadingIcon = {  },
        trailingIcon = {

            Icon(imageVector = Icons.Outlined.AddCircle, Modifier.clickable {
                itemUnitName.value = TextFieldValue("" )

            }.wrapContentWidth())

        },
        modifier = Modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "item unit") },
        placeholder = { Text(text = "choes item unit") },

        )

}










