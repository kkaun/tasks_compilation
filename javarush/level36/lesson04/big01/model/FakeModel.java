package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кира on 08.12.2016.
 */
public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        User user1 = new User("A", 1, 1);
        User user2 = new User("B", 2, 1);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        this.modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {

        throw new UnsupportedOperationException();
    }
}
