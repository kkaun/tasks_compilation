package com.javarush.test.level23.lesson04.home01;

import java.util.*;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    @Override
    public boolean equals(Object obj) {
        Solution object = (Solution) obj;

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return Objects.equals(names, object.names) && Objects.equals(tasks, object.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, tasks);
    }

    public static void main(String[] args){

        Solution sol1 = new Solution();

        List<Solution> s = new ArrayList<>();
        s.add(sol1);

        sol1.refresh();
        System.out.println(s.get(0).equals(sol1));

    }

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();


    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);

    }



    class Task {
    }

    private class TaskDataProvider implements DbDataProvider {

        @Override
        public void refreshAllData(Map criteria) {

            tasks = DbMock.getFakeTasks(criteria);

        }


    }

    private class NameDataProvider implements DbDataProvider {

        @Override
        public void refreshAllData(Map criteria) {

            names = DbMock.getFakeNames(criteria);

        }
    }
}
