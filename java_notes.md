### The difference between Map.Entry and Pair

1. Map.Entry is imported from java.util.Map; Pair is imported from javafx.util.Pair

2. Pair is lighter than Map (faster, less memory)

3. A pair stores a pair of key values, while a map stores multiple pairs of key values.

4. how to store key-value pair to a list in both ways:

   - Using **Map.Entry**

   ```java
   List<Map.Entry<String,String>> list1 = new ArrayList();
   Map map = new HashMap();
   map.put("a","A");
   Map.Entry m = (Map.Entry) map.entrySet().iterator().next(); //get an object
   list1.add(m);
   System.out.println(list1.get(0)); //a=A
   ```

   * Using **Pair**
    ```java
   import javafx.util.Pair;
   List< Pair<String, String>>  list1=new ArrayList();
    Pair<String, String> pair = new Pair<>("a", "A");
       pair.getKey();
       pair.getValue();
   list1.add(pair);
   System.out.println(list1.get(0)); //a=A
    ```
   
   Obviously, using Pair is time-efficient and space-saving, and also more straight-forward.
   
   