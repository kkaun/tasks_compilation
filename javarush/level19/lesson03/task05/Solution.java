package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {

    private static Map<String,String> countries = new HashMap<String,String>();

    static {

        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args){

        final Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Kwadd, Idwad";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "DwadaDwa";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };

        RowItem rowitem = new DataAdapter(customer, contact);

        System.out.println(rowitem.getCountryCode());
        System.out.println(rowitem.getCompany());
        System.out.println(rowitem.getContactFirstName());
        System.out.println(rowitem.getContactLastName());
        System.out.println(rowitem.getDialString());

    }

    public static class DataAdapter implements RowItem {

        private Customer cus;

        private Contact con;

        private String fullName;

        public DataAdapter(Customer customer, Contact contact) {

            this.cus = customer;
            this.con = contact;
            fullName = contact.getName();
        }

        @Override
        public String getCountryCode() {

            String countryName = cus.getCountryName();
            String code = null;

            for (Map.Entry<String,String> map : countries.entrySet()) {

                if(map.getValue().equals(countryName)){
                    code = map.getKey();
                }

            }
            return code;
        }

        @Override
        public String getCompany() {
            return cus.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            fullName = con.getName().split(", ")[1];
            return fullName;
        }

        @Override
        public String getContactLastName() {
            fullName = con.getName().split(", ")[0];
            return fullName;
        }

        @Override
        public String getDialString() {
            return "callto://+" + con.getPhoneNumber().replaceAll("[^0-9]", "");
        }


    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}