package HeadsFirst;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Кира on 15.04.2016.
 */
public class Iter {
    public static void main(String[] args) {
        Map<String, String> pets = new HashMap<String, String>();
        pets.put("Мурзик", "кот");
        pets.put("Бобик", "собака");
        pets.put("Кеша", "попугай");

        Iterator<Map.Entry<String, String>> iterator = pets.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry pet = (Map.Entry) iterator.next();
            System.out.println(pet.getKey() + " это " + pet.getValue());
        }
    }
}
