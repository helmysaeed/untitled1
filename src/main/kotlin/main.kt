import androidx.compose.desktop.Window
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mongodb.client.MongoClient

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }
    var expanded by remember { mutableStateOf(false) }
  //  col.insertOne(Users("Luke Skywalker33", 19))


  //   val ob = dbsx()
    MaterialTheme {
        Surface (
            Modifier.fillMaxWidth().padding(1.dp).fillMaxHeight(),elevation = 1.dp,shape = MaterialTheme.shapes.small,color = Color.LightGray

        )
        {

            Row () {
                Row(modifier = Modifier.fillMaxHeight().weight(1f).background(Color.White   )    )
                 {



                }


                Row(modifier = Modifier.clickable {


                    dbex()


                }.fillMaxHeight().weight(4f).background(Color.Cyan)) {

                    Login()

                    UsersPage()


                }

                Row(modifier = Modifier.fillMaxHeight().weight(1f).background(Color.White   )   )
                {

                  Column {

                      Box(Modifier.fillMaxWidth()){
                          Text("title 1")

                      }

                      Card(Modifier.fillMaxWidth().background(Color.Black), MaterialTheme.shapes.small){
                          Text("title 2")

                      }

                      Card(Modifier.fillMaxWidth()){
                          Text("title 3")

                      }
                  }

                }


            }

        }

    }
}