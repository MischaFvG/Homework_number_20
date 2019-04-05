package com.cat;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "jsonUsers.txt";
    private static final File JSON_FILE = new File(FILE_NAME);
    private static Storage storage = new FileStorage();

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        if (JSON_FILE.length() == 0) {
            Gson gson = new Gson();
            Storage storage = new FileStorage();
            String emptyStorage = gson.toJson(storage);
            FileUtils.writeStringToFile(JSON_FILE, emptyStorage, "UTF-8");
        }
        storage = readObjectFromJsonFile();
        System.out.println(storage);
        System.out.println(storage.getUser("954ddc64-abcd-46b6-a87e-28d04def2d65"));
        System.out.println(storage.getAllUsers());
        storage.updateUser("43f4560e-ef0d-4ee7-bcb5-a22aed8a35e5", "Mike", 34);
        System.out.println(storage);
        storage.removeUser("43f4560e-ef0d-4ee7-bcb5-a22aed8a35e5");
        System.out.println(storage);
        storage.removeUserByName("Alex");
        System.out.println(storage);
        storage.removeAll();
        System.out.println(storage);
        storage.addUser(new User("Gunter", 23));
        System.out.println(storage);
        System.out.println("If you would like to save changes press P on your keyboard, please");
        String keyPressed = s.nextLine();
        switch (keyPressed) {
            case "p":
                saveObjectToJsonFile(storage);
                System.out.println("Changes have been saved");
                break;
            default:
                System.out.println("Changes have not been saved");
        }
    }

    public static void saveObjectToJsonFile(Object object) throws IOException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        FileUtils.writeStringToFile(JSON_FILE, jsonString, "UTF-8");
    }

    public static Storage readObjectFromJsonFile() throws IOException {
        Gson gson = new Gson();
        String jsonString = FileUtils.readFileToString(JSON_FILE, "UTF-8");
        Storage storage = gson.fromJson(jsonString, FileStorage.class);
        return storage;
    }
}
