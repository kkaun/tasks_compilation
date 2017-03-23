package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args){

        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        map.put("parea", null);
        map.put(null, null);
        map.put("street", "Ivanovskaya");
        map.put("code", "534321");

        System.out.println(getCondition(map));
    }

    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder sqlBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

            if ((key != null) && (value != null)) {
                if (!(sqlBuilder.toString().isEmpty())){
                    sqlBuilder.append(" and ");
                }

                sqlBuilder.append(key)
                        .append(" = '")
                        .append(value)
                        .append("'");
            }

        }
        String s = sqlBuilder.toString();
        StringBuilder fin = new StringBuilder(s);

        return fin;
    }
}
