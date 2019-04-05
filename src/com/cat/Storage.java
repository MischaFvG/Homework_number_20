package com.cat;

import java.util.List;

public interface Storage {
    void removeAll();

    void removeUser(String id);

    void removeUserByName(String name);

    void addUser(User user);

    void updateUser(String id, String newName, int newAge);

    User getUser(String id);

    List<User> getAllUsers();
}
