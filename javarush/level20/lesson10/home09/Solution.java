package com.javarush.test.level20.lesson10.home09;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    static final long SerialVersionUID = 1L;
}
