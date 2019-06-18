import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SmartServ {


    public static void main(String args[])  {



        //"samsung galaxy grand";
        /**
         * give  the title in console
         *
         * */


        /**
         * TestCases:   1. samsung galaxy grand
         *              2. apple ipad
         *              3.apple iphone
         *              4.samsung galaxy
         */
        Scanner sc = new Scanner(System.in);
        String title=sc.nextLine ();
        title.replaceAll ( "\\s","" ).toLowerCase ();

        Response res= (Response) given().
                when().request().
                get("https://s3.amazonaws.com/open-to-cors/assignment.json");

        Map<Integer,String> stored=new HashMap < Integer, String > (  );
        Map <?,?>json =  res.jsonPath ().getMap ( "products" );
        for (Map.Entry<?,?> entry : json.entrySet()){
            String string = entry.getKey ().toString ();
            Pattern pattern=Pattern.compile ( title.replaceAll ( "\\s","" ).toLowerCase ());
            Matcher matcher = pattern.matcher ( res.jsonPath ().getString ( "products."+string +".title" ).replaceAll ( "\\s","" ).toLowerCase ());

           while(matcher.find ()){
               System.out.println (res.jsonPath ().getString ( "products."+string +""));
           }

        }

    }

}






















































// if(res.jsonPath ().getString( "products."+string +".subcategory").equals ( "tablet" )){
//
//         popularity =res.jsonPath ().getInt ( "products."+string +".popularity");
//         products= res.jsonPath ().getString ( "products."+string +"");
//         System.out.println (i +  "   "+ popularity+ "    " + products);
//         i++;
//         }
//         else
//         {
//         popularity =res.jsonPath ().getInt ( "products."+string +".popularity");
//         products= res.jsonPath ().getString ( "products."+string +"");
//         System.out.println (i +  "   "+ popularity+ "    " + products);
//         i++;
//         }







//public class SmartServ {
//
//
//    /***
//     * Multimap for Popularity
//     */
//
//    public static Multimap <Integer, String> stored_popularity = HashMultimap.create();
//
//
//    /***
//     *  Multimap for Title
//     */
//
//
//    public static Multimap <String, String> stored_title = HashMultimap.create();
//
//
//
//    /***
//     *  Multimap for Price
//     */
//
//
//   public static Multimap <Integer, String> stored_price = HashMultimap.create();
//
//
//
//    /**
//     * Incraesing order
//     */
//
//    public static TreeMultimap<Integer, String > increasing_order = TreeMultimap.create(Ordering.natural(), Ordering.natural());
//
//    /**
//     * Decreasing order
//     */
//
//    public static TreeMultimap<Integer, String > decreasing_order = TreeMultimap.create(Ordering.natural().reverse(), Ordering.natural());
//
//
//    public static void main(String args[])  {
//        Response res= (Response) given().
//                when().request().
//                get("https://s3.amazonaws.com/open-to-cors/assignment.json");
//
//
//
//
//        Map <?,?>json =  res.jsonPath ().getMap ( "products" );
//        int i=1;
//
//        for (Map.Entry<?,?> entry : json.entrySet()){
//            String string = entry.getKey ().toString ();
//            String products= res.jsonPath ().getString ( "products."+string +"");
//            String title=res.jsonPath ().getString ( "products."+string+".title" );
//            Integer popularity=res.jsonPath ().getInt ( "products."+string +".popularity");
//            Integer price=res.jsonPath ().getInt ( "products."+string +".price");
////            if(res.jsonPath ().getString( "products."+string +".subcategory").equals ( "mobile" )){
////
////                Integer popularity=res.jsonPath ().getInt ( "products."+string +".popularity");
////                String products= res.jsonPath ().getString ( "products."+string +"");
////                System.out.println (i +  "   "+ popularity+ "    " + products);
////                i++;
////            }
//
//            stored_title.put ( title,products );
//
//
//
//
//            /***
//             *  key=popularity, value= products;
//             */
//
//            stored_popularity.put(popularity,products);
//
//
//            /***
//             *  key=price, value= products;
//             *
//             */
//
//            stored_price.put(price,products);
//
//        }
//
//        TreeMultimap<String, String > increasing_order = TreeMultimap.create(Ordering.natural(), Ordering.natural());
//
//        increasing_order.putAll ( stored_title );
//        int increase=1;
//
//        System.out.println ("No of Records : " + "            " + "Product");
//        for (String title : increasing_order.keySet ()) {
//            System.out.println ( increase + "               " + increasing_order.get (title));
//            increase++;
//        }
//
//
//        SmartServ common = new SmartServ ();
//        common.common ();
//
//
//
//
//    }
//
//
//    public void common()
//    {
//        /***
//         *  Increasing order
//         */
//        int increase=1;
//        int decrease=1;
//
//        increasing_order.putAll ( stored_price );
//
//        System.out.println ("------------------INCREASING         ORDER--------------------");
//        System.out.println ("No of Records : " + "            " + "Product");
//        for (Integer price : increasing_order.keySet ()) {
//            System.out.println ( increase + "               " + increasing_order.get (price));
//            increase++;
//        }
//
//
//        /***
//         *  Decreasing order
//         */
//        decreasing_order.putAll ( stored_price );
//
//        System.out.println ("------------------DECREASING         ORDER--------------------");
//        System.out.println ("No of Records : " + "            " + "Product");
//        for (Integer price : decreasing_order.keySet ()) {
//            System.out.println ( decrease + "               " + decreasing_order.get (price));
//            decrease++;
//        }
//
//
//
//    }
//
//
//}