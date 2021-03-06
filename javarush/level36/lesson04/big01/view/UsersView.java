package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

import java.util.List;

/**
 * Created by Кира on 08.12.2016.
 */
public class UsersView implements View {

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {

        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }
        List<User> usersSet = modelData.getUsers();

        for (User u : usersSet) {
            System.out.println(u + "\t");
        }

        System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller) {

        this.controller = controller;
    }

    public void fireEventShowAllUsers(){

        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }


}
