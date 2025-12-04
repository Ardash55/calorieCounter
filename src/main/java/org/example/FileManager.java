package org.example;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.example.CalorieApp.user;

public class FileManager {

    public void saveUser() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))){
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
