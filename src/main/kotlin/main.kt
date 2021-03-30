import androidx.compose.desktop.Window
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
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

fun main() = Window {


    //  col.insertOne(Users("Luke Skywalker33", 19))


  //   val ob = dbsx()
    MaterialTheme {
        Surface (
            Modifier.fillMaxWidth().padding(1.dp).fillMaxHeight(),elevation = 1.dp,shape = MaterialTheme.shapes.large

        )
        {

           RootPage(false)

        }

    }



}