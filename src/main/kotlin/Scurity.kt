import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mongodb.client.model.Filters.eq
import androidx.compose.runtime.*
import com.itextpdf.kernel.pdf.PdfName.Print
import com.mongodb.client.model.Filters
import com.sun.tools.javac.Main
import kotlinx.coroutines.flow.MutableStateFlow
import javax.print.attribute.standard.PrinterInfo
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoCursor
import org.bson.Document
import org.litote.kmongo.*
import java.util.ArrayList
import javax.swing.text.NavigationFilter


val useslist =      col.find().iterator()


@Composable
fun RootPage(visablex: Boolean=false ){

    var  visable = remember { mutableStateOf(visablex) }


    if (visable.value==true) {

        NavigatioPage(true)

    }
    else if (visable.value==false) {
        LoginForm(false)
    }

}





@Composable
fun LoginForm(visablex: Boolean)
{

    val userName = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val visable = remember { mutableStateOf(visablex) }

    val count = remember { mutableStateOf(0) }

    val exist = remember { mutableStateOf(false) }



    if (visable.value==false) {
        Card(Modifier.padding(4.dp).background(color = Color.Black).fillMaxWidth(), elevation = 2.dp) {

            Column(Modifier.padding(16.dp)) {

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


                Box(Modifier.background(Color.Blue).align(Alignment.CenterHorizontally) )
                {
                    Button(onClick = {

                        //  var controll = Controll()
                        //   val andQuery = BasicDBObject()

                        var fil = and(
                            eq("name", userName.value.text),
                            eq("passWord", password.value.text)
                        )

                        // var fil= eq("passWord", password.value.text)


                        //  controll.userNameExist= remember { mutableStateOf(col.find (eq("name", userName.value.text)).count())}

                        //   andQuery.put("${MongoOperator.and}",obj)


                        count.value = col.find(fil).count()
                        print("count${count.value}")

                        if (count.value == 0) {
                            col.insertOne(Users(userName.value.text.toString(), password.value.text))

                        } else {

                            visable.value=true

                        }

                        userName.value = TextFieldValue("")
                        password.value = TextFieldValue("")


                        //val background = Color(0xffff0000)

                    }) {
                        Text("save")
                    }

                }




            }

        }

    }

    if (visable.value==true) {
          println("Hello yes login!")

          RootPage(true)
       //  NavigatioPage(true)


    } else {
      //  Text("user is create")
    }


}
@Composable
fun NavigatioPage(visablex: Boolean)
{
    var text by remember { mutableStateOf("Hello, World!") }
    var expanded by remember { mutableStateOf(false) }

    var page by remember { mutableStateOf(0.0) }
    val visable = remember { mutableStateOf(visablex) }
    if (visable.value==true)
        Row() {
            Row(modifier = Modifier.fillMaxHeight().weight(4f))
            {


                Card(
                    Modifier.padding(4.dp).fillMaxHeight().fillMaxWidth(),

                    elevation = 2.dp, shape = MaterialTheme.shapes.medium

                ) {


                }
            }


            Row() {
                Card(
                    Modifier.padding(4.dp).fillMaxHeight().wrapContentWidth(),
                    shape = MaterialTheme.shapes.medium,
                    elevation = 2.dp
                ) {


                    if (page > 0.0) {
                        menuChild(page)

                    } else {

                    }//
                }
            }

            Row()
            {

                Card(modifier = Modifier.fillMaxHeight().wrapContentWidth().padding(4.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = 2.dp
                    )
                {

                    Column {

                        IconButton(onClick = { page = 1.0 }, Modifier)

                        {
                            Text("1")

                        }

                        IconButton(onClick = { page = 2.0 }, Modifier)

                        {
                            Text("2")


                        }
                    }
                }
            }

        }
        }




@Composable
fun menuChild( page :Double)
{

    Card() {

        Text(
            "Hello, World!$page",
            Modifier.padding(16.dp) .wrapContentWidth().wrapContentHeight()// Outer padding; outside background
                .background(color = Color.Green) // Solid element background color
                .padding(1.dp) // Inner padding; inside background, around text
        )
    }


}