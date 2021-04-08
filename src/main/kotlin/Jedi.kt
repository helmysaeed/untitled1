import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

public data class Users(val name: String, val passWord: String)
public data class Item(val name: String)

val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
val database = client.getDatabase("test") //normal java driver usage
val col = database.getCollection<Users>()
val colItem = database.getCollection<Item>()


//KMongo extension method
//here the name of the collection by convention is "jedi"
//you can use getCollection<Jedi>("otherjedi") if the collection name is different



