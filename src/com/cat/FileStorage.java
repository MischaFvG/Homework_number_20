package com.cat;

import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {

    private List<User> userList = new ArrayList<>();

    public FileStorage() {
    }

    @Override
    public void removeAll() {
       userList.removeAll(userList);
    }

    @Override
    public void removeUser(String id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.remove(userList.get(i));
            }
        }
    }

    @Override
    public void removeUserByName(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                userList.remove(userList.get(i));
            }
        }
    }


    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void updateUser(String id, String newName, int newAge) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.get(i).setName(newName);
                userList.get(i).setAge(newAge);
            }
        }
    }

    @Override
    public User getUser(String id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public String toString() {
        return "FileStorage{" +
                "userList=" + userList +
                '}';
    }
}
