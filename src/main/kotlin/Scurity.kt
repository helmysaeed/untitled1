import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mongodb.client.model.Filters.eq
import androidx.compose.runtime.*
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.input.mouse.MouseScrollUnit
import androidx.compose.ui.text.InternalTextApi
import org.litote.kmongo.*


val useslist =      col.find().iterator()


@ExperimentalLayout
@ExperimentalFocus
@InternalTextApi
@ExperimentalFoundationApi
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





@ExperimentalLayout
@ExperimentalFocus
@InternalTextApi
@ExperimentalFoundationApi
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
@ExperimentalLayout
@ExperimentalFocus
@InternalTextApi
@ExperimentalFoundationApi
@Composable
fun NavigatioPage(visablex: Boolean)
{
          val pageRoot= remember { mutableStateOf(0.0) }
    val pageChild = remember { mutableStateOf(0.0) }

    val visable = remember { mutableStateOf(visablex) }
    if (visable.value==true)
        Row() {
            Row(modifier = Modifier.fillMaxHeight().weight(4f))
            {


                Card(
                    Modifier.padding(4.dp).fillMaxHeight().fillMaxWidth(),

                    elevation = 2.dp, shape = MaterialTheme.shapes.medium

                ) {

                   if (pageChild.value.equals(Pages.ItemName.pagevalu))
                   {               autocompolit(null)
                            // itemInput()
                   }else if (pageChild.value.equals(Pages.UnitName.pagevalu))
                   {
                       unitInput()
                   }
                    if (pageChild.value.equals(Pages.UnitGroupPage.pagevalu))
                    {
                        unitNameGroupInput()
                    }
                    if (pageChild.value.equals(Pages.Sales.pagevalu))
                    {
                        sales()
                    }

                }
            }


            Row() {
                Card(
                    Modifier.padding(4.dp).fillMaxHeight().wrapContentWidth(),
                    shape = MaterialTheme.shapes.medium,
                    elevation = 2.dp
                ) {


                    if (pageRoot.value.equals(Pages.InventoryPage.pagevalu)) {
                      //  inventoryMenu(page.value)

                        Column {

                            Button( onClick = {
                                pageChild.value=Pages.ItemName.pagevalu
                                //   print(""+page.value+" iii "+Pages.UnitName.pagevalu.toDouble())
                            }){

                                Text("item name name")


                            }


                            Button( onClick = {    pageChild.value=Pages.UnitName.pagevalu}){


                                Text("unit name  ")}


                            Button( onClick = {

                                pageChild.value=Pages.UnitGroupPage.pagevalu
                            }){


                                Text("unit group ")


                            }

                            Button( onClick = {

                                pageChild.value=Pages.Sales.pagevalu
                            }){


                                Text("sales ")


                            }

                        }



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

                    Column(Modifier.align(Alignment.CenterVertically).wrapContentHeight()) {

                        Text("inventory")

                        IconButton(onClick = { pageRoot.value=Pages.InventoryPage.pagevalu }, Modifier)

                        {


                            Icon(imageVector = Icons.Outlined.ShoppingCart)


                            }
                        Text("unit goup")
                        IconButton(onClick = {  pageRoot.value=Pages.InventoryPage.pagevalu}, Modifier)

                        {
                            Icon(imageVector = Icons.Outlined.AccountBox)





                        }
                    }
                }
            }

        }


        }


@ExperimentalFoundationApi

@Composable
fun inventoryMenu(pagex: Double)
{
    var
            page = remember { mutableStateOf(0.0) }


    Column {

        Button( onClick = {
            page.value=Pages.ItemName.pagevalu
          //   print(""+page.value+" iii "+Pages.UnitName.pagevalu.toDouble())
        }){

            Text("item name name")


        }


        Button( onClick = {    page.value=Pages.UnitName.pagevalu}){


            Text("unit name ${page.value} ")}


        Button( onClick = {

            page.value=Pages.UnitGroupPage.pagevalu
        }){


            Text("unit group ${ page.value}")


        }
        if (page.value.equals(Pages.ItemName.pagevalu.toDouble()))
        {
            // Text("unit group ")
            print("0age"+page.value)
              unitNameGroupInput()
        }


        else if (page.value.equals(Pages.UnitGroupPage.pagevalu.toDouble()))

        {
            print("0age"+page.value)

            unitNameGroupInput()
        }else if (page.value.equals(Pages.UnitName.pagevalu.toDouble()))
        {
            print("0age"+page.value)

            unitInput()
        }


    }








}

@Composable
fun menuChild( page :Double)
{

    Card() {

        Column {

            Text(
                "Hello, World!$page",
                Modifier.padding(16.dp).wrapContentWidth().wrapContentHeight()// Outer padding; outside background
                    .background(color = Color.Green) // Solid element background color
                    .padding(1.dp) // Inner padding; inside background, around text
            )


            Text(
                "Hello, World!$page",
                Modifier.padding(16.dp).wrapContentWidth().wrapContentHeight()// Outer padding; outside background
                    .background(color = Color.Green) // Solid element background color
                    .padding(1.dp) // Inner padding; inside background, around text
            )
        }

    }

}