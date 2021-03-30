import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.find
import org.litote.kmongo.findOne
import org.litote.kmongo.index


@Composable
fun Login(){
    Card(Modifier.padding(4.dp),shape = MaterialTheme.shapes.medium,elevation = 2.dp) {

    Column(Modifier.padding(16.dp)) {
        val userName = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = userName.value,
            onValueChange = { userName.value = it },


            label = { Text("name") },
            placeholder = { Text("enter name") }
        )
        Spacer(Modifier.padding(4.dp))
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("password") },
            placeholder = { Text("password enter") }
        )
        Spacer(Modifier.padding(4.dp))

        Box(Modifier.align(alignment = Alignment.CenterHorizontally))
        {
            Button(onClick = {
                col.insertOne(Users(userName.value.text.toString(), password.value.text))

                userName.value = TextFieldValue("")
                password.value = TextFieldValue("")


            }) {
                Text("save")
            }

        }

    }

    }

}

@Composable
fun UsersPage()
{
    val useslist = remember { mutableListOf(col.find().toList())}


    LazyColumn() {
        itemsIndexed(useslist) { index, item ->
            Text("Item at ${useslist.size}  is ${item.get(index).name} " )
        }


    }

}