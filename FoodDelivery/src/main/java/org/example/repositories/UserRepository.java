package org.example.repositories;

import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // contains the list of all the users in the app
    // add users, remove users
    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user){
        this.userList.add(user);
    }

    public void removeUser(int userId){
        this.userList.removeIf(user -> user.getId() == userId );
    }

}
