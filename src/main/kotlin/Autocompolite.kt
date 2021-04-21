import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.CoreTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.TextFieldDelegate
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Position
import androidx.compose.ui.window.Popup
import com.mongodb.BasicDBObject
import com.mongodb.client.model.Filters
import org.bouncycastle.math.raw.Mod
import org.jetbrains.skija.Point
import java.awt.MouseInfo
import java.awt.PointerInfo
import java.util.logging.Filter


@ExperimentalLayout
@ExperimentalFocus
@InternalTextApi
@Composable
fun autocompolit(index:Int?) {
    val index2 = remember { mutableStateOf(index) }

    var pontx = remember { mutableStateOf(0) }
    val ponty = remember { mutableStateOf(0) }

    Column(Modifier, Arrangement.Center, Alignment.CenterHorizontally) {
        val itemName = remember { mutableStateOf(TextFieldValue("")) }
        val unit = remember { mutableStateOf(TextFieldValue("")) }
        val quantity = remember { mutableStateOf(TextFieldValue("")) }

        val items = remember {

            mutableStateOf(colItem.find(BasicDBObject("name", itemName.value.text)).into(mutableListOf()))

        }


        val unitlist = remember {

            mutableStateOf(colItemUnit.find(BasicDBObject("name", unit.value.text)).into(mutableListOf()))

        }
        val tex = remember { mutableStateOf("") }

        val items2 = remember { mutableStateOf(mutableListOf("")) }
        var expanded = remember { mutableStateOf(false) }
        var expandedUnit = remember { mutableStateOf(false) }
        var active = remember { mutableStateOf(false) }

        var visable = remember { mutableStateOf(true) }


        // Draw a rectangle shape with rounded corners inside the popup


        Row(Modifier.fillMaxWidth().fillMaxHeight()) {
            Row(Modifier.weight(1f)) {
                Column(Modifier.wrapContentHeight()) {


                    CoreTextField(
                        value = itemName.value,
                        onValueChange = {
                            itemName.value = it


                            if (it.text.isNotBlank()) {

                                items.value = colItem.find(Filters.regex("name", it.text)).into(mutableListOf())
                                expanded.value = true
                            }

                        },

                        modifier = Modifier.fillMaxWidth().wrapContentHeight().border(0.25.dp, Color.LightGray)
                            .padding(4.dp),
                        cursorColor = Color.Black

                    )


                    Box(modifier = Modifier.fillMaxWidth().offset(0.dp, 0.dp), Alignment.Center) {

                        DropdownMenu(
                            expanded = expanded.value,
                            onDismissRequest = { expanded.value = false },
                            toggle = { Modifier },
                            dropdownOffset = Position(0.dp, 0.dp),
                            dropdownModifier = Modifier.wrapContentWidth(),
                            dropdownContent = {
                                DropdownMenu(
                                    expanded = expanded.value,
                                    onDismissRequest = { expanded.value = false },
                                    toggle = {Modifier.background(Color.Blue)},
                                    dropdownOffset = Position(0.dp,0.dp),
                                    dropdownModifier = Modifier.wrapContentWidth(),
                                    dropdownContent = {
                                        items.value.forEachIndexed { index, s ->
                                            DropdownMenuItem(onClick = {
                                                itemName.value= TextFieldValue(s.name.toString()+"."      )
                                                expanded.value=false
                                                active.value=false
                                            }
                                                ,Modifier.fillMaxWidth()) {

                                                s.name?.let { Text(it,Modifier) }
                                            }
                                        }
                                    }





                                )


                            }


                        )


                    }

                }
            }
            Row(Modifier.weight(1f)) {
                Column(Modifier.wrapContentHeight()) {


                    CoreTextField(
                        value = unit.value,
                        onValueChange = {

                            unit.value = it
                            if (it.text.isNotBlank()) {
                                unitlist.value = colItemUnit.find(Filters.regex("name", it.text)).into(mutableListOf())
                                expandedUnit.value = true
                            }

                        },
                        modifier = Modifier.fillMaxWidth().wrapContentHeight().border(0.5.dp, Color.LightGray)
                            .padding(4.dp),

                        cursorColor = Color.Black,


                        )

                    Box(modifier = Modifier.fillMaxWidth().offset(0.dp, 0.dp)) {

                        DropdownMenu(
                            expanded = expandedUnit.value,
                            onDismissRequest = { expandedUnit.value = false },
                            toggle = { Modifier },
                            dropdownOffset = Position(0.dp, 0.dp),
                            dropdownModifier = Modifier.wrapContentWidth(),
                            dropdownContent = {
                                DropdownMenu(
                                    expanded = expandedUnit.value,
                                    onDismissRequest = { expandedUnit.value = false },
                                    toggle = {Modifier.background(Color.Blue)},
                                    dropdownOffset = Position(0.dp,0.dp),
                                    dropdownModifier = Modifier.wrapContentWidth(),
                                    dropdownContent = {
                                        unitlist.value.forEachIndexed { index, s ->
                                            DropdownMenuItem(onClick = {
                                                unit.value= TextFieldValue(s.name.toString()+"."      )
                                                expandedUnit.value=false
                                            }
                                                ,Modifier.fillMaxWidth()) {

                                                s.name?.let { Text(it,Modifier) }
                                            }
                                        }
                                    }





                                )


                            }


                        )


                    }



                }
            }

            Row(Modifier.weight(0.5f)) {

                CoreTextField(
                    value = quantity.value,
                    onValueChange = {
                        quantity.value = it


                        if (it.text.isNotBlank()) {


                        }

                    },


                    modifier = Modifier.fillMaxWidth().wrapContentHeight().border(0.25.dp, Color.LightGray)
                        .padding(4.dp),

                    cursorColor = Color.Black


                )


            }

        }


    }

}


