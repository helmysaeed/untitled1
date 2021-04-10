import androidx.compose.desktop.Window
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import org.litote.kmongo.rename
import javax.swing.Scrollable

fun main() = Window {


    //  col.insertOne(Users("Luke Skywalker33", 19))

    val state = rememberScrollState(0f)

  //   val ob = dbsx()
    MaterialTheme {
        Surface (
            Modifier.fillMaxWidth().padding(1.dp).fillMaxHeight(),elevation = 1.dp,shape = MaterialTheme.shapes.large

        )
        {


                RootPage(true)

            }



          //  name()

        }

    }






@Composable
fun name(){
    Column(Modifier.wrapContentWidth().fillMaxHeight().background(Color.White).padding(0.dp,10.dp,0.dp,0.dp))
    {

        TextField(TextFieldValue(""),onValueChange = {})
        OutlinedTextField(TextFieldValue(),onValueChange = {})
        Text("reham")
        Text("20")
        Button(onClick = {}){
            Text("save")

        }


    }


}