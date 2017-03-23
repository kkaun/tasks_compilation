package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        String r = "D:\\javatest";

        getFileTree(r);

    }


    public static List<String> getFileTree(String root) throws IOException {

        File dir = new File(root);

        List<String> fileNames = new ArrayList<>();

        Stack<File> stack = new Stack<File>();
        stack.push(dir);

        while(!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                for(File f : child.listFiles()) {
                    stack.push(f);
                }
            } else if (child.isFile()) {
                fileNames.add(child.getAbsolutePath());
            }
        }

        for(String f: fileNames){
            System.out.println(f);
        }

        return fileNames;

    }
}
