//
//import com.mongodb.BasicDBObject
//import com.mongodb.MongoException
//import com.mongodb.client.MongoClient
//import java.net.UnknownHostException
//import java.util.*
//fun main(args: Array<String>) {
//
//    try
//    {
//        val mongo = MongoClient("localhost", 27017)
//
//        val db = mongo.getDB("testDB")
//
//        val table = db.getCollection("person")
//
//        //Reflection example
//        val person = Person("Jon","Doe",20);
//
//        val data = person.javaClass;
//
//
//        //Insert document
//        val document = BasicDBObject()
//        document.put("name", "mkyong")
//        document.put("age", 30)
//        document.put("createdDate", Date())
//        table.insert(document)
//
//        /**** Find and display ****/
//        val searchQuery = BasicDBObject();
//        searchQuery.put("name", "mkyong");
//
//        val cursor = table.find(searchQuery);
//
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//    }
//    catch (e: UnknownHostException) {
//        e.printStackTrace ( );
//    } catch (e: MongoException) {
//        e.printStackTrace();
//    }
//
//}