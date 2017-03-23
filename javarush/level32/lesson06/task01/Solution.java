package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        char[] allowedRandomChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] allowedUpperChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] allowedLowerChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] allowedNums = "1234567890".toCharArray();

        SecureRandom random = new SecureRandom();
        StringBuffer password = new StringBuffer();


        password.append(allowedNums[ random.nextInt(allowedNums.length) ]);
        password.append(allowedLowerChars[ random.nextInt(allowedLowerChars.length) ]);
        password.append(allowedUpperChars[ random.nextInt(allowedUpperChars.length) ]);
        password.append(allowedRandomChars[ random.nextInt(allowedRandomChars.length)]);
        password.append(allowedRandomChars[ random.nextInt(allowedRandomChars.length)]);
        password.append(allowedRandomChars[ random.nextInt(allowedRandomChars.length)]);
        password.append(allowedRandomChars[ random.nextInt(allowedRandomChars.length)]);
        password.append(allowedRandomChars[ random.nextInt(allowedRandomChars.length)]);

        bos.write(String.valueOf(password).getBytes());

        return bos;
    }
}
