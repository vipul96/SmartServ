import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.*;


public class SmartServ {

    
    public static void main(String args[])  {
        Response res= (Response) given().
                when().request().
                get("https://s3.amazonaws.com/open-to-cors/assignment.json");

        Map<Integer,String> stored=new HashMap < Integer, String > (  );
        Map <?,?>json =  res.jsonPath ().getMap ( "products" );

        for (Map.Entry<?,?> entry : json.entrySet()){
            String string = entry.getKey ().toString ();


            String products= res.jsonPath ().getString ( "products."+string +"");
            Integer popularity=res.jsonPath ().getInt ( "products."+string +".popularity");
            stored.put(popularity,products);
        }
        Map<Integer, String> treeMap = new TreeMap <Integer , String> (Collections.reverseOrder ());
        treeMap.putAll ( stored );

        System.out.println ("No of Records : " + "            " + "Product");
        int i   = 1;
        for (Map.Entry<Integer,String> entry : treeMap.entrySet()) {
            System.out.println ( i + "               " + entry.getValue ());
            i++;
        }


    }

}